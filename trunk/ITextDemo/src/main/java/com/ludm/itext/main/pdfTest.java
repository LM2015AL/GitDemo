package com.ludm.itext.main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class pdfTest {

	public static void main(String[] args) throws FileNotFoundException,
			DocumentException {
		//实现A4纸页面 并且横向显示（不设置则为纵向）
		Document document = new Document(PageSize.A4.rotate());
		PdfWriter pdfWriter = PdfWriter.getInstance(document,new FileOutputStream("F:/Repositories/GIT/JavaGit/trunk/ITextDemo/src/main/resources/zqzr.pdf"));
		// 设置用户密码, 所有者密码,用户权限,所有者权限
		pdfWriter.setEncryption("userpassword".getBytes(), "ownerPassword".getBytes(),  PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
		// 打开文档
		document.open();
//        // 创建第一页（如果只有一页的话，这一步可以省略）
//        document.newPage();
//		// 加入文档内容
//		document.add(new Paragraph("my first pdf demo"));
		// 关闭文档
		document.close();
		pdfWriter.close();
	}
}
