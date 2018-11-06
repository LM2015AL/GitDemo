package spring.annotation;

public class AnnotationBean {

	public AnnotationBean() {
		super();
		System.out.println("AnnotationBean constructor");
	}

	@Override
	public String toString() {
		return "AnnotationBean [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
