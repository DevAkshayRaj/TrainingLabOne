package second_session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//A Java Program to find the max element in each row of a 2D array
public class TwoDimArray1 {
	static int[] convertToInt(String []a) {
		int temp[]=new int[a.length];
		for(int i=0;i<a.length;i++) {
			temp[i]=Integer.parseInt(a[i]);
		}
		return temp;
	}	
	static int getMax(int a[]) {
		int max=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>max)
				max=a[i];
		}
		return max;
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
			System.out.println("Max Element in Row Number: "+(temp+1)+" is "+getMax(inputData[temp]));			
		}
	
	}
}
