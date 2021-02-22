package day5_lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class JavaMcq12 {
	
	public static void main(String argv[]){
		JavaMcq12 m=new JavaMcq12();
		System.out.println(m.amethod());
	}

	public int amethod() {
	try {
		FileInputStream dis=new FileInputStream("Hello.txt");
	}
	catch (FileNotFoundException fne) {
		System.out.println("No such file found");
		return -1;
	}
	catch(IOException ioe) {
	} 
	finally{
		System.out.println("Doing finally");
	}
	return 0;
	}
	/* output is  " No such file found, Doing finally , -1 " since file is not present in the pwd , exception is thrown , then 
	 * finally blocl is executed then -1 is returned to main function and gets printed. 
	 * 
	 */
}
