package chapterfour.secondquarter._5;

import util.SleepUtils;

public class Shutdown {

	public static void main(String[] args) {
		
		Runner runner = new Runner();
		Thread countThread = new Thread(runner, "CountThread");
		countThread.start();
		SleepUtils.second(1);
		countThread.interrupt();
		Runner two = new Runner();
		countThread = new Thread(two, "CountThread");
		countThread.start();
		SleepUtils.second(1);
		two.cancel();
	}
	
	private static class Runner implements Runnable {

		private long i;
		private volatile boolean on = true;
		public void run() {
			
			while (on && !Thread.currentThread().isInterrupted()) {
				
				i++;
			}
			System.out.println("Count i = " + i);
		}
		
		public void cancel() {
			on = false;
		}
	}
}
