package spring.di.setter;

import spring.di.BaseDIBean;

public class SetterBean {

	private BaseDIBean bean;
	
	public SetterBean() {
		super();
		System.out.println("SetterBean");
	}

	public void setBean(BaseDIBean bean) {
		this.bean = bean;
	}
	
	public void execute() {
		
		bean.print();
	}
}
