package day15;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class IODemo1 {
	public static void main(String[] args) {
		new FileCopy().copyFile("a.properties");
	}
}

class FileCopy{
	public void copyFile(String file) {
		FileInputStream fi=null;
		FileOutputStream fo=null;
		
		FileReader fr=null;
		try (FileWriter fw=new FileWriter("FWcopyofa");){
//		fi=new FileInputStream(file);
//		fo=new FileOutputStream("Copyofa");
		fr=new FileReader(file);
		
		//System.out.println(fi.available());
		//int n=fi.available();
//		System.out.println((char)fi.read());
//		System.out.println((char)fi.read());
//		System.out.println((char)fi.read());
//		System.out.println((char)fi.read());
//		System.out.println((char)fi.read());
//		System.out.println((char)fi.read());
//		System.out.println((char)fi.read());
		int l=0,byt=0;
		//byte buffer[]=new byte[fi.available()];
		//byte buffer[]=new byte[16];
		char buffer[]=new char[16];
		while(true) {
			byt=fr.read(buffer);
			
//			l=fi.read();
//			if(l==-1)
//				break;
//			System.out.print((char)l);
			System.out.println("Loop");
			String temp=new String(buffer,0,byt);
			System.out.println(temp);
			fw.write(temp+"s");
			if(byt<16)
				break;
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
//				fi.close();
//				fo.close();
				//fw.close();
				fr.close();
			}
			catch(Exception e) {
				
			}
			
		}
	}
}