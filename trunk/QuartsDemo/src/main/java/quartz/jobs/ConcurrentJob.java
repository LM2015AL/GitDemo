package quartz.jobs;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.quartz.PersistJobDataAfterExecution;

@DisallowConcurrentExecution
@PersistJobDataAfterExecution
public class ConcurrentJob implements Job {

	private static int count;
//	private int index;
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		JobDetail jobDetail = context.getJobDetail();
		JobDataMap jobDataMap = jobDetail.getJobDataMap();
		JobKey jobKey = jobDetail.getKey();
		int index = jobDataMap.getInt("index");
		count++;
		jobDataMap.put("index", ++index);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		System.out.println("Instance " + jobKey + " count: " + count + ", and index: " + index);
	}

//	public void setIndex(int index) {
//		this.index = index;
//	}

}
