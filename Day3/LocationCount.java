package second_session;
import java.util.Scanner;

//A Java Program to locate a element in the given array and count its occurence.
public class LocationCount {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("Please Enter the Numbers : ");
		String[] input=scanner.nextLine().split(" ");
		System.out.print("Please Enter the element to be found!");
		int key=scanner.nextInt();
		int intArray[]=new int[input.length],count=0,ia=-1;
		for(int i=0;i<input.length;i++) {
			intArray[i]=Integer.parseInt(input[i]);
		}
		int f=0;
		for(int i=0;i<intArray.length;i++) {
			if(intArray[i]==key) {
				ia=i;
				f=1;
				count++;
			}
		}
		if(f==0) {
			System.out.println("The given Key is not Present in the Array");
		}else {
			System.out.println("The "+key+" is Found in the "+(ia+1)+"th position in its Last Occurance and Occurs "+count+" Times in the Array");
		}
		scanner.close();
	}
}
