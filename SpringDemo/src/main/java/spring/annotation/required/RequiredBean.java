package spring.annotation.required;

import org.springframework.beans.factory.annotation.Required;

import spring.annotation.AnnotationBean;

public class RequiredBean {

	private AnnotationBean annotationBean;
	private String name;
	private int age;
	
	@Required
	public void setAnnotationBean(AnnotationBean annotationBean) {
		this.annotationBean = annotationBean;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
	@Required
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "RequiredBean [annotationBean=" + annotationBean + ", name=" + name + ", age=" + age + "]";
	}
	
}
