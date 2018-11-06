package design.structural.decorator;

public class RedShapeDecorator extends ShapeDecorator {

	public RedShapeDecorator(Shape decoratorShape) {
		super(decoratorShape);
	}

	@Override
	public void draw() {
		super.draw();
		this.setRed();
	}
	
	private void setRed() {
		
		System.out.println("Red");
	}
}
