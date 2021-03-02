package day11;

import java.util.Scanner;

public class NumberFormatException {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String a = null;
		int avg = 0;
		while (true) {
			try {
				System.out.print("Please Enter Mark 1 input : ");
				a = s.next();
				avg += Integer.parseInt(a);
				NumberFormat.validateNumber(a);
				System.out.print("Please Enter Mark 2 input : ");
				a = s.next();
				avg += Integer.parseInt(a);
				NumberFormat.validateNumber(a);
				System.out.print("Please Enter Mark 3 input : ");
				a = s.next();
				avg += Integer.parseInt(a);
				NumberFormat.validateNumber(a);
				System.out.println("The Average of the subjects is : " + avg);
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				System.out.println();

			}

		}
	}
}

class NumberFormat {
	public static void validateNumber(String ip) throws UserNumberException {
		if (Integer.parseInt(ip) < 0) {
			throw new UserNumberException("The input should not have Negative Numbers");
		} else if (Integer.parseInt(ip) <= 0 || Integer.parseInt(ip) > 100) {
			throw new UserNumberException("The input should be in the Range of (1-100)");
		}
	}
}

class UserNumberException extends Exception {
	String ip;

	public UserNumberException(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {

		return this.ip;
	}
}