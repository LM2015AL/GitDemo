package quartz.triggers.triggerlisteners;

import org.quartz.listeners.TriggerListenerSupport;

public class TriggerListeners2 extends TriggerListenerSupport {

	private String name;
	
	public TriggerListeners2(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
