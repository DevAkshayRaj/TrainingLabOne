package day6.lab;

public class PassByValueAndReference {
	public static void main(String[] args) {
		System.out.println("Pass By Value");
		System.out.println("Before");
		int i=10;
		System.out.println("i : "+i);
		System.out.println("After");
		Value.changeValue(i);
		System.out.println(i);
		System.out.println("Pass By Reference");
		Test t=new Test(5);
		System.out.println("Before");
		System.out.println(t.getVar());
		Reference.changeValue(t);
		System.out.println("After");
		System.out.println(t.getVar());
	}

}

class Test{
	private int var;

	public Test(int var) {
		this.var=var;
	}
	
	public void setVar(int var) {
		this.var = var;
	}


	public int getVar() {
		return var;
	}

}

class Reference{
	static void changeValue(Test i) {
		i.setVar(10);
	}
}

class Value{
	static void changeValue(int i) {
		i*=10;
	}
}