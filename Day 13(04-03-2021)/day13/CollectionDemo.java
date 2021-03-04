package day13;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo {
	public static void main(String[] args) {
		Set<String> myset = new TreeSet<String>((o1, o2) -> {
			return o2.compareTo(o1);
		});

		myset.add("Rohit");
		myset.add("Sharma");
		myset.add("Akshay");
		myset.add("Raj");
		myset.add("aishu");
		myset.add("bala");

		System.out.println(myset);

		for (String s : myset) {
			System.out.println(s);
		}
		Iterator<String> iter = myset.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}