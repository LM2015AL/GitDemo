package quartz.jobs;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobDetailDemo implements Job {

	public void execute(JobExecutionContext context) throws JobExecutionException {

		System.out.println(this.getClass() + " execute " + new Date());
	}

}
