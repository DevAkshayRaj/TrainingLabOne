package day9_lab;

public class InheritanceDemo {
	public static void main(String[] args) {
		A b=new C();
		System.out.println(b.a);
	}
}

class A{
	int a=10;
	public A() {
		System.out.println("Parent Constructor");
	}
}

class B extends A{
	public B() {
		System.out.println("1st Child COnstructor");
	}
}

class C extends B{
	public C() {
		System.out.println("2nd Child COnstructor");
	}
}