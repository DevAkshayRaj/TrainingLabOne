package day9_lab;

import java.util.Arrays;

public class ArraySwap {
	public static void main(String[] args) {
		int a[]= {31,32,33,43,35,64};
		int b[]= {55,52,33,73,65,64};
		System.out.println("Before");
		System.out.println("A:"+Arrays.toString(a));
		System.out.println("B:"+Arrays.toString(b));
		for(int i=0;i<a.length;i++) {
			a[i]=a[i]+b[i];
			b[i]=a[i]-b[i];
			a[i]=a[i]-b[i];
		}
		System.out.println("After");
		System.out.println("A:"+Arrays.toString(a));
		System.out.println("B:"+Arrays.toString(b));
	}
}
