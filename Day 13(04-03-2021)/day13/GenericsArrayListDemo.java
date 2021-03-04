package day13;

import java.util.ArrayList;

public class GenericsArrayListDemo {
	public static void main(String[] args) {
		ArrayList arr=new ArrayList();
		arr.add("akshay");
		arr.add(45);
		System.out.println(arr);
		for(Object o:arr) {
			System.out.println(o);
		}
		ArrayList<String> ar=new ArrayList<>();
		ar.add("Akshay");
		ar.add("Rohit");
		ar.add("Sharma");
		ar.add("Raj");
		System.out.println(ar);
		for(String o:ar) {
			System.out.println(o);
		}		
		
	}
}
