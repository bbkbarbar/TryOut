package hu.barbar.util.tasks;

import java.io.Serializable;

public class Task implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1520532892819415550L;


	public class Type {
		public static final int UNDEFINED = 0,
								SINGLE = 1,
								SERIES = 2,
								DAILY = 3;
		
	}
	
	public static class ID {
		
		public static final long UNDEFINED = -1;
		
		private static long NEXT = 0;

		public static Long getNext() {
			long val = NEXT;
			NEXT++;
			return Long.valueOf(val);
		}
		
		public static Long checkNext() {
			return Long.valueOf(ID.NEXT);
		}
		
	}

	
	public static final String DATE_FORMAT_PATTERN = "yyyy.MM.dd HH:mm:ss";
	
	public static final boolean MULTILINE_TOSTRING = true;
	
	
	protected String taskContent = null;
	
	protected int type = Task.Type.UNDEFINED;

	protected long id = Task.ID.UNDEFINED;
	
	
	
	public Task(long id, String taskContent, int type) {
		super();
		this.id = id;
		this.taskContent = taskContent;
		this.type = type;
	}


	public String getTaskContent() {
		return taskContent;
	}


	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}


	public int getType() {
		return type;
	}
	
	public long getId() {
		return this.id;
	}
	
}
