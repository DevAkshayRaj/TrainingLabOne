package day8;
import vehicle.InterfaceTest;

public class InterTest {
	public static void main(String[] args) {
		InterfaceTest itObj=new Driver();
		itObj.methodOne();
		itObj.methodTwo();
		itObj.methodThree();
	}

}

class Driver implements InterfaceTest{

	@Override
	public void methodOne() {
		System.out.println("I am Method One");
		
	}

	@Override
	public void methodTwo() {
		System.out.println("I am Method Two");
		
	}

	@Override
	public void methodThree() {
		System.out.println("I am Method Three");
		
	}
	
}