package hu.barbar.util.tasks;

import java.util.ArrayList;
import java.util.Date;

public abstract class RepeatingTask extends Task {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8711634901508177042L;
	
	
	ArrayList<Long> existingSingleChilds = null;
	
	protected Date generatedUntil = null;
	

	public RepeatingTask(long id, String taskContent, int type) {
		super(id, taskContent, type);
		existingSingleChilds = new ArrayList<Long>();
	}
	
	public void setExistingChilds(ArrayList<Long> childs){
		this.existingSingleChilds = childs;
	}
	
	public ArrayList<Long> getExistingChilds(){
		return this.existingSingleChilds;
	}
	
	public int getExistingChildCount(){
		if(this.existingSingleChilds == null){
			return -1;
		}
		return this.existingSingleChilds.size();
	}

	
	public void addChildID(Long id){
		this.existingSingleChilds.add(id);
	}
	
	public boolean hasChildWithID(long id){
		for(int i=0; i<getExistingChildCount(); i++){
			if(this.existingSingleChilds.get(i) == id){
				return true;
			}
		}
		return false;
	}
	
	
	public void setGeneratedUntil(Date dateOfLastGeneratedSingleOccurance){
		this.generatedUntil = dateOfLastGeneratedSingleOccurance;
	}
	
	/**
	 * @return null if no generated singleTask child yet. 
	 */
	public Date getLastGeneratedDate(){
		return this.generatedUntil;
	}
	
	public abstract ArrayList<SingleTask> generateSingleTasks(Date until);
	
}
