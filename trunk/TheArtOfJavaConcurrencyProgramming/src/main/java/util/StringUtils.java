package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

	public static String dateFormat(String pattern) {
		return dateFormat(pattern, new Date());
	}
	
	public static String dateFormat(String pattern, Date date) {
		DateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
}
