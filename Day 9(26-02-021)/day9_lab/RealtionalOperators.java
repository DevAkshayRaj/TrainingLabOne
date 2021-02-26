package day9_lab;

public class RealtionalOperators {
	public static void main(String[] args) {
		int a,b,c;
		a=45;
		b=434;
		c=3432;
		int big=(a>b?a>c?a:c:b>c?b:c);
		System.out.println("Bigger of the three is : "+big);
	}

}
