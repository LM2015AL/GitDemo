package spring.ioc.beanfactory;

public class BeanFactoryBean {
	
	public BeanFactoryBean() {
		System.out.println(this.getClass());
	}

	private String value;
	
	public void setValue(String value) {
		this.value = value;
	}

	public void execute() {
		System.out.println("value = " + value);
	}
}
