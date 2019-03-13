package util;

import java.util.concurrent.TimeUnit;

/**
 * @author ludm
 *	休眠工具类
 */
public class SleepUtils {

	/**
	 * 按秒休眠
	 * @param timeout
	 */
	public static final void second(int timeout) {
		
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
