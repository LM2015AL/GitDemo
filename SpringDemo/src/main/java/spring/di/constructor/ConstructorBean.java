package spring.di.constructor;

import spring.di.BaseDIBean;
import spring.di.BaseDIBean2;

public class ConstructorBean {

	private BaseDIBean bean;
	private BaseDIBean2 bean2;
	private String name;
	private int age;
	
	public ConstructorBean(BaseDIBean bean, BaseDIBean2 bean2, String name, int age) {
		super();
		System.out.println("ConstructorBean");
		this.bean = bean;
		this.bean2 = bean2;
		this.name = name;
		this.age = age;
	}

	public void execute() {
		
		bean.print();
		bean2.print();
		System.out.println("name = " + name + " age = " + age);
	}
}
