package day5_lab;

public class JavaMcq11 {
	public static void main(String[] args) {
		int i=0;
		if(i) { // Java Accepts only boolean values as arguments in conditional statements. 
		System.out.println("Hello");
		}
		
		boolean b=true;
		boolean b2=true;
		if(b==b2) {
		System.out.println("So true");
		}
		
		int ia=1;
		int j=2;
		if(ia==1|| j==2)
		System.out.println("OK");
		
		int ib=1;
		int jb=2;
		if(ib==1 &| jb==2) // The relational operator used here has a wrong syntax ( and(&&) or(||) )
		System.out.println("OK");
	}
}
