package quartz.jobs;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class PriorityJob implements Job {

	private String string;
	
	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobDetail jobDetail = context.getJobDetail();
		JobKey jobKey = jobDetail.getKey();
		
		System.out.println("Instance " + jobKey + " string: " + string);
	}

	public void setString(String string) {
		this.string = string;
	}

}
