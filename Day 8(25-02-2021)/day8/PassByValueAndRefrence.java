package day8;

import java.util.Arrays;

public class PassByValueAndRefrence {
	
	public static void changeValue(int[] a) {
		a[2]=10;
		a[0]=500;
	}
	
	public static void changeValue(Test45 a) {
		a.t=121;
	}
	
	public static void changeValue(int a) {
		a=12;
	}
	
			
	
	public static void main(String[] args) {
		int a=5;//primitive
		int []b={1,2,3,4,5};//Array
		Test45 c=new Test45(5);
		
		System.out.println("Before "+a);
		changeValue(a);
		System.out.println("After "+a);

		System.out.println("Before "+Arrays.toString(b));
		changeValue(b);
		System.out.println("After "+Arrays.toString(b));

		System.out.println("Before "+c.t);
		changeValue(c);
		System.out.println("After "+c.t);

		
	}

}

class Test45{
	int t;
	Test45(int t){
		this.t=t;
	}
}