package second_session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//A Java Program to reverse each row in a 2D matrix.
public class TwoDimArray {
	
	static int[] convertToInt(String []a) {
		int temp[]=new int[a.length];
		for(int i=0;i<a.length;i++) {
			temp[i]=Integer.parseInt(a[i]);
		}
		return temp;
	}	
	static int[] reverseArray(int a[]) {
		int []revintArray=new int[a.length];
		for(int i=0;i<a.length;i++) {
			revintArray[i]=a[a.length-1-i];
		}
		return revintArray;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Number of Rows : ");
		int n=Integer.parseInt(br.readLine());
		int inputData[][]=new int[n][];
		//System.out.println();
		System.out.println("Enter the Elemets of each Row : ");
		for(int i=0;i<n;i++) {
			inputData[i]=convertToInt(br.readLine().split(" "));
		}
		for(int temp=0;temp<inputData.length;temp++) {
			//System.out.println(Arrays.toString(reverseArray(temp)));
			inputData[temp]=reverseArray(inputData[temp]);
		}
		for(int[] t:inputData) {
			System.out.println(Arrays.toString(t));
		}
	}

}
