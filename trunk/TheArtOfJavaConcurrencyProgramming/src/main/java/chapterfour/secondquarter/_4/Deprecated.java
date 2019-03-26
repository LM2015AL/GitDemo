package chapterfour.secondquarter._4;

import constants.Constants;
import util.SleepUtils;
import util.StringUtils;

public class Deprecated {

	public static void main(String[] args) {
		
		Thread printThread = new Thread(new Runner(), "PrintThread");
		printThread.setDaemon(true);
		printThread.start();
		SleepUtils.second(3);
		// 将PrintThread进行暂停，输出内容工作停止
		printThread.suspend();
		System.out.println("main suspend PrintThread at " + StringUtils.dateFormat(Constants.PATTERN));
		SleepUtils.second(3);
		// 将PrintThread进行恢复，输出内容工作继续
		printThread.resume();
		System.out.println("main resume PrintThread at " + StringUtils.dateFormat(Constants.PATTERN));
		SleepUtils.second(3);
		// 将PrintThread进行终止，输出内容工作停止
		printThread.stop();
		System.out.println("main stop PrintThread at " + StringUtils.dateFormat(Constants.PATTERN));
		SleepUtils.second(3);
		
	}
	
	static class Runner implements Runnable {

		public void run() {

			while(true) {
				
				System.out.println(Thread.currentThread().getName() + " Run at " + StringUtils.dateFormat(Constants.PATTERN));
				SleepUtils.second(1);
			}
		}
		
	}
}
