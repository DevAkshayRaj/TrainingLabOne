package day8;

public class OrderOfInitialization {
	public static void main(String[] args) {
		OrderDemo od=new OrderDemo();
	}

}

class OrderDemo{
	static {
		System.out.println("This is the Static Block");
	}
	
	{
		System.out.println("This is the Instance Block");
	}
	
	public OrderDemo(){
		System.out.println("This is the Constructor");
	}
	InstanceVariable iv=new InstanceVariable();
}

class InstanceVariable{
	public InstanceVariable(){
		System.out.println("This is the Instance Variable Constructor");
	}
}
