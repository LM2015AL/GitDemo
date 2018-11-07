package design.behaviour.chainofresponsibility;

public abstract class AbstractLogger {

	public final static int DEBUG = 1;
	public final static int INFO = 2;
	public final static int ERROR = 3;

	protected int level;

	protected AbstractLogger nextLogger;

	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message) {
		if (this.level <= level) {
			write(message);
		}
		if (nextLogger != null) {
			nextLogger.logMessage(level, message);
		}
	}

	protected abstract void write(String message);
}
