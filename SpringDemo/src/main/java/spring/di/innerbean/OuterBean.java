package spring.di.innerbean;

import spring.di.BaseDIBean;

public class OuterBean {

	private BaseDIBean bean;
	
	public OuterBean() {
		super();
		System.out.println("OuterBean");
	}

	public void setBean(BaseDIBean bean) {
		this.bean = bean;
	}
	
	public void execute() {
		
		bean.print();
	}

}
