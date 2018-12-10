package quartz.jobs;

import java.util.ArrayList;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class SetterJob implements Job {

	private String string;
	private float floatNum;
	private ArrayList state;
	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobDetail jobDetail = context.getJobDetail();
		JobKey jobKey = jobDetail.getKey();
		JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
		state.add(new Date());
		
		System.out.println("Instance " + jobKey + " string: " + string + ", and float: " + floatNum + ", and state: " + state);
	}
	
	public void setString(String string) {
		this.string = string;
	}
	public void setFloatNum(float floatNum) {
		this.floatNum = floatNum;
	}
	public void setState(ArrayList state) {
		this.state = state;
	}

}
