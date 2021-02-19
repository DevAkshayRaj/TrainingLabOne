package first_session;
import java.util.Scanner;

//A Java PRogram to Sort an Array in ascending or descending order.
public class SortArray {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please Enter the Numbers : ");
		String[] input=scanner.nextLine().split(" ");
		int intArray[]=new int[input.length];
		for(int i=0;i<input.length;i++) {
			intArray[i]=Integer.parseInt(input[i]);
		}
		for(int i=0;i<input.length-1;i++) {
			for(int j=0;j<input.length-i-1;j++) {
				if(intArray[j]>intArray[j+1]) {
					int temp=intArray[j+1];
					intArray[j+1]=intArray[j];
					intArray[j]=temp;
				}
			}
		}
		for(int i:intArray) {
			System.out.print(i+" ");
		}
		scanner.close();
		
	}

}
