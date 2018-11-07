package design.structural.proxy;

public class RealImage implements Image {

	private String fileName;
	
	public RealImage(String fileName) {
		super();
		this.fileName = fileName;
		this.loadFromDisk();
	}

	public void display() {
		System.out.println("display" + fileName);
	}
	
	private void loadFromDisk() {
		System.out.println("loadFromDisk " + fileName);
	}

}
