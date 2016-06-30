import java.util.ArrayList;
import java.util.Date;

import hu.barbar.util.DateHandler;
import hu.barbar.util.filehandling.FileHandler;
import hu.barbar.util.filehandling.XMLHandler;
import hu.barbar.util.tasks.DailyRepeatingTask;
import hu.barbar.util.tasks.RepeatingTask;
import hu.barbar.util.tasks.SingleTask;
import hu.barbar.util.tasks.Task;
import hu.barbar.util.tasks.TaskHandler;

public class Test {
	
	public static Test me = null;

	public static void main(String[] args) {
		me = new Test();
		me.doIt();
	}

	public Test(){}

	@SuppressWarnings("unchecked")
	private void doIt(){
		
		Date d = new Date();
		d = DateHandler.getOccurrenceInNext24h(d, 22, 41, 11);
		show("Now: " + DateHandler.getDateStr(d));
		show("next: " + DateHandler.getDateStr(DateHandler.getOccurrenceInNext24h(d, 22, 41, 11)));
		
		Date taskTime = new Date();
		taskTime.setHours(16);
		taskTime.setMinutes(30);
		DailyRepeatingTask taskPlan = new DailyRepeatingTask("Task-concent", taskTime);
		
		
		TaskHandler myTaskHandler = new TaskHandler();
		Date until = DateHandler.plusDay(new Date(), 2);
		show("\n\nUntil: " + DateHandler.getDateStr(until));
		myTaskHandler.generateSingleTasksFromRepeatingTask(taskPlan, until);
		ArrayList<SingleTask> scheduledList = myTaskHandler.getScheduledSingleTasks();
		
		for(int i=0; i<scheduledList.size(); i++){
			show(scheduledList.get(i).toString() + "\n");
		}
		
	}
	
	public String cutPrefix(String text, String prefix){
		return text.substring(prefix.length());
	}
	
	private void show(String s){
		System.out.println(s);
	}
	
}
