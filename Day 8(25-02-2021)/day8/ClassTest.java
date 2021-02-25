package day8;

public class ClassTest {
	public static void main(String[] args) {
		ClassC c=new ClassC();
	}
}

class ClassA{
	int a;
	ClassA(int a){
		
		System.out.println("Class A");
	}
}

class ClassB{
	int b;
	ClassB(int b){
		
		System.out.println("Class B");
	}
}

class ClassC extends ClassA{
	ClassB b;
	ClassC(int a,int b){
		this.b.b=b;
		this.a=a;
		
	}
}
