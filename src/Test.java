import java.util.ArrayList;
import java.util.Date;

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

	private void doIt(){
		
		ArrayList<Task> list = new ArrayList<>();
		
		SingleTask st = new SingleTask("doThis1", new Date());
		SingleTask st2 = new SingleTask("doThis2", new Date());
		SingleTask st3 = new SingleTask("doThis3", new Date());
		show(st.toString());
		st2.setDone();
		show(st2.toString());
		show(st3.toString());
		
		
		RepeatingTask rt = new DailyRepeatingTask(12, "daily concent", new Date(), null);
		
		
		list.add(st);
		list.add(st2);
		list.add(st3);
		
		
		XMLHandler xml = new XMLHandler();
		xml.saveToFile(list, "c:\\testSave.xml");
		/**/
	}
	
	public String cutPrefix(String text, String prefix){
		return text.substring(prefix.length());
	}
	
	private void show(String s){
		System.out.println(s);
	}
	
}
