package hu.barbar.util.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SingleTask extends Task {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7606846395600666895L;

	
	protected Date date = null;
	
	protected boolean done = false;
	

	public SingleTask(long id, String taskContent, Date when) {
		super(id, taskContent, Task.Type.SINGLE);
		this.done = false;
		this.date = when;
	}
	
	public SingleTask(String taskContent, Date when) {
		super(Task.ID.getNext(), taskContent, Task.Type.SINGLE);
		this.done = false;
		this.date = when;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}



	public boolean isDone() {
		return done;
	}

	public void setDone() {
		this.done = true;
	}
	
	public void setUnDone() {
		this.done = false;
	}

	
	public String toString(){
		return this.toString(Task.MULTILINE_TOSTRING);
	}
	
	public String toString(boolean multipleLine){
		String separator = (multipleLine)?"\n":", ";
		SimpleDateFormat sdf = new SimpleDateFormat(Task.DATE_FORMAT_PATTERN);
		
		String s = "SingleTask:" + ((multipleLine)?"\n":" ");
		s += "Date: " + sdf.format(getDate()) + separator;
		s += "Content: " + getTaskContent() + separator;
		s += "Done: [" + (isDone()?"X":" ") + "]" + separator;
		s += "ID: " + Long.toString(getId());
		return s;
	}
	
	
	
}
