package quartz.triggers.crontrigger.misfire;

import static org.quartz.TriggerBuilder.*;
import static org.quartz.CronScheduleBuilder.*;
import static org.quartz.DateBuilder.*;
import org.quartz.Trigger;
	
public class MisfireCronTriggers {

	/**
	 * MISFIRE_INSTRUCTION_DO_NOTHING
	 * @return
	 */
	public Trigger getDoNothingTrigger() {
		Trigger trigger = newTrigger()
				.withIdentity("DoNothingTrigger", "MisfireCronTriggers")
				.withSchedule(cronSchedule("0/1 3-4 17 6 12 ?")
						.withMisfireHandlingInstructionDoNothing())
//			    .forJob("myJob", "group1")
				.build();
		return trigger;
	}
	
	/**
	 * MISFIRE_INSTRUCTION_FIRE_ONCE_NOW
	 * @return
	 */
	public Trigger getFireAndProceedTrigger() {
		Trigger trigger = newTrigger()
			    .withIdentity("FireAndProceedTrigger", "MisfireCronTriggers")
				.withSchedule(cronSchedule("0/5 5 17 6 12 ?")
			        .withMisfireHandlingInstructionFireAndProceed())
//			    .forJob("myJob", "group1")
			    .build();
		return trigger;
	}
	
	/**
	 * MISFIRE_INSTRUCTION_DO_NOTHING
	 * @return
	 */
	public Trigger getIgnoreMisfiresTrigger() {
		Trigger trigger = newTrigger()
				.withIdentity("IgnoreMisfires", "MisfireCronTriggers")
				.withSchedule(cronSchedule("0/5 6 17 6 12 ?")
						.withMisfireHandlingInstructionIgnoreMisfires())
//			    .forJob("myJob", "group1")
				.build();
		return trigger;
	}
	
}
