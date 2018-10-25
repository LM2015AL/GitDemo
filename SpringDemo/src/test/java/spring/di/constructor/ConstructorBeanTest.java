package spring.di.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/di/constructor/Beans.xml");
		ConstructorBean constructorBean = (ConstructorBean) applicationContext.getBean("constructorBean");
		constructorBean.execute();
	}
}
