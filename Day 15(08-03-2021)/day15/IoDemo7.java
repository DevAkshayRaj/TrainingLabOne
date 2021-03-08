package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IoDemo7 {
	public static void main(String[] args) throws Exception{
		WriteToString wts=new WriteToString();
		wts.write("Akshay".getBytes());
		System.out.println(wts.read());
		
		saveObject(wts);
		wts.write("Akshay Raj".getBytes());
		System.out.println(wts.read());
		
		
		wts=retreiveLastSavedObject();
		System.out.println(wts.read());
		
		
	}
	public static void saveObject(WriteToString wts)throws Exception {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("store.dat"));
		oos.writeObject(wts);
	}
	public static WriteToString retreiveLastSavedObject()throws Exception {
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("store.dat"));
		return (WriteToString)ois.readObject();
	}
	
}
class WriteToString implements Serializable{
	
	String s;
	public void write(byte b[]) throws Exception{
		s=new String(b);
	}
	public String read()throws Exception {
		return s;
	}
}