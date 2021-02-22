package day5_lab;

public class JavaMcq2 {
	
	public static void main(String arguments[]) {
		amethod(arguments); //error Can't make static reference to void amethod.
		}
		public void amethod(String[] arguments) {//make this method static 
		System.out.println(arguments);
		System.out.println(arguments[1]);
		}

}
