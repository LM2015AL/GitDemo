package spring.autowire.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.autowire.AutowireBean;

public class ByNameBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/autowire/byname/Beans.xml");
		ByNameBean bean = (ByNameBean) applicationContext.getBean("byNameBean");
		bean.execute();
	}
}
