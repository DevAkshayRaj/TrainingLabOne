package day8;

public class ObjectCount {
	public static void main(String[] args) {
		System.out.println("No of objects for Counter clas is : "+ Counter.count);
		Counter c1=new Counter();
		System.out.println("No of objects for Counter clas is : "+ Counter.count);
		for(int i=0;i<=15;i++) {
			new Counter();
		}
		System.out.println("No of objects for Counter clas is : "+ Counter.count);
	}
}


class Counter{
	static int count=0;
	Counter(){
		count++;
	}
	
}