package day8;

public class Singleton {

	public static void main(String[] args) {
		Single s=Single.getObj();
		s.a=5;
		Single b=Single.getObj();
		System.out.println( s +" "+b);
		System.out.println(b.a);
		b.add(5, 0);
	}
}

class Single{
	static private Single obj=new Single();
	int a;

	public static Single getObj() {
		return obj;
	}

	public final void setObj(Single obj) {
		this.obj = obj;
	}
	private Single(){
		
	}
	
	public void add(int a,int b) {
		System.out.println("Sum : "+(a+b));
	}
}