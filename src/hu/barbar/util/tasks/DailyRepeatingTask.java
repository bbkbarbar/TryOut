package hu.barbar.util.tasks;

import java.util.Date;

public class DailyRepeatingTask extends RepeatingTask {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7344824519731891376L;

	
	/**
	 * Null value for endDate represents endless repeating task.
	 */
	protected Date endDate = null;
	
	/**
	 * Contains the time when the task should run.
	 * The date part is irrelevant.
	 */
	protected Date taskTime = null;
	
	
	
	public DailyRepeatingTask(long id, String taskContent, Date taskTime, Date expiration) {
		super(id, taskContent, Task.Type.DAILY);
		this.endDate = expiration;
		this.taskTime = taskTime;
	}
	
	public DailyRepeatingTask(String taskContent) {
		super(Task.ID.getNext(), taskContent, Task.Type.DAILY);
	}
	
	
	
	public boolean isExpired(){
		// Null value for endDate represents endless repeating task.
		if(endDate == null){
			// Endless repeating task can not be expired.  
			return false;
		}
		Date now = new Date();
		return (endDate.before(now));
	}

}
