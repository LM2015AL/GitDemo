package quartz.triggers.simpletrigger;

import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.DateBuilder.*;

import org.quartz.DateBuilder.IntervalUnit;
import org.quartz.JobKey;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;

public class SimpleTriggers {
	
	/**
	 * 指定时间开始触发，不重复
	 * @return
	 */
	public Trigger getTrigger1() {
		SimpleTrigger trigger1 = (SimpleTrigger) newTrigger() 
		        .withIdentity("trigger1", "SimpleTriggersGroup")
//		        .startAt(dateOf(14, 8, 30))                     // some Date 
		        .startAt(futureDate(3, IntervalUnit.SECOND))                     // some Date 
//		        .forJob("job1", "SimpleTriggersGroup")                 // identify job with name, group strings
		        .build();
		return trigger1;
	}
	
	/**
	 * 指定时间触发，每隔10秒执行一次，重复10次
	 * @return
	 */
	public Trigger getTrigger3() {
		SimpleTrigger trigger3 = newTrigger()
		        .withIdentity("trigger3", "SimpleTriggersGroup")
		        .startAt(futureDate(5, IntervalUnit.SECOND))  // if a start time is not given (if this line were omitted), "now" is implied
		        .withSchedule(simpleSchedule()
		            .withIntervalInSeconds(10)
		            .withRepeatCount(10)) // note that 10 repeats will give a total of 11 firings
		        .forJob(new JobKey("JobDetailName", "JobDetailGroup")) // identify job with handle to its JobDetail itself
		        .build();
		return trigger3;
	}
	
	/**
	 * 5分钟以后开始触发，仅执行一次
	 * @return
	 */
	public Trigger getTrigger5() {
		SimpleTrigger trigger5 = (SimpleTrigger) newTrigger() 
		        .withIdentity("trigger5", "group1")
		        .startAt(futureDate(5, IntervalUnit.MINUTE)) // use DateBuilder to create a date in the future
//		        .forJob(myJobKey) // identify job with its JobKey
		        .build();
		return trigger5;
	}
	
	/**
	 * 立即触发，每个5分钟执行一次，直到22:00
	 * @return
	 */
	public Trigger getTrigger7() {
		SimpleTrigger trigger7 = newTrigger()
		        .withIdentity("trigger7", "group1")
		        .withSchedule(simpleSchedule()
		            .withIntervalInMinutes(5)
		            .repeatForever())
		        .endAt(dateOf(22, 0, 0))
		        .build();
		return trigger7;
	}
	
	/**
	 * 建立一个触发器，将在下一个小时的整点触发，然后每2小时重复一次
	 * @return
	 */
	public Trigger getTrigger8() {
		SimpleTrigger trigger8 = newTrigger()
		        .withIdentity("trigger8") // because group is not specified, "trigger8" will be in the default group
		        .startAt(evenHourDate(null)) // get the next even-hour (minutes and seconds zero ("00:00"))
		        .withSchedule(simpleSchedule()
		            .withIntervalInHours(2)
		            .repeatForever())
		        // note that in this example, 'forJob(..)' is not called which is valid 
		        // if the trigger is passed to the scheduler along with the job  
		        .build();
		return trigger8;
	}

}
