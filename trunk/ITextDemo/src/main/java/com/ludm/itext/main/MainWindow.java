package com.ludm.itext.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfSignatureAppearance.RenderingMode;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.security.BouncyCastleDigest;
import com.itextpdf.text.pdf.security.DigestAlgorithms;
import com.itextpdf.text.pdf.security.ExternalDigest;
import com.itextpdf.text.pdf.security.ExternalSignature;
import com.itextpdf.text.pdf.security.MakeSignature;
import com.itextpdf.text.pdf.security.MakeSignature.CryptoStandard;
import com.itextpdf.text.pdf.security.PrivateKeySignature;

public class MainWindow {
	
	public static final String ROOT_PATH = System.getProperty("user.dir");
	public static final String RESOURCES_PATH = ROOT_PATH + "\\src\\main\\resources\\";
	// 私钥
	public static final String KEYSTORE = RESOURCES_PATH + "test.p12";
	// 私钥密码
	public static final char[] PASSWORD = "123456".toCharArray();
	// 测试源pdf
	public static final String SRC = RESOURCES_PATH + "测试模板.pdf";
	// 加签pdf
	public static final String DEST;
	// 签字图片
	public static final String pic = RESOURCES_PATH + "test.jpg";
	// 签章图片
	public static final String SIGN = RESOURCES_PATH + "testSign.jpg";
	// 字体
	public static final String FONTS = "c:\\windows\\Fonts\\simsunb.ttf";
	// 用户密码
	public static final String userPWD = "123456";
	// 所有者密码
	public static final String ownerPWD = "000000";
	
	static {
		String timestamp = new SimpleDateFormat("YYYYMMDDHHmmss").format(new Date());
		DEST = RESOURCES_PATH + "加签表单" + timestamp + ".pdf";
	}

	public static void main(String[] args) {
        try {
        	//读取keystore ，获得私钥和证书链
            KeyStore ks = KeyStore.getInstance("PKCS12");
            ks.load(new FileInputStream(KEYSTORE), PASSWORD);
            String alias = (String)ks.aliases().nextElement();
            PrivateKey pk = (PrivateKey) ks.getKey(alias, PASSWORD);
            Certificate[] chain = ks.getCertificateChain(alias);
            //new一个上边自定义的方法对象，调用签名方法
            MainWindow app = new MainWindow();
            app.sign(SRC, String.format(DEST, 3), chain, pk, DigestAlgorithms.SHA1, null, CryptoStandard.CMS, "pdf", "CN");
            System.out.println("success");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        } 
	}

	public void sign(String src  //需要签章的pdf文件路径
            , String dest  // 签完章的pdf文件路径
            , Certificate[] chain //证书链
            , PrivateKey pk //签名私钥
            , String digestAlgorithm  //摘要算法名称，例如SHA-1
            , String provider  // 密钥算法提供者，可以为null
            , CryptoStandard subfilter //数字签名格式，itext有2种
            , String reason  //签名的原因，显示在pdf签名属性中，随便填
            , String location) //签名的地点，显示在pdf签名属性中，随便填
                    throws GeneralSecurityException, IOException, DocumentException {
        // Creating the reader and the stamper，开始pdfreader
        PdfReader reader = new PdfReader(src);
        //目标文件输出流
        FileOutputStream os = new FileOutputStream(dest);
        //创建签章工具PdfStamper ，最后一个boolean参数 
        //false的话，pdf文件只允许被签名一次，多次签名，最后一次有效
        //true的话，pdf可以被追加签名，验签工具可以识别出每次签名之后文档是否被修改
        PdfStamper stamper = PdfStamper.createSignature(reader, os, '\0', null, false);
//        PdfStamper stamper = new PdfStamper(reader, os);
        
        /**
         * 表单加密
         */
        stamper.setEncryption(userPWD.getBytes(), ownerPWD.getBytes(), PdfWriter.ALLOW_SCREENREADERS, true);
        
        /**
         * 加签字图片
         */
        this.addImage(stamper, pic);
        
        /**
         * 加水印
         */
        this.addWaterMark(stamper, reader);
        
        /**
         * 加签章
         */
        // 获取数字签章属性对象，设定数字签章的属性
        PdfSignatureAppearance appearance = stamper.getSignatureAppearance();
        appearance.setReason(reason);
        appearance.setLocation(location);
        //设置签名的位置，页码，签名域名称，多次追加签名的时候，签名预名称不能一样
        //签名的位置，是图章相对于pdf页面的位置坐标，原点为pdf页面左下角
        //四个参数的分别是，图章左下角x，图章左下角y，图章右上角x，图章右上角y
        appearance.setVisibleSignature(new Rectangle(400, 200, 500, 300), 1, "sig1");
        //读取图章图片，这个image是itext包的image
        Image image = Image.getInstance(SIGN); 
        appearance.setSignatureGraphic(image); 
        appearance.setCertificationLevel(PdfSignatureAppearance.NOT_CERTIFIED);
        //设置图章的显示方式，如下选择的是只显示图章（还有其他的模式，可以图章和签名描述一同显示）
        appearance.setRenderingMode(RenderingMode.GRAPHIC);

        // 这里的itext提供了2个用于签名的接口，可以自己实现，后边着重说这个实现
        // 摘要算法
        ExternalDigest digest = new BouncyCastleDigest();
        // 签名算法
        ExternalSignature signature = new PrivateKeySignature(pk, digestAlgorithm, null);
        // 调用itext签名方法完成pdf签章
        MakeSignature.signDetached(appearance, digest, signature, chain, null, null, null, 0, subfilter);
    }
	
	private boolean addImage(PdfStamper ps, String filename) {
		
		try {
			Image image = Image.getInstance(filename);
			image.setAlignment(Image.MIDDLE);
			image.setAbsolutePosition(200, 200);
			image.scaleToFit(100,100);
			PdfContentByte pcb = ps.getOverContent(1);
			pcb.addImage(image);
			return true;
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean addWaterMark(PdfStamper ps, PdfReader reader) {
		
		BaseFont baseFont = null;
		try {
			baseFont = BaseFont.createFont(FONTS, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		PdfContentByte content = null;
		int textWidth = 15;
		int textHeight = 800;
		int total = reader.getNumberOfPages();
		
		for (int i = 1; i <= total; i++) {
			
			content = ps.getOverContent(i);
			content.beginText();
			content.setColorFill(BaseColor.GRAY);
			content.setFontAndSize(baseFont, 30);
			content.setTextMatrix(textWidth, textHeight);
			content.showTextAligned(Element.ALIGN_LEFT, "测试水印", 15, 80, 45);
			content.endText();
		}
		return false;
	}
}
