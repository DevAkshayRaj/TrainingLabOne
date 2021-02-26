package day9_lab;

class OverDemo{
	int a;
	void setA(int a) {
		this.a=a;
	}
	 void getA() {
		 System.out.println(this.a);
	 }
}
class O extends OverDemo{
	int a;
	@Override
	void setA(int a) {
		super.setA(5);
		super.getA();
		this.a=a;
		System.out.println(a);
	}
}
public class SuperDemo{
	public static void main(String[] args) {
		O a=new O();
		a.setA(8);
	}
}

