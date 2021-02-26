package day9_lab;

public class Swap {
	static Integer a=new Integer(10);
	static Integer b=new Integer(20);
	static void doSwap() {
		a=a+b;
		b=a-b;
		a=a-b;
		//System.out.println("Before SWapping  A : "+a+" B : "+b);
	}
	public static void main(String[] args) {

		System.out.println("Before SWapping  A : "+a+" B : "+b);
		doSwap();
		System.out.println("After SWapping  A : "+a+" B : "+b);
		
	}

}
