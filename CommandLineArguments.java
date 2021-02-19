package first_session;

//A program to perform Addition of numbers using Command line arguments in java
public class CommandLineArguments {
	public static void main(String[] args) {
		int sum=0;
		for(String i:args) {
			sum+=Integer.parseInt(i);
		}
		System.out.println("The sum of the numbers passed in Command Line Arguments are : "+sum);
	}

}
