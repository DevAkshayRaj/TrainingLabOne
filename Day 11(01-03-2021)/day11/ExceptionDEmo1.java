package day11;

import java.util.Scanner;

public class ExceptionDEmo1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String p="1",q="1";
		int a=1,b=1;
		while(true) {
			try {
				System.out.println("Please Enter Numerator !");
				p=s.next();
				a=Integer.parseInt(p);
				System.out.println("Please Enter Denominator !");
				q=s.next();
				b=Integer.parseInt(p);
				System.out.println("The Quotient is : "+(a/b));
				
			}
			catch(Exception t) {
				System.out.println(t);
			}
		}
		
	}

}