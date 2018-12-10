package quartz.jobs.jobDetail;

import static org.quartz.JobBuilder.newJob;

import java.util.ArrayList;
import java.util.Date;

import org.quartz.JobDetail;

import quartz.jobs.ConcurrentJob;
import quartz.jobs.DumbJob;
import quartz.jobs.FeaturesJob;
import quartz.jobs.JobDetailDemo;
import quartz.jobs.PriorityJob;
import quartz.jobs.SetterJob;

public class JobDetails {

	public JobDetail getJobDetail() {
		JobDetail JobDetailName = newJob(JobDetailDemo.class)
				.withIdentity("JobDetailName", "JobDetailGroup")
				.build();
		return JobDetailName;
	}

	public JobDetail getDumbJob() {
		JobDetail dumbJob = newJob(DumbJob.class)
				.withIdentity("DumbJob", "JobDetailGroup")
				.usingJobData("string", "string111")
				.usingJobData("floatNum", 12.34f)
				.build();
		dumbJob.getJobDataMap().put("myStateData", new ArrayList<Date>());
		return dumbJob;
	}

	public JobDetail getSetterJob() {
		JobDetail setterJob = newJob(SetterJob.class)
				.withIdentity("setterJob", "JobDetailGroup")
				.usingJobData("string", "string111")
				.usingJobData("floatNum", 12.34f)
				.build();
		return setterJob;
	}

	public JobDetail getConcurrentJob() {
		JobDetail concurrentJob = newJob(ConcurrentJob.class)
				.withIdentity("ConcurrentJob", "JobDetailGroup")
				.usingJobData("index", "1")
				.build();
		return concurrentJob;
	}
	
	public JobDetail getConcurrentJob2() {
		JobDetail concurrentJob2 = newJob(ConcurrentJob.class)
				.withIdentity("ConcurrentJob2", "JobDetailGroup")
				.usingJobData("index", "2")
				.build();
		return concurrentJob2;
	}

	public JobDetail getConcurrentJob3() {
		JobDetail concurrentJob3 = newJob(ConcurrentJob.class)
				.withIdentity("ConcurrentJob3", "JobDetailGroup")
				.usingJobData("index", "3")
				.build();
		return concurrentJob3;
	}

	public JobDetail getFeaturesJob() {
		JobDetail featuresJob = newJob(FeaturesJob.class)
				.withIdentity("featuresJob", "JobDetailGroup")
//				.storeDurably()
//				.requestRecovery()
				.build();
		return featuresJob;
	}

	public JobDetail getPriorityJobDetail(String name) {
		JobDetail priorityJobDetail = newJob(PriorityJob.class)
				.withIdentity(name, "JobDetailGroup")
				.build();
		return priorityJobDetail;
	}
	
}
