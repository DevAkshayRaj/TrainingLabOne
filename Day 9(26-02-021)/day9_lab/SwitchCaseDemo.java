package day9_lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

public class SwitchCaseDemo {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ip = br.readLine();
		Months months = new Months();
		Class c = months.getClass();
		Field f = c.getField(ip);
		int control = 7;
		if ((Integer) f.get(months) == 2 || (Integer) f.get(months) == 3) {
			control=0;
		} else if ((Integer) f.get(months) >= 4 && (Integer) f.get(months) <= 6) {
			control=1;
		} else if ((Integer) f.get(months) >= 7 && (Integer) f.get(months) <= 9) {
			control=2;
		} else if ((Integer) f.get(months) == 12 || (Integer) f.get(months) == 1) {
			control=3;
		} else {
			control=4;
		}

		switch (control) {
		case 0:
			System.out.println(ip + " comes under Spring Season ");
			break;
		case 1:
			System.out.println(ip + "c omes under Summer Season ");
			break;
		case 2:
			System.out.println(ip + "c omes under Summer Season ");
			break;
		case 3:
			System.out.println(ip + " comes under Winter Season ");
			break;
		case 4:
			System.out.println(ip + " comes under Autumn Season ");
			break;
		default:
			System.out.println("Enter Proper Month Name");

		}
	}

}
