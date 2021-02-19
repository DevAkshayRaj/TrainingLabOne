package first_session;
import java.util.Scanner;

//A Java PRogram to Create an Array with the given size (i.e resizeable with respect to users input)
public class ResizeArray {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int size=scanner.nextInt();
		int Array[]=new int[size];
		System.out.println("The size of the Array Created is : "+ Array.length);
		scanner.close();
	}

}
