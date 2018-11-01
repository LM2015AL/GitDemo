package spring.autowire.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.autowire.AutowireBean;

public class ByTypeBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/autowire/bytype/Beans.xml");
		ByTypeBean bean = (ByTypeBean) applicationContext.getBean("byTypeBean");
		bean.execute();
	}
}
