package design.behaviour.chainofresponsibility;

public class ErrorLogger extends AbstractLogger {

	public ErrorLogger(int level) {
		
		super.level = level;
	}
	
	@Override
	protected void write(String message) {

		System.out.println("ErrorLogger " + message);
	}
}
