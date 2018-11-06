package design.structural.decorator;

public abstract class ShapeDecorator implements Shape {
	
	private Shape decoratorShape;
	
	public ShapeDecorator(Shape decoratorShape) {
		super();
		this.decoratorShape = decoratorShape;
	}

	public void draw() {
		decoratorShape.draw();
	}

}
