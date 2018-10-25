
package spring.ioc.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class ApplicationContextTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring/ioc/applicationcontext/Beans.xml");
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/ioc/applicationcontext/Beans.xml");
//		ApplicationContext applicationContext = new WebXmlApplicationContext
		ApplicationContextBean bean = (ApplicationContextBean) applicationContext.getBean("bean");
		bean.execute();
	}
}
