package quartz.jobs.joblisteners;

import org.quartz.listeners.JobListenerSupport;

public class JobListeners2 extends JobListenerSupport {
	
	private String name;
	
	public JobListeners2(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
