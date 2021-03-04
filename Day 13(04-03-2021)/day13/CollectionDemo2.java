package day13;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class CollectionDemo2 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		v.add("Rohit");
		v.add("Sharma");
		v.add("Akshay");

		System.out.println(v);

		Enumeration<String> e = v.elements();
		Iterator<String> iter = v.iterator();

		v.add("Raj");
		while (e.hasMoreElements()) {
			System.out.println("Enumerator...:" + e.nextElement());
		}

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
