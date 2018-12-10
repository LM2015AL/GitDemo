package quartz.jobs;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class FeaturesJob implements Job {

	private static boolean flag;
	
	public void execute(JobExecutionContext context) throws JobExecutionException {

		if(!flag) {
			System.out.println(flag);
			flag = true;
			throw new JobExecutionException(new RuntimeException());
		}
		System.out.println(this.getClass() + " execute " + " flag " + flag + new Date());
	}

}
