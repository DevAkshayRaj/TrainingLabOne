package day6_concepts;


/* If Both the Parent and the child class has the exact same method with same prototype then overriding comes into picture. 
 * 
 */
public class OverRidingDemo {

	public static void main(String[] args) {
		ClassOne t=new ClassThree();
		t.play(5,6);
		System.out.println(t.c);
		
	}
}


class ClassOne{
	int c=5;
	public void play(int a,int b) {
		System.out.println("Base "+(a+b));
	}
}

class ClassTwo extends ClassOne{
	int b=6;
	@Override
	public void play(int a,int b) {
		System.out.println("Middle Child "+(a+b));
		c=15;
	}
	
}

class ClassThree extends ClassOne{
	int a=7;
	@Override
	public void play(int a, int b) {
		super.play(7,8);
		System.out.println("Last Child "+(a+b));
		c=10;
	}
}