package spring.di.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/di/setter/Beans.xml");
		SetterBean setterBean = (SetterBean) applicationContext.getBean("setterBean");
		setterBean.execute();
	}
}
