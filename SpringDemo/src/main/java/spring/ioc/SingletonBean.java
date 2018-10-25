package spring.ioc;

public class SingletonBean {
	
	private String value;
	private String parent;

	public void setValue(String value) {
		this.value = value;
	}
	
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public void execute() {
		
		System.out.println(this.getClass() + "value = " + value + " parent = " + parent);
	}
	
	public void init() {
		
		System.out.println(this.getClass() + " init");
	}
	
	public void destroy() {
		
		System.out.println(this.getClass() + " destroy");
	}
}
