package hu.barbar.util.filehandling;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import hu.barbar.util.tasks.Task;

public class XMLHandler {
	
	public XMLHandler() {
		
	}
	
	public void saveToFile(ArrayList<Task> list, String filename){
		XMLEncoder encoder;
		try {
			encoder = new XMLEncoder(
			          	new BufferedOutputStream(
			        		  new FileOutputStream(filename))
			);
		
			encoder.writeObject(list);
			encoder.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveobjectToFile(Task task, String filename){
		XMLEncoder encoder;
		try {
			encoder = new XMLEncoder(
			          	new BufferedOutputStream(
			        		  new FileOutputStream(filename))
			);
		
			encoder.writeObject(task);
			encoder.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
