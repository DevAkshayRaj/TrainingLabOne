package day8;

public class ComplexNumbers {
	Integer a,b,sum;
	public Integer add(Integer a,Integer b) {
		this.a=a;
		this.b=b;
		
		sum=this.a+this.b;
		
		return sum;
	}

	public static void main(String[] args) {
		
		Integer a=new Integer(5);
		Integer b=new Integer(7);
		
		ComplexNumbers cn=new ComplexNumbers();
		 System.out.println(cn.add(a, b));
	}
}
