package quartz.triggers.crontrigger;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DateBuilder.*;
import java.util.TimeZone;
import org.quartz.Trigger;
	
public class CronTriggers {

	/**
	 * 建立一个触发器，每隔一分钟，每天上午8点至下午5点之间
	 * @return
	 */
	public Trigger getTrigger() {
		Trigger trigger = newTrigger()
			    .withIdentity("trigger", "CronTriggersGroup")
			    .withSchedule(cronSchedule("0 0/1 8-17 * * ?"))
//			    .forJob("myJob", "group1")
			    .build();
		return trigger;
	}
	
	/**
	 * 建立一个触发器，将在上午10:42每天发射
	 * @return
	 */
	public Trigger getTrigger1() {
		Trigger trigger1 = newTrigger()
			    .withIdentity("trigger1", "CronTriggersGroup")
			    .withSchedule(dailyAtHourAndMinute(10, 42))
//			    .forJob(myJobKey)
			    .build();
		return trigger1;
	}
	
	/**
	 * 建立一个触发器，将在上午10:42每天发射
	 * @return
	 */
	public Trigger getTrigger2() {
		Trigger trigger2 = newTrigger()
			    .withIdentity("trigger2", "CronTriggersGroup")
			    .withSchedule(cronSchedule("0 42 10 * * ?"))
//			    .forJob(myJobKey)
			    .build();
		return trigger2;
	}
	
	/**
	 * 建立一个触发器，将在星期三上午10:42在TimeZone（系统默认值）之外触发
	 * @return
	 */
	public Trigger getTrigger3() {
		Trigger trigger3 = newTrigger()
			    .withIdentity("trigger3", "CronTriggersGroup")
			    .withSchedule(weeklyOnDayAndHourAndMinute(WEDNESDAY, 10, 42))
//			    .forJob("")
//			    .inTimeZone(TimeZone.getTimeZone("America/Los_Angeles"))
			    .build();
		return trigger3;
	}
	
	/**
	 * 建立一个触发器，将在星期三上午10:42在TimeZone（系统默认值）之外触发
	 * @return
	 */
	public Trigger getTrigger4() {
		Trigger trigger4 = newTrigger()
			    .withIdentity("trigger4", "CronTriggersGroup")
			    .withSchedule(cronSchedule("0 42 10 ? * WED"))
//			    .inTimeZone(TimeZone.getTimeZone("America/Los_Angeles"))
//			    .forJob(myJobKey)
			    .build();
		return trigger4;
	}
}
