package second_session;

//A Java Program to generate prime numbers from 1 to 100
public class PrimeNumbers {
	
	public static void main(String[] args) {
		int n=100;
		boolean arr[]=new boolean[n+1];
		for(int i=1;i<=n;i++) {
			arr[i]=true;
		}
		for(int i=2;i*i<=n;i++) {
			if(arr[i]==true) {
				for(int j=i*i;j<=n;j+=i) {
					arr[j]=false;
				}
			}
		}
		for(int i=2;i<=n;i++) {
			if(arr[i]!=false) {
				System.out.print(i+" ");
			}
		}
	}

}
