package quartz.triggers.simpletrigger.misfire;

import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.DateBuilder.*;

import org.quartz.SimpleTrigger;
import org.quartz.Trigger;


public class MisfireSimpleTriggers {
	
	/**
	 * MISFIRE_INSTRUCTION_FIRE_NOW
	 * ——以当前时间为触发频率立即触发执行
	 * ——执行至FinalTIme的剩余周期次数
	 * ——以调度或恢复调度的时刻为基准的周期频率，FinalTime根据剩余次数和当前时间计算得到
	 * ——调整后的FinalTime会略大于根据starttime计算的到的FinalTime值
	 * @return
	 */
	public Trigger getFireNowMisfireSimpleTrigger() {
		SimpleTrigger fireNowMisfireSimpleTrigger = newTrigger()
		        .withIdentity("fireNowMisfireSimpleTrigger", "MisfireSimpleTriggersGroup")
		        .startAt(dateOf(14, 32, 0))
		        .endAt(dateOf(14, 34, 0))
		        .withSchedule(simpleSchedule()
		            .withIntervalInSeconds(5)
		            .withRepeatCount(24)
		            .withMisfireHandlingInstructionFireNow()
		            )
		        .build();
		return fireNowMisfireSimpleTrigger;
	}
	
	/**
	 * MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY
	 * ——以错过的第一个频率时间立刻开始执行
	 * ——重做错过的所有频率周期
	 * ——当下一次触发频率发生时间大于当前时间以后，按照Interval的依次执行剩下的频率
	 * ——共执行RepeatCount+1次
	 * @return
	 */
	public Trigger getIgnoreMisfiresMisfireSimpleTrigger() {
		SimpleTrigger ignoreMisfiresMisfireSimpleTrigger = newTrigger()
				.withIdentity("ignoreMisfiresMisfireSimpleTrigger", "MisfireSimpleTriggersGroup")
		        .startAt(dateOf(14, 31, 0))
		        .endAt(dateOf(14, 33, 0))
				.withSchedule(simpleSchedule()
			            .withIntervalInSeconds(5)
			            .withRepeatCount(10)
						.withMisfireHandlingInstructionIgnoreMisfires()
						)
				.build();
		return ignoreMisfiresMisfireSimpleTrigger;
	}
	
	/**
	 * MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_EXISTING_COUNT
	 * ——不触发立即执行
	 * ——等待下次触发频率周期时刻，执行至FinalTime的剩余周期次数
	 * ——以startTime为基准计算周期频率，并得到FinalTime
	 * ——即使中间出现pause，resume以后保持FinalTime时间不变
	 * @return
	 */
	public Trigger getNextWithExistingCountMisfireSimpleTrigger() {
		SimpleTrigger nextWithExistingCountMisfireSimpleTrigger = newTrigger()
				.withIdentity("nextWithExistingCountMisfireSimpleTrigger", "MisfireSimpleTriggersGroup")
		        .startAt(dateOf(14, 39, 0))
		        .endAt(dateOf(14, 40, 0))
				.withSchedule(simpleSchedule()
			            .withIntervalInSeconds(5)
			            .withRepeatCount(10)
						.withMisfireHandlingInstructionNextWithExistingCount()
						)
				.build();
		return nextWithExistingCountMisfireSimpleTrigger;
	}
	
	/**
	 * MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT
	 * ——不触发立即执行
	 * ——等待下次触发频率周期时刻，执行至FinalTime的剩余周期次数
	 * ——以startTime为基准计算周期频率，并得到FinalTime
	 * ——即使中间出现pause，resume以后保持FinalTime时间不变
	 * @return
	 */
	public Trigger getNextWithRemainingCountMisfireSimpleTrigger() {
		SimpleTrigger nextWithRemainingCountMisfireSimpleTrigger = newTrigger()
				.withIdentity("nextWithRemainingCountMisfireSimpleTrigger", "MisfireSimpleTriggersGroup")
		        .startAt(dateOf(14, 45, 0))
		        .endAt(dateOf(14, 46, 0))
				.withSchedule(simpleSchedule()
			            .withIntervalInSeconds(5)
			            .withRepeatCount(12)
						.withMisfireHandlingInstructionNextWithRemainingCount()
						)
				.build();
		return nextWithRemainingCountMisfireSimpleTrigger;
	}
	
	/**
	 * MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_EXISTING_REPEAT_COUNT
	 * ——以当前时间为触发频率立即触发执行
	 * ——执行至FinalTIme的剩余周期次数
	 * ——以调度或恢复调度的时刻为基准的周期频率，FinalTime根据剩余次数和当前时间计算得到
	 * ——调整后的FinalTime会略大于根据starttime计算的到的FinalTime值
	 * @return
	 */
	public Trigger getNowWithExistingCountMisfireSimpleTrigger() {
		SimpleTrigger nowWithExistingCountMisfireSimpleTrigger = newTrigger()
				.withIdentity("nowWithExistingCountMisfireSimpleTrigger", "MisfireSimpleTriggersGroup")
		        .startAt(dateOf(15, 1, 0))
		        .endAt(dateOf(15, 2, 0))
				.withSchedule(simpleSchedule()
			            .withIntervalInSeconds(5)
			            .withRepeatCount(12)
						.withMisfireHandlingInstructionNowWithExistingCount()
						)
				.build();
		return nowWithExistingCountMisfireSimpleTrigger;
	}
	
	/**
	 * MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_REMAINING_REPEAT_COUNT
	 * ——以当前时间为触发频率立即触发执行
	 * ——执行至FinalTIme的剩余周期次数
	 * ——以调度或恢复调度的时刻为基准的周期频率，FinalTime根据剩余次数和当前时间计算得到
	 * ——调整后的FinalTime会略大于根据starttime计算的到的FinalTime值
	 * @return
	 */
	public Trigger getNowWithRemainingCountMisfireSimpleTrigger() {
		SimpleTrigger nowWithRemainingCountMisfireSimpleTrigger = newTrigger()
				.withIdentity("nowWithRemainingCountMisfireSimpleTrigger", "MisfireSimpleTriggersGroup")
		        .startAt(dateOf(15, 3, 0))
		        .endAt(dateOf(15, 4, 0))
				.withSchedule(simpleSchedule()
			            .withIntervalInSeconds(5)
			            .withRepeatCount(5)
						.withMisfireHandlingInstructionNowWithRemainingCount()
						)
				.build();
		return nowWithRemainingCountMisfireSimpleTrigger;
	}

}
