package quartz.jobs.joblisteners;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.JobListener;

public class JobListeners implements JobListener {
	
	private String name;
	
	public JobListeners(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void jobToBeExecuted(JobExecutionContext context) {

		JobDetail jobDetail = context.getJobDetail();
		JobKey JobKey = jobDetail.getKey();
		System.out.println("jobToBeExecuted name:" + name + " JobKey:" + JobKey + " " + new Date());
	}

	public void jobExecutionVetoed(JobExecutionContext context) {

		JobDetail jobDetail = context.getJobDetail();
		JobKey JobKey = jobDetail.getKey();
		System.out.println("jobExecutionVetoed name:" + name + " JobKey:" + JobKey + " " + new Date());
	}

	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {

		JobDetail jobDetail = context.getJobDetail();
		JobKey JobKey = jobDetail.getKey();
		System.out.println("jobWasExecuted name:" + name + " JobKey:" + JobKey + " " + new Date());
	}

}
