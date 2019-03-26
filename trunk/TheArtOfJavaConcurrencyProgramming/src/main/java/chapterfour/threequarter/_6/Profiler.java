package chapterfour.threequarter._6;

import util.SleepUtils;

public class Profiler {

	private static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>() {
		
		protected Long initialValue() {
			
			return System.currentTimeMillis();
		};
	};
	
	public static final void begin() {
		
		TIME_THREADLOCAL.set(System.currentTimeMillis());
	}
	
	public static final long end() {
		
		return System.currentTimeMillis() - TIME_THREADLOCAL.get();
	}
	
	public static void main(String[] args) {
		
		Profiler.begin();
		SleepUtils.second(1);
		System.out.println("Cost: " + Profiler.end() + " mills");
	}
}
