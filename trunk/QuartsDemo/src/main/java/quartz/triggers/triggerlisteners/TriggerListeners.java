package quartz.triggers.triggerlisteners;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;

public class TriggerListeners implements TriggerListener {

	private String name;
	
	public TriggerListeners(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void triggerFired(Trigger trigger, JobExecutionContext context) {

		JobDetail jobDetail = context.getJobDetail();
		JobKey JobKey = jobDetail.getKey();
		System.out.println("triggerFired name:" + name + " JobKey:" + JobKey + " " + new Date());
	}

	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {

		JobDetail jobDetail = context.getJobDetail();
		JobKey JobKey = jobDetail.getKey();
		System.out.println("vetoJobExecution name:" + name + " JobKey:" + JobKey + " " + new Date());
		return false;
	}

	public void triggerMisfired(Trigger trigger) {

//		trigger.get
//		JobDetail jobDetail = context.getJobDetail();
//		JobKey JobKey = jobDetail.getKey();
		System.out.println("triggerMisfired name:" + name + " " + new Date());
		
	}

	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {

		JobDetail jobDetail = context.getJobDetail();
		JobKey JobKey = jobDetail.getKey();
		System.out.println("triggerComplete name:" + name + " JobKey:" + JobKey + " " + new Date());
	}

}
