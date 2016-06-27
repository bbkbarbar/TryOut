package hu.barbar.util.tasks;

import java.util.ArrayList;

public class TaskHandler {

	private ArrayList<SingleTask> scheduledTasks = null;
	
	private ArrayList<RepeatingTask> taskPlans = null;

	
	public TaskHandler(){
		scheduledTasks = new ArrayList<SingleTask>();
		taskPlans = new ArrayList<RepeatingTask>();
	}
	
	
	public void addScheduledTask(SingleTask task){
		this.scheduledTasks.add(task);
	}
	
	public void addPlannedTask(RepeatingTask task){
		this.taskPlans.add(task);
	}
	
	public SingleTask getScheduledTaskWithID(long id){
		if(scheduledTasks == null || scheduledTasks.size() == 0){
			return null;
		}
		
		for(int i=0; i<scheduledTasks.size(); i++){
			if(scheduledTasks.get(i).getId() == id){
				return scheduledTasks.get(i); 
			}
		}
		
		return null;
		
	}
	
	public RepeatingTask getPlannedTaskWithID(long id){
		if(taskPlans == null || taskPlans.size() == 0){
			return null;
		}
		
		for(int i=0; i<taskPlans.size(); i++){
			if(taskPlans.get(i).getId() == id){
				return taskPlans.get(i); 
			}
		}
		
		return null;
		
	}
	
	
	protected void generateSingleTasksFromScheduledTaskWithID(long id){
		RepeatingTask task = getPlannedTaskWithID(id);
		if(task == null){
			//TODO Handle this case
		}else{
			//TODO
		}
		
	}
	
}
