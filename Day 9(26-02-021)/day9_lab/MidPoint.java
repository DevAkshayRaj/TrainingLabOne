package day9_lab;

import java.util.Scanner;

public class MidPoint {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter the Two Numbers : ");
		double a=s.nextDouble(),b=s.nextDouble();
		System.out.println("The Midpoint is "+ (a+b)/2);
		s.close();
	}

}
