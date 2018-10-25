package spring.ioc;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class IOCTest {

	public static void main(String[] args) {
		
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/ioc/IOCBeans.xml");
		SingletonBean singletonBean = (SingletonBean) applicationContext.getBean("singletonBean");
		SingletonBean singletonBean1 = (SingletonBean) applicationContext.getBean("singletonBean");
		PrototypeBean prototypeBean = (PrototypeBean) applicationContext.getBean("prototypeBean");
		PrototypeBean prototypeBean1 = (PrototypeBean) applicationContext.getBean("prototypeBean");
		System.out.println("singletonBean:" + singletonBean.toString());
		System.out.println("singletonBean1:" + singletonBean1.toString());
		System.out.println("prototypeBean:" + prototypeBean.toString());
		System.out.println("prototypeBean1:" + prototypeBean1.toString());
//		ParentBean parentBean = (ParentBean) applicationContext.getBean("parentBean");
		singletonBean.execute();
		prototypeBean.execute();
//		parentBean.execute();
		applicationContext.registerShutdownHook();
	}
}
