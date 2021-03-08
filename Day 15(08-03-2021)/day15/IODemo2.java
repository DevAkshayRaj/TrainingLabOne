package day15;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class IODemo2 {
	public static void main(String[] args) {
		File file=new File("copyofa");
		System.out.println("Name : "+file.getName());
		System.out.println("Path : "+file.getAbsolutePath());
		System.out.println("Is Directory : "+file.isDirectory());
		System.out.println("Does Exists ? "+file.exists());
		System.out.println("Write Privilages : "+file.canWrite());
		System.out.println("Is Directory : "+file.isDirectory());
		File destFile=new File("C:\\Users\\YQ425XM\\Downloads");
		file.renameTo(destFile);
		System.out.println("Write Privilages : "+destFile.canWrite());
		System.out.println(destFile);
		String files[]=destFile.list(new MyFiler("xlsx"));
		System.out.println(Arrays.toString(files));
	}
}

class MyFiler implements FilenameFilter{
	String t;
	public MyFiler(String t) {
		this.t=t;
	}
	@Override
	public boolean accept(File dir, String name) {
		
		return name.endsWith("."+t);
	}
}