package day9_lab;
import java.util.Scanner;
public class Pattern {
	public static void main(String[] args) {
		Scanner name = new Scanner(System.in);
		System.out.println("Enter Rows");
		int n=name.nextInt(),a=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(a+" ");
				a++;
			}
			System.out.println();
		}
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(0+" ");
			
			}
			System.out.println();
		}
		name.close();
	}

}
