import java.util.Date;

import hu.barbar.util.tasks.SingleTask;

public class Test {
	
	

	public static void main(String[] args) {
		new Test();
	}

	public Test(){
		
		SingleTask st = new SingleTask("doThis1", new Date());
		SingleTask st2 = new SingleTask("doThis2", new Date());
		SingleTask st3 = new SingleTask("doThis3", new Date());
		show(st.toString());
		st2.setDone();
		show(st2.toString());
		show(st3.toString());
		
	}
	
	public String cutPrefix(String text, String prefix){
		return text.substring(prefix.length());
	}
	
	private void show(String s){
		System.out.println(s);
	}
	
}
