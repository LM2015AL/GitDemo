package spring.autowire.constructor;

import spring.autowire.AutowireBean;

public class ConstructorBean {

	private AutowireBean autowireBean;
	private String value;
	
	public ConstructorBean(AutowireBean autowireBean, String value) {
		super();
		this.autowireBean = autowireBean;
		this.value = value;
	}

	public void execute() {
		
		System.out.println("value = " + value);
		autowireBean.execute();
	}
	
}
