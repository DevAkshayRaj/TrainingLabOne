package second_session;

//A Java Program to Calculate the Number of Days in a Month.
import java.util.Scanner;

public class MonthDays {
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Month:");
		String str=scanner.next();
		System.out.println("Enter the year:");
		int n=scanner.nextInt();
		if(str.equals("February"))
		{
			if(n%4==0) {
				if(n%100==0) {
					if(n%400==0) {
						System.out.println("28");
					}else {
						System.out.println("27");
					}
				}else {
					System.out.println("28");
				}
			}
			else
				System.out.println("27");
		}
		switch(str)
		{
			case "January":
				System.out.println("31");
				break;
			case "March":
				System.out.println("31");
				break;
			case "April":
				System.out.println("30");
				break;
			case "May":
				System.out.println("31");
				break;
			case "June":
				System.out.println("30");
				break;
			case "July":
				System.out.println("31");
				break;
			case "August":
				System.out.println("31");
				break;
			case "September":
				System.out.println("30");
				break;
			case "October":
				System.out.println("31");
				break;
			case "November":
				System.out.println("30");
				break;
			case "December":
				System.out.println("31");
				break;
			default:
				System.out.println("Enter the Correct Spelling ");
					
			
		}
		scanner.close();
	}
}
