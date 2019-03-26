package chapterfour.threequarter._2;

import constants.Constants;
import util.SleepUtils;
import util.StringUtils;

public class WaitNotify {
	
	static boolean flag = true;
	static Object lock = new Object();
	
	public static void main(String[] args) {
		Thread waitThread = new Thread(new Wait(), "WaitThread");
		waitThread.start();
		SleepUtils.second(1);
		Thread notifyThread = new Thread(new Notify(), "NotifyThread");
		notifyThread.start();
	}

	static class Wait implements Runnable {
		
		public void run() {
			
			synchronized (lock) {
				
				while (flag) {
					
					System.out.println(Thread.currentThread() + " flag is true. wait@ " + StringUtils.dateFormat(Constants.PATTERN));
					try {
						lock.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(Thread.currentThread() + " flag is false. running@ " + StringUtils.dateFormat(Constants.PATTERN));
			}
		}
	}
	
	static class Notify implements Runnable {
		
		public void run() {
			
			synchronized (lock) {
				
				System.out.println(Thread.currentThread() + " hold lock. notify @ " + StringUtils.dateFormat(Constants.PATTERN));
				lock.notifyAll();
				flag = false;
				SleepUtils.second(5);
			}
			
			synchronized (lock) {
				
				System.out.println(Thread.currentThread() + "hold lock again. sleep @ " + StringUtils.dateFormat(Constants.PATTERN));
				SleepUtils.second(5);
			}
		}
	}
}
