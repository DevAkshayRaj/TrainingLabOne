package day13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkAndJoinDemo {
	public static void main(String[] args) {
		ForkJoinPool fpl=ForkJoinPool.commonPool();
		ArrayHolder ah=new ArrayHolder();
		int arr[]=ah.arr;
		RecursiveTask<Integer> t1=new Find(arr,0,5,4);
		RecursiveTask<Integer> t2=new Find(arr,5,10,4);
		RecursiveTask<Integer> t3=new Find(arr,10,14,4);
		RecursiveTask<Integer> t4=new Find(arr,14,18,4);
		int r1=fpl.invoke(t1);
		int r2=fpl.invoke(t2);
		int r3=fpl.invoke(t3);
		int r4=fpl.invoke(t4);
		int result=r1+r2+r3+r4;
		System.out.println("Number of '4' in the given array is "+ result);
		
	}
}
class Find extends RecursiveTask<Integer>{
	int arr[],start,end,key;
	
	public Find(int[] arr, int start, int end, int key) {
		super();
		this.arr = arr;
		this.start = start;
		this.end = end;
		this.key = key;
	}

	@Override
	protected Integer compute() {
		int count=0;
		for(int i=start;i<end;i++) {
			if(arr[i]==key)
				count++;
		}
		return count;
	}
	
}
class ArrayHolder{
	int arr[]=new int[]{1,2,3,4,4,4,5,6,7,8,9,4,5,4,3,4,2,4};
}