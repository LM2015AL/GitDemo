package spring.ioc.applicationcontext;

public class ApplicationContextBean {
	
	public ApplicationContextBean() {
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
