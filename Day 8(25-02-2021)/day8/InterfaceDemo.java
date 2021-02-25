package day8;

public class InterfaceDemo {
	static void Ione(One a) {
		a.add(5, 6);
	}
	
	static void Itwo(Two b) {
		b.divide(45, 8);
	}
	
	static void Ithree(Three c) {
		c.multiply(45, 45);
	}
	
	static void Ifour(Test d) {
		d.mainTest();
	}
	
	public static void main(String[] args) {
		DriverClass dr=new DriverClass();
		Ione(dr);
		Itwo(dr);
		Ithree(dr);
		Ifour(dr);
	}

}


interface One{
	void print();
	void add(int a,int b);
}

interface Two{
	void print();
	void divide(double a,double b);
}

interface Three{
	void print();
	void multiply(int a,int b);
	
}

interface Test extends One,Two,Three{
	void mainTest();
}

class DriverClass extends InterfaceDemo implements Test{

	@Override
	public void print() {
		System.out.println("Common Method");
		
	}

	@Override
	public void add(int a, int b) {
		System.out.println(a+b);
		
	}

	@Override
	public void divide(double a, double b) {
		System.out.println(a/b);
		
	}

	@Override
	public void multiply(int a, int b) {
		System.out.println(a*b);
		
	}

	@Override
	public void mainTest() {
		System.out.println("Main Interface Method");
		
	}
	
}