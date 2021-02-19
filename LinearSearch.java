package first_session;
import java.util.Scanner;

//A Java Program to find the Location of an Element.
public class LinearSearch {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please Enter the Numbers : ");
		String[] input=scanner.nextLine().split(" ");
		System.out.print("Please Enter the element to be found!");
		int key=scanner.nextInt();
		int intArray[]=new int[input.length];
		for(int i=0;i<input.length;i++) {
			intArray[i]=Integer.parseInt(input[i]);
		}
		int f=0;
		for(int i=0;i<intArray.length;i++) {
			if(intArray[i]==key) {
				System.out.println("The "+key+" is Found in the "+(i+1)+"th position");
				f=1;
				break;
			}
		}
		if(f==0) {
			System.out.println("The given Key is not Present in the Array");
		}
		scanner.close();
	}

}
