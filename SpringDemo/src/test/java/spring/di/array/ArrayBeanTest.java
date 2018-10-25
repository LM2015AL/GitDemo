package spring.di.array;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ArrayBeanTest {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/di/array/Beans.xml");
		ArrayBean arrayBean = (ArrayBean) applicationContext.getBean("arrayBean");
		arrayBean.getList();
		arrayBean.getSet();
		arrayBean.getMap();
		arrayBean.getProperties();
	}
}
