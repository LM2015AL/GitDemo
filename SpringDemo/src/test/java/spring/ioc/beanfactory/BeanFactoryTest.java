package spring.ioc.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanFactoryTest {

	public static void main(String[] args) throws InterruptedException {
		
		Resource resource = new ClassPathResource("/spring/ioc/beanfactory/Beans.xml");
		
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
		System.out.println("XmlBeanFactory");
		BeanFactoryBean bean = (BeanFactoryBean) xmlBeanFactory.getBean("bean");
		System.out.println("getBean");
		bean.execute();
		
		// XmlBeanFactory废除替代方法
		// BeanFactory启动时，不会创建Bean实例，getBean()时创建
//		BeanFactory beanFactory = new DefaultListableBeanFactory();
//		BeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) beanFactory);
//		reader.loadBeanDefinitions(resource);
//		System.out.println("loadBeanDefinitions");
//		BeanFactoryBean bean = (BeanFactoryBean) beanFactory.getBean("bean");
//		System.out.println("getBean");
//		bean.execute();
	}
}
