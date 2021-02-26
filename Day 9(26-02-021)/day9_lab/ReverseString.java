package day9_lab;

import java.util.Scanner;

public class ReverseString {
	
	static String doReverse(String input) {
		String reverse="";
		for(int i=input.length()-1;i>=0;i--) {
			reverse+=Character.toString(input.charAt(i));
		}
		
		return reverse;
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String ip=s.next();
		ip=doReverse(ip);
		System.out.println("Reversed String : "+ip);
		s.close();
		
	}

}
