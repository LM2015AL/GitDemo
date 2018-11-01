package spring.autowire.bytype;

import spring.autowire.AutowireBean;

public class ByTypeBean {

	private AutowireBean autowireBean;
	private String value;
	public void setAutowireBean(AutowireBean autowireBean) {
		this.autowireBean = autowireBean;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public void execute() {
		
		System.out.println("value = " + value);
		autowireBean.execute();
	}
	
}
