package design.behaviour.chainofresponsibility;

public class ChainPatternDemo {

	private static AbstractLogger getChainOfLoggers() {

		AbstractLogger debugLogger = new DebugLogger(AbstractLogger.DEBUG);
		AbstractLogger infoLogger = new InfoLogger(AbstractLogger.INFO);
		AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);

		errorLogger.setNextLogger(debugLogger);
		debugLogger.setNextLogger(infoLogger);

		return errorLogger;
	}

	public static void main(String[] args) {
		AbstractLogger loggerChain = getChainOfLoggers();

		loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");
		
		loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

		loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
	}
}