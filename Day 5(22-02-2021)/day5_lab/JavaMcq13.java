package day5_lab;

class Base {
	
}

class Sub extends Base {
	
}

class Sub2 extends Base {
	
}

public class JavaMcq13{
	
	public static void main(String argv[]){
		Base b=new Base();
		Sub s=(Sub) b;
	}
	/*We get a runtime error java.lang.ClassCastException:  because base class object cannot be stored or type casted to a sub class 
	 * reference , it should be the other way around.
	 *  
	 */
}