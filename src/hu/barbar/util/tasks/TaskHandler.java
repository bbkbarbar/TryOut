package hu.barbar.util.tasks;

import java.util.ArrayList;
import java.util.Date;

import hu.barbar.util.filehandling.FileHandler;

public class TaskHandler {
	
	private static final String NAME_OF_DATA_FILE_FOR_SINGLE_TASKS = "singleTasks.dat";
	
	private static final String NAME_OF_DATA_FILE_FOR_REPEATING_TASKS = "scheduledTasks.dat";

	private ArrayList<SingleTask> scheduledTasks = null;
	
	private ArrayList<RepeatingTask> taskPlans = null;

	
	public TaskHandler(){
		scheduledTasks = new ArrayList<SingleTask>();
		taskPlans = new ArrayList<RepeatingTask>();
	}
	
	
	public void saveData(){
		FileHandler.saveTaskList(taskPlans, NAME_OF_DATA_FILE_FOR_REPEATING_TASKS);
		FileHandler.saveTaskList(scheduledTasks, NAME_OF_DATA_FILE_FOR_SINGLE_TASKS);
	}
	
	@SuppressWarnings("unchecked")
	public void loadData(){
		scheduledTasks = (ArrayList<SingleTask>) FileHandler.loadTaskList(NAME_OF_DATA_FILE_FOR_SINGLE_TASKS);
		taskPlans = (ArrayList<RepeatingTask>) FileHandler.loadTaskList(NAME_OF_DATA_FILE_FOR_REPEATING_TASKS);
	}
	
	
	public void addScheduledTask(SingleTask task){
		this.scheduledTasks.add(task);
	}
	
	public void addPlannedTask(RepeatingTask task){
		this.taskPlans.add(task);
	}
	
	public ArrayList<SingleTask> getScheduledSingleTasks(){
		return this.scheduledTasks;
	}
	
	protected SingleTask getScheduledTaskWithID(long id){
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
	
	protected RepeatingTask getPlannedTaskWithID(long id){
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
	
	
	public void generateSingleTasksFromRepeatingTask(RepeatingTask task, Date until){
		if(task == null){
			//TODO Handle this case
		}else{
			
			Date now = new Date();
			if(until.before(now)){
				//TODO
				return;
			}

			ArrayList<SingleTask> resultList = task.generateSingleTasks(until);
			if(resultList == null){
				//TODO
				return;
			}
			
			for(int i=0; i<resultList.size(); i++){
				scheduledTasks.add(resultList.get(i));
				task.addChildID(resultList.get(i).getId());
			}
			
			
		}
		
	}
	
	public void generateAllScheduledSingleTasks(Date until){
		if(taskPlans == null){
			//TODO
			return;
		}
		
		for(int i=0; i<taskPlans.size(); i++){
			generateSingleTasksFromRepeatingTask(taskPlans.get(i), until);
		}
	}
	
}
