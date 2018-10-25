package spring.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class BeanPostProcessorImpl implements BeanPostProcessor, Ordered {

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessorImpl			postProcessBeforeInitialization: " + beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessorImpl			postProcessAfterInitialization: " + beanName);
		return bean;
	}

	public int getOrder() {
		return 1;
	}

}
