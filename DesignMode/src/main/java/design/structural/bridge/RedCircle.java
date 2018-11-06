package design.structural.bridge;

public class RedCircle implements DrawAPI {

	public void drawCircle(int radius, int x, int y) {
		
		System.out.println("RedCircle : radius=" + radius + " X=" + x + " Y=" + y);
	}
}
