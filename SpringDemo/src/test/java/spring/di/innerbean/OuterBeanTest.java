package spring.di.innerbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OuterBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/di/innerbean/Beans.xml");
		OuterBean outerBean = (OuterBean) applicationContext.getBean("outerBean");
		outerBean.execute();
	}
}
