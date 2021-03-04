package day13;

import java.io.FileInputStream;
import java.util.Enumeration;
import java.util.Properties;

public class CollectionDemo6 {
	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();

// prop.put("a1", "hello");
		prop.load(new FileInputStream("xyz.properties"));

		Enumeration e = prop.elements();
		while (e.hasMoreElements()) {
			String value1 = (String) e.nextElement();

			System.out.println(value1);
		}
	}
}
