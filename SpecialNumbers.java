package second_session;
import java.util.Scanner;

//A Java Program to test if a given number is perfect,Armstrong,palindrome. 
public class SpecialNumbers {
	static int reverse(int n,int index) {
		int ans=0,count=0;
		while(n>0) {
			ans=(ans*10)+(n%10);
			n/=10;
			count++;
		}
		if(index==0)
			return ans;
		else
			return count; 
	}
	static boolean isPalindrome(int n) {
		boolean flag=false;
		//System.out.println(reverse(n,0));
		if(n==reverse(n,0))
			flag=true;
		return flag;
	}
	static boolean isArmstrong(int n) {
		boolean flag=false;
		int sum=0,x=reverse(n,1),copy=n;
		//System.out.println(x);
		while(n>0) {
			sum+=Math.pow(n%10,x);
			n/=10;
		}
		//System.out.println(sum+" "+n);
		if(sum==copy)
			flag=true;
		//System.out.println(flag);
		return flag;
		
	}
	static boolean isPerfect(int n) {
		boolean flag=false;
		int sum=0;
		for(int i=1;i<n;i++) {
			if(n%i==0)
				sum+=i;
		}
		//System.out.print(sum);
		if(sum==n)
			flag=true;
		return flag;
		
	}
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please Enter a Number : ");
		int input=scanner.nextInt();
		if(isPalindrome(input))
			System.out.println("The given Number is a Palindrome");
		else if(isArmstrong(input))
			System.out.println("The given Number is a Armstrong Number");
		else if(isPerfect(input))
			System.out.println("The given Number is a Perfect Number");
		scanner.close();
		
	}

}
