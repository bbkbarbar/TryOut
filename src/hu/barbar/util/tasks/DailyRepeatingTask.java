package hu.barbar.util.tasks;

import java.util.ArrayList;
import java.util.Date;

import hu.barbar.util.DateHandler;

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
	
	public DailyRepeatingTask(String taskContent, Date taskTime, Date expiration) {
		super(Task.ID.getNext(), taskContent, Task.Type.DAILY);
		this.endDate = expiration;
		this.taskTime = taskTime;
	}
	
	public DailyRepeatingTask(String taskContent, Date taskTime) {
		super(Task.ID.getNext(), taskContent, Task.Type.DAILY);
		this.endDate = null;
		this.taskTime = taskTime;
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

	
	@Override
	public ArrayList<SingleTask> generateSingleTasks(Date until) {
		
		if(until == null){
			return null;
		}
		
		ArrayList<SingleTask> list = new ArrayList<>();
		
		
		/**
		 *  Generate occurrence only in the future.
		 */
		Date now = new Date();
		if(until.before(now)){
			return list;
		}
		
		int scheduleHour = this.taskTime.getHours();
		int scheduleMin  = this.taskTime.getMinutes();
		int scheduleSec  = this.taskTime.getSeconds();
		
		
		Date current = new Date();
		Date generatedOccurance = null;
		while ( ((generatedOccurance = DateHandler.getOccurrenceInNext24h(current, scheduleHour, scheduleMin, scheduleSec)).before(until)) 
				&& ((this.endDate == null) || (generatedOccurance.before(this.endDate))) ){
			list.add(new SingleTask(this.taskContent, generatedOccurance));
			current = DateHandler.plusDay(current, 1);
		}
		
		return list;
	}

}
