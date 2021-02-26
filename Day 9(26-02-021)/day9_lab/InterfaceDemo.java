package day9_lab;

public class InterfaceDemo implements Demo{
	public static void main(String[] args) {
		Demo d=new InterfaceDemo();
		System.out.println(d.a);
	}
}

interface Demo{
	int a=5;
}