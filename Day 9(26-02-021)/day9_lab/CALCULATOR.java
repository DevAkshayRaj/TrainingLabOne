package day9_lab;

import java.util.Scanner;

public class CALCULATOR {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter the Two Numbers");
		double a=s.nextDouble();
		double b=s.nextDouble();
		//String sa=s.next();
		System.out.println("Please Enter the Operator (+,-,*,/)");
		char var=s.next().charAt(0);
		switch(var){
			case '+':
				System.out.println("The Sum Of Two Numbers is "+(a+b));
				break;
			case '-':
				System.out.println("The Difference Of Two Numbers is "+ (a-b) );
				break;
			case '*':
				System.out.println("The Multiplication Of Two Numbers is "+(a*b));
				break;
			case '/':
				System.out.println("The Division Of Two Numbers is "+(a/b));
				break;
			default:
				System.out.println("Enter a Proper Operation");
		}
		s.close();
	}
}	
