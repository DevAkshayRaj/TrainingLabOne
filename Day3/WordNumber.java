package second_session;
import java.util.Scanner;

//A Java Program to Spell the Numeric words.
public class WordNumber {
	
	static String getWords(int n) {
		if(n==1)
			return "One";
		if(n==2)
			return "Two";
		if(n==3)
			return "Three";
		if(n==4)
			return "Four";
		if(n==5)
			return "Five";
		if(n==6)
			return "Six";
		if(n==7)
			return "Seven";
		if(n==8)
			return "Eight";
		if(n==9)
			return "Nine";
		if(n==0)
			return "Zero";
		return null;
	}
	static String toWords(int n) {
		String result=" ";
		while(n>0) {
			result=" "+getWords(n%10)+result;
			n/=10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please Enter the Number : ");
		int n=scanner.nextInt();
		System.out.println(toWords(n));
		scanner.close();
	}
}
