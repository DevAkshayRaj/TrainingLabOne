package day19;

public class LambdaDemo {
	public LambdaDemo() {
		
	}
	public LambdaDemo(int a,int b) {
		System.out.println("Method referenceing using Constructor "+a+b);
	}
	static int aa=5;
	public static void main(String[] args) {
		int c=909;
		Adder add=(a,b)->{
			System.out.println(a+b+aa+c);
		};
		
		add.add(45, 450);
		
		Adder temp=new LambdaDemo()::adderMthod;
		temp.add(34, 324);
		
		Adder tea=LambdaDemo::asdderMthod;
		tea.add(c, c);
		
		Adder teas=LambdaDemo::new;
		
		teas.add(c, c);
		
	}
	public void adderMthod(int a,int b) {
		System.out.println("Method referenceing using normal method "+a+b);
	}
	public static void asdderMthod(int a,int b) {
		System.out.println("Method referenceing using static method "+a+b);
	}
}

@FunctionalInterface
interface Adder{
	public void add(int a,int b);
}