package day9_lab;

import java.util.Arrays;

public class ArrayMaxMin {
	public static void main(String[] args) {
		int a[]= {1,2,3,4,5,6};
		Arrays.sort(a);
		System.out.println("MAX:" +a[a.length-1]);
		System.out.println("MIN:" +a[0]);
		
	}
}
