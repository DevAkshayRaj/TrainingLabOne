package day5_lab;

public class JavaClass18 {
	public static void main(String[] args) {
		String s1=new String("Hello");
		String s2=new String("there");
		String s3=new String();
		
		s3=s1 + s2; //string concat
		s3=s1-s2; // cannot subtract two strings
		s3=s1 & s2;// cannot do bitwise and using strings
		s3=s1 && s2// cannot perform and on two strings
	}

}
