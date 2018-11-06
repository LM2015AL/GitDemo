package design.structural.bridge;

public class GreenCircle implements DrawAPI {

	public void drawCircle(int radius, int x, int y) {
		
		System.out.println("GreenCircle : radius=" + radius + " X=" + x + " Y=" + y);
	}
}
