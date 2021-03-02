package day11;

import java.util.Scanner;

public class ExceptionDemo2 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String p="1",q="1";
		int a=1,b=1;
		while(!(p.startsWith("q")||p.startsWith("Q"))) {
			try {
				System.out.println("Please Enter Numerator !");
				p=s.next();
				a=Integer.parseInt(p);
				System.out.println("Please Enter Denominator !");
				q=s.next();
				b=Integer.parseInt(q);
				System.out.println("The Quotient is : "+(a/b));
				
			}
			catch(Exception t) {
				System.out.println(t);
			}
		}
	s.close();
		
	}
}
