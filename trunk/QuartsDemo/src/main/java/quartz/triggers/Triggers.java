package quartz.triggers;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.ArrayList;
import java.util.Date;

import org.quartz.Trigger;

public class Triggers {
	
	public Trigger getTrigger() {
		Trigger trigger = newTrigger()
				.withIdentity("TriggerName", "TriggerGroup")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(10)
						.repeatForever())
				.build();
		return trigger;
	}
	
	public Trigger getDumbJobTrigger() {
		Trigger dumbJobTrigger = newTrigger()
				.withIdentity("dumbJobTrigger", "TriggerGroup")
				.usingJobData("string", "string2222")
				.usingJobData("floatNum", 43.21f)
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(10)
						.repeatForever())
				.build();
		return dumbJobTrigger;
	}
	
	public Trigger getSetterJobTrigger() {
		Trigger setterJobTrigger = newTrigger()
				.withIdentity("setterJobTrigger", "TriggerGroup")
				.usingJobData("string", "string222")
				.usingJobData("floatNum", 43.21f)
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(10)
						.repeatForever())
				.build();
		setterJobTrigger.getJobDataMap().put("state", new ArrayList<Date>());
		return setterJobTrigger;
	}
	
	public Trigger getConcurrentJobTrigger() {
		Trigger concurrentJobTrigger = newTrigger()
				.withIdentity("ConcurrentJobTrigger", "TriggerGroup")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(3)
						.repeatForever())
				.build();
		return concurrentJobTrigger;
	}
	
	public Trigger getConcurrentJobTrigger2() {
		Trigger concurrentJobTrigger2 = newTrigger()
				.withIdentity("ConcurrentJobTrigger2", "TriggerGroup")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(3)
						.repeatForever())
				.build();
		return concurrentJobTrigger2;
	}
	
	public Trigger getConcurrentJobTrigger3() {
		Trigger concurrentJobTrigger3 = newTrigger()
				.withIdentity("ConcurrentJobTrigger3", "TriggerGroup")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(3)
						.repeatForever())
				.build();
		return concurrentJobTrigger3;
	}
	
	public Trigger getFeaturesJobTrigger() {
		Trigger featuresJobTrigger = newTrigger()
				.withIdentity("featuresJobTrigger", "TriggerGroup")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(1)
						.repeatForever())
				.build();
		return featuresJobTrigger;
	}
	
	public Trigger getPriorityTrigger() {
		Trigger priorityTrigger = newTrigger()
				.withIdentity("priorityTrigger", "TriggerGroup")
				.usingJobData("string", "priorityTrigger")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(1)
						.repeatForever())
				.withPriority(Trigger.DEFAULT_PRIORITY)
				.build();
		return priorityTrigger;
	}
	
	public Trigger getPriority1Trigger() {
		Trigger priority1Trigger = newTrigger()
				.withIdentity("priority1Trigger", "TriggerGroup")
				.usingJobData("string", "priority1Trigger")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(1)
						.repeatForever())
				.withPriority(1)
				.build();
		return priority1Trigger;
	}
	
	public Trigger getPriority9Trigger() {
		Trigger priority9Trigger = newTrigger()
				.withIdentity("priority9Trigger", "TriggerGroup")
				.usingJobData("string", "priority9Trigger")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(1)
						.repeatForever())
				.withPriority(9)
				.build();
		return priority9Trigger;
	}
	
	public Trigger getMisfireTrigger() {
		Trigger misfireTrigger = newTrigger()
				.withIdentity("misfireTrigger", "TriggerGroup")
				.usingJobData("string", "misfireTrigger")
				.startNow()
				.withSchedule(simpleSchedule()
						.withIntervalInSeconds(1)
						.repeatForever())
				.build();
		return misfireTrigger;
	}
	
}
