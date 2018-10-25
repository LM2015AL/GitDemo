package spring.ioc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PrototypeBean implements InitializingBean, DisposableBean {
	
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

	public void destroy() throws Exception {
		
		System.out.println(this.getClass() + " after destroy");
	}

	public void afterPropertiesSet() throws Exception {
		
		System.out.println(this.getClass() + " afterPropertiesSet");}
}
