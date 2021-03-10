package day17;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {
	public static void main(String[] args) {
		Locale.setDefault(new Locale("ta"));
		
		Locale l=Locale.getDefault();
		
		//ResourceBundle r=ResourceBundle.getBundle("day17/dictionary", l);
		
		ResourceBundle r=ResourceBundle.getBundle("day17.Dictionary", l);
		
		System.out.println(r.getString("hello"));
		System.out.println(r.getString("name"));
		System.out.println(r.getString("time"));
		System.out.println(r.getString("water"));
		
		Locale.setDefault(new Locale("te"));
		
		l=Locale.getDefault();
		
		//r=ResourceBundle.getBundle("day17/dictionary", l);
		r=ResourceBundle.getBundle("day17.Dictionary", l);
		
		System.out.println(r.getString("hello"));
		System.out.println(r.getString("name"));
		System.out.println(r.getString("time"));
		System.out.println(r.getString("water"));
	}

}
