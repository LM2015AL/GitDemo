package design.behaviour.chainofresponsibility;

public class DebugLogger extends AbstractLogger {

	public DebugLogger(int level) {
		
		super.level = level;
	}
	
	@Override
	protected void write(String message) {

		System.out.println("DebugLogger " + message);
	}
}
