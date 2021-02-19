package first_session;

//A java program to print an array in triangular shape.
public class TriangularArray {
	public static void main(String[] args) {
		int arr[][]=new int[4][],jcount=1;
		for(int i=0;i<arr.length;i++) {
			int temp[]=new int[i+1];
			for(int j=1;j<=i+1;j++) {
				temp[j-1]=jcount;
				jcount++;
			}
			arr[i]=temp;
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.print(arr[i][j]+ " ");
			}
			System.out.println();
		}		
	}

}
