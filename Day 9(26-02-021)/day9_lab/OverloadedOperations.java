package day9_lab;

public class OverloadedOperations {
	public static void main(String[] args) {
		Operations op=new Operations();
		op.add(56.56, 34.5435);
		op.add(3223, 23332);
	}
}

class Operations{
	void add(int a,int b) {
		System.out.println(a+b);
	}
	
	void add(float a,float b) {
		System.out.println(a+b);
	}
	void add(double a,double b) {
		System.out.println(a+b);
	}
}
