package spring.autowire.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/autowire/constructor/Beans.xml");
		ConstructorBean bean = (ConstructorBean) applicationContext.getBean("constructorBean");
		bean.execute();
	}
}
