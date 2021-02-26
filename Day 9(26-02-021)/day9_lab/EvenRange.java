package day9_lab;

import java.util.Scanner;

public class EvenRange {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter the Range : ");
		long range=s.nextLong();
		long start=0;
		while(start<=range) {
			System.out.println(start);
			start+=2;
		}
		s.close();
	}

}
