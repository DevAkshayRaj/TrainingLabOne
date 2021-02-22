package first_session;
import java.util.Scanner;

//A Java Program to Reverse the given Array. 
public class ReverseArray {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please Enter the Numbers : ");
		String[] input=scanner.nextLine().split(" ");
		int intArray[]=new int[input.length];
		int revintArray[]=new int[input.length];
		for(int i=0;i<input.length;i++) {
			intArray[i]=Integer.parseInt(input[i]);
		}
		for(int i=0;i<input.length;i++) {
			revintArray[i]=intArray[input.length-1-i];
		}
		for(int i:revintArray) {
			System.out.print(i+" ");
		}
		scanner.close();
	}

}
