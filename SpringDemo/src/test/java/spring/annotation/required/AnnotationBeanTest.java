package spring.annotation.required;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/annotation/required/Beans.xml");
		RequiredBean bean = (RequiredBean) applicationContext.getBean("requiredBean");
		System.out.println(bean);
	}
}
