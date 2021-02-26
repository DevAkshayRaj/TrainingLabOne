package day9_lab;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please Enter a Number : ");
		int input = scanner.nextInt();
		if (input < 1) {
			System.out.println(input + " is Not a PrimeNumber !");
		} else if (input == 1 || input == 2) {
			System.out.println(input + " is a PrimeNumber !");
		} else {
			int flag = 0;
			for (int i = 2; i <= (input / 2); i++) {
				if (input % i == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				System.out.println(input + " is a PrimeNumber !");
			} else {
				System.out.println(input + " is Not a PrimeNumber !");
			}
		}
		scanner.close();
	}

}
