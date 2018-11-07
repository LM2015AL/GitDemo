package design.behaviour.chainofresponsibility;

public class InfoLogger extends AbstractLogger {

	public InfoLogger(int level) {
		
		super.level = level;
	}
	
	@Override
	protected void write(String message) {

		System.out.println("InfoLogger " + message);
	}
}
