package day16;

public class StringFormatting {
	public static void main(String[] args) {
		int a,b,c;
		a=56;
		b=45;
		c=a+b;
		System.out.printf("The sum of %d and %d is %d",a,b,c);
		
		String aa="Akshay";
		
		System.out.printf("\nPrinting string using Printf %s",aa);
		
		float f=89.24f;
		
		System.out.printf("\nPrinting string using Printf %.3f",f);
		
		System.out.printf("\nPrinting string using left side padding in Printf %15s Hai",aa);
		
		System.out.printf("\nPrinting string using right side padding in Printf %-15s Hai ",aa);
		
		System.out.printf("\nPrinting int using Zero padding in Printf %081d",a);
		
		System.out.printf("\nPrinting int using Zero padding in Printf %07d",a);
		
		System.out.printf("\nPrinting int using left side space padding in Printf %15d Hai",b);
		
		System.out.printf("\nPrinting int using right side space padding in Printf %-15d Hai",b);
		
		System.out.printf("\nAkshay\t Raj \n Bye \t\tAk");
		
		
	}
}
