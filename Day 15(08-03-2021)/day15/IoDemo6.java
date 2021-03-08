package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IoDemo6 {
	public static void main(String[] args) throws Exception{
		Scale s=new Scale();
		System.out.println(s.size);
		
		
		
		ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("Scale.dat"));
		os.writeObject(s);
		s.size=90;
		
		System.out.println(s.size);
		
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("scale.dat"));
		
		Scale n=(Scale)ois.readObject();
		
		System.out.println(n.size);
				
				
		
		
	}
}

class Scale implements Serializable{
	int size=18;
}