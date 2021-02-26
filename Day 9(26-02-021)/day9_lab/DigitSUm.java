package day9_lab;

import java.util.Scanner;

public class DigitSUm{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String ip = s.next();
		int sum=0;
		for(int i=0;i<ip.length();i++) {
			sum+=Integer.parseInt(Character.toString(ip.charAt(i)));
		}
		System.out.println(sum);
		s.close();
	}
}