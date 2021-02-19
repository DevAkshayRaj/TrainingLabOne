package second_session;

//A Java Program to test a class with ill legal modifier
public class Test {
 
public static void main(String[] args) {
	
}
	
}

protected class base { 
	String Method() { 
		return "Wow";  
	} 
} 
class dervied { 
	public void useD() { 
		
		base z = new base();
		System.out.println("base says, " + z.Method()); 
	} 
} 
