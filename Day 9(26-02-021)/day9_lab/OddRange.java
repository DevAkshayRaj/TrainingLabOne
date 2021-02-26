package day9_lab;

import java.util.Scanner;

public class OddRange {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter the Range : ");
		double range=s.nextLong();
		double start=1,sum=0;
		while(start<=range) {
			
			start+=2;
			sum+=start;
		}
		System.out.println(sum/(range/2));
		s.close();
	}

}