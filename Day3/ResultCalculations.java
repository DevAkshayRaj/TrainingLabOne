package first_session;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//A Java Program to Calculate Students Results using 2D Array.
public class ResultCalculations {
	
	static int[] convertToInt(String []a) {
		int temp[]=new int[a.length];
		for(int i=0;i<a.length;i++) {
			temp[i]=Integer.parseInt(a[i]);
		}
		return temp;
	}
	
	static float calculateAverage(int []arr) {
		float average=0f;
		int sum=0;
		for(int i:arr) {
			sum+=i;
		}
		average=(float)(sum/arr.length);
		return average;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Number of Students : ");
		int n=Integer.parseInt(br.readLine());
		int studentsData[][]=new int[n][];
		System.out.print("Enter the Subject Marks of Students : ");
		for(int i=0;i<n;i++) {
			studentsData[i]=convertToInt(br.readLine().split(" "));
		}
		for(int i=0;i<studentsData.length;i++) {
			System.out.println("Student "+(i+1)+"'s Average : "+calculateAverage(studentsData[i]));
		}
	}

}
