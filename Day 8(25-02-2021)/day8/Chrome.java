package day8;



class X {
	void do1() { 
		
	} 
}
class Y extends X { 
	void do2() { 
		System.out.println("Do2");
	} 
}
public class Chrome {
	public static void main(String [] args) {
		X x1 = new X();
		X x2 = new Y();
		Y y1 = new Y();
		Y y2=(Y)x2;
		y2.do2();
}
}