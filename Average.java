package first_session;
import java.util.Scanner;

//A Java Program to Calculate Average of N numbers.
public class Average {
	
	static float calculateAverage(String[] input) {
		int sum=0;
		for(String i:input) {
			sum+=Integer.parseInt(i);
		}
		float average=(float)sum/(input.length);
		return average;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please Enter the Numbers : ");
		String[] input=scanner.nextLine().split(" ");
		System.out.println("The average of Entered Numbers is : "+calculateAverage(input));
		scanner.close();
		
	}
}
