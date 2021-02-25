package day8;

public class AccessSpecifiers {

	public static void main(String[] args) {
		DemoTwo td=new DemoTwo();
		td.access();
	}
}


class DemoOne{
	
	private int a=5;
	protected int b=10;
	int c=45;
	public int d=445;
	
}
class DemoTwo extends DemoOne{
	
	public void access() {
		System.out.println(a);// private cannot be accessed outside the classs
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}