package spring.ioc;

public class ParentBean {
	
	private String parent;

	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public void execute() {
		
		System.out.println(this.getClass() + "parent = " + parent);
	}
	
	public void init1() {
		
		System.out.println(this.getClass() + " init");
	}
	
	public void destroy1() {
		
		System.out.println(this.getClass() + " destroy");
	}
}
