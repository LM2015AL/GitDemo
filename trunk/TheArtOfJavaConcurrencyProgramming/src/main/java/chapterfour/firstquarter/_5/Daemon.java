package chapterfour.firstquarter._5;

import util.SleepUtils;

public class Daemon {

	public static void main(String[] args) {
		
		Thread thread = new Thread(new DaemonRunner(), "DaemonRunnerThread");
		thread.setDaemon(true);
		thread.start();
	}
	
	static class DaemonRunner implements Runnable {

		public void run() {

			try {
				SleepUtils.second(10);
			} finally {
				System.out.println("DaemonRunnerThread finally run.");
			}
		}
		
	}
}
