import java.util.ArrayList;
import java.util.Date;

import hu.barbar.util.DateHandler;
import hu.barbar.util.filehandling.FileHandler;
import hu.barbar.util.filehandling.XMLHandler;
import hu.barbar.util.tasks.DailyRepeatingTask;
import hu.barbar.util.tasks.RepeatingTask;
import hu.barbar.util.tasks.SingleTask;
import hu.barbar.util.tasks.Task;

public class Test {
	
	public static Test me = null;

	public static void main(String[] args) {
		me = new Test();
		me.doIt();
	}

	public Test(){}

	@SuppressWarnings("unchecked")
	private void doIt(){
		
		ArrayList<Task> list = new ArrayList<>();
		SingleTask st, st2, st3;
		
		/*
		st = new SingleTask("doThis1", new Date());
		st2 = new SingleTask("doThis2", new Date());
		st3 = new SingleTask("doThis3", new Date());
		/**/
		
		list = (ArrayList<Task>) FileHandler.loadTaskList("listFile.dat");
		
		st = (SingleTask) list.get(0);
		st2 = (SingleTask) list.get(1);
		st3 = (SingleTask) list.get(2);
		
		Date d = new Date();
		
		d = DateHandler.getNextOccurance(d, 22, 41, 11);
		show("Now: " + DateHandler.getDateStr(d));
		
		show("next: " + DateHandler.getDateStr(DateHandler.getNextOccurance(d, 22, 41, 11)));
		
		
		/*
		list.add(st);
		list.add(st2);
		list.add(st3);
		
		SimpleFileHandler.saveTaskList(list, "listFile.dat");
		/**/
		
		/*
		XMLHandler xml = new XMLHandler();
		xml.saveobjectToFile(st, "c:\\testSave.xml");
		/**/
	}
	
	public String cutPrefix(String text, String prefix){
		return text.substring(prefix.length());
	}
	
	private void show(String s){
		System.out.println(s);
	}
	
}
