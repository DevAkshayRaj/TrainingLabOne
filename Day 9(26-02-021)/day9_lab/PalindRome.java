package day9_lab;

import java.util.Scanner;

public class PalindRome {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String ip = s.next();
		StringBuilder br = new StringBuilder(ip);
		String rev = br.reverse().toString();
		if (ip.equals(rev)) {
			System.out.println("The Input is Palindrome");
		} else {
			System.out.println("The Input is Not a Palindrome");
		}
		s.close();
	}
}
