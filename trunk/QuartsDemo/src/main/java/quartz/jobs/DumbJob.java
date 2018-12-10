package quartz.jobs;

import java.util.ArrayList;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class DumbJob implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobDetail jobDetail = context.getJobDetail();
		JobKey jobKey = jobDetail.getKey();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		String string = jobDataMap.getString("string");
		float floatNum = jobDataMap.getFloat("floatNum");
		ArrayList state = (ArrayList)jobDataMap.get("myStateData");
		state.add(new Date());
		
		System.out.println("Instance " + jobKey + " string: " + string + ", and float: " + floatNum + ", and state: " + state);
	}

}
