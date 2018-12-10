package quartz;

import static org.quartz.JobKey.*;
import static org.quartz.impl.matchers.KeyMatcher.*;
import static org.quartz.impl.matchers.GroupMatcher.*;
import static org.quartz.impl.matchers.AndMatcher.*;
import static org.quartz.impl.matchers.OrMatcher.*;

import org.quartz.JobKey;

import static org.quartz.impl.matchers.EverythingMatcher.*;
import org.quartz.ListenerManager;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import quartz.jobs.jobDetail.JobDetails;
import quartz.jobs.joblisteners.JobListeners;
import quartz.triggers.Triggers;
import quartz.triggers.crontrigger.CronTriggers;
import quartz.triggers.crontrigger.misfire.MisfireCronTriggers;
import quartz.triggers.simpletrigger.SimpleTriggers;
import quartz.triggers.simpletrigger.misfire.MisfireSimpleTriggers;

public class QuartzDemo {

	public static void main(String[] args) {
		
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = null;
		try {
			scheduler = schedulerFactory.getScheduler();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			System.out.println(scheduler.getSchedulerName());
		} catch (SchedulerException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
			return;
		}
		ListenerManager listenerManager = null;
		try {
			listenerManager = scheduler.getListenerManager();
		} catch (SchedulerException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
			return;
		}
		listenerManager.addJobListener(new JobListeners("myJobListener"), keyEquals(new JobKey("JobDetailName", "JobDetailGroup")));
		
		JobDetails jobDetails = new JobDetails();
		Triggers triggers = new Triggers();
		SimpleTriggers simpleTriggers = new SimpleTriggers();
		MisfireSimpleTriggers misfireSimpleTriggers = new MisfireSimpleTriggers();
		CronTriggers cronTriggers = new CronTriggers();
		MisfireCronTriggers misfireCronTriggers = new MisfireCronTriggers();
		
		try {
			System.out.println(scheduler.scheduleJob(jobDetails.getJobDetail(), triggers.getTrigger()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getDumbJob(), triggers.getDumbJobTrigger()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getSetterJob(), triggers.getSetterJobTrigger()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getConcurrentJob(), triggers.getConcurrentJobTrigger()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getConcurrentJob2(), triggers.getConcurrentJobTrigger2()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getConcurrentJob3(), triggers.getConcurrentJobTrigger3()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getFeaturesJob(), triggers.getFeaturesJobTrigger()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getPriorityJobDetail("PriorityTrigger"), triggers.getPriorityTrigger()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getPriorityJobDetail("Priority1Trigger"), triggers.getPriority1Trigger()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getPriorityJobDetail("Priority9Trigger"), triggers.getPriority9Trigger()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getJobDetail(), simpleTriggers.getTrigger1()));
//			System.out.println(scheduler.scheduleJob(simpleTriggers.getTrigger3()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getJobDetail(), misfireSimpleTriggers.getNowWithRemainingCountMisfireSimpleTrigger()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getJobDetail(), cronTriggers.getTrigger1()));
//			System.out.println(scheduler.scheduleJob(jobDetails.getJobDetail(), misfireCronTriggers.getIgnoreMisfiresTrigger()));
		} catch (SchedulerException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			return;
		}

		try {
			scheduler.start();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		try {
			scheduler.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
	}
}
