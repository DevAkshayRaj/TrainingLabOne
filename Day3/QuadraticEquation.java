package second_session;

//A Java Program to represent a quadratic equation with its functions.
public class QuadraticEquation {
	private int a;
	private int b;
	private int c;
	public QuadraticEquation() {
		a=1;
		b=1;
		c=1;
	}
	public QuadraticEquation(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getC() {
		return c;
	}
	void setValues(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	int compute(int x) {
		int ans=0;
		ans=(a*x*x)+(b*x)+c;
		return ans;
	}
	public static void main(String[] args) {
		QuadraticEquation equation=new QuadraticEquation();
		QuadraticEquation equation1=new QuadraticEquation(2,3,4);
		equation.setValues(7, 8, 9);
		System.out.println("Output of Equation 1 with values "+equation.getA()+" "+equation.getB()+" "+equation.getC()+" is "+equation.compute(5)+" when the value of x is 5.");
		System.out.println("Output of Equation 2 with values "+equation1.getA()+" "+equation1.getB()+" "+equation1.getC()+" is "+equation1.compute(10)+" when the value of x is 10.");
		
	}
}
