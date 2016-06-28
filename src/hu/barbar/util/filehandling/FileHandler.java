package hu.barbar.util.filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import hu.barbar.util.tasks.Task;

public class FileHandler {
	
	public static boolean saveTaskList(ArrayList<Task> list, String fileName){
		
		boolean res = false;
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fout = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(list);
		} catch (IOException e) {
		} finally {
			try {
				oos.close();
				res = true;
			} catch (Exception e) {}
		}
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Task> loadTaskList(String fileName){
		
		ArrayList<Task> res = null;
		
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			res = (ArrayList<Task>) ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			res = null;
		} finally {
			try {
				ois.close();
			} catch (Exception e) {
			}
			try {
				fis.close();
			} catch (Exception e) {
			}
		}
		
		return res;
	}
	
	
}
