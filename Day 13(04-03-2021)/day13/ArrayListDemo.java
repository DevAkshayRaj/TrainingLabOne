package day13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

class Number implements Comparable<Number>{
	int number;

	public Number(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Number [number=" + number + "]";
	}
	@Override
	public int compareTo(Number o) {
		// TODO Auto-generated method stub
		if(this.number>o.number)
			return 1;
		if(this.number<o.number)
			return -1;
		return 0;
	}
}

public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> ar = new ArrayList<>();
		ar.add("Akshay");
		ar.add("Rohit");
		ar.add("Sharma");
		ar.add("Raj");
		ar.add("india");
		System.out.println("Full ArrayList : " + ar);
		System.out.println("First Element " + ar.get(0));
		System.out.println("Size of ArrayList : " + ar.size());
		System.out.println("Contains Method Check : " + ar.contains("Akshay"));
		int size = ar.size();
		for (int i = 0; i < size; i++) {
			System.out.println("Normal for loop: " + ar.get(i));
		}
		for (String x : ar) {
			System.out.println("New For Loop: " + x);
		}
		Iterator<String> it = ar.iterator();
		while (it.hasNext()) {
			System.out.println("From iterator : " + it.next());
		}
		// it=ar.iterator();
		while (it.hasNext()) {
			System.out.println("From iterator 2 : " + it.next());
		}

		ListIterator<String> lit = ar.listIterator();
		while (lit.hasNext()) {
			System.out.println("From List iterator : " + lit.next());
		}

		while (lit.hasPrevious()) {
			System.out.println("From List iterator reverse: " + lit.previous());
		}

//		Collections.sort(ar,new Reverse());
//		System.out.println(ar);

		Collections.sort(ar, (String o1, String o2) -> {
			return o2.compareTo(o1);
		});
		System.out.println(ar);

		ArrayList<Number> number = new ArrayList<>();
		number.add(new Number(1));
		number.add(new Number(45));
		number.add(new Number(234));
		number.add(new Number(56));
		number.add(new Number(189));
		Collections.sort(number);
		System.out.println(number);
	}
}

class Reverse implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
}