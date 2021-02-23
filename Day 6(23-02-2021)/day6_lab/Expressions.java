package day6.lab;

public class Expressions {
	public static void main(String[] args) {
		System.out.println(13 / 4);//3
		System.out.println(2 + 12 / 4); //5
		System.out.println(21 % 5);//1
		System.out.println(3 - 5 % 7);//-2
		System.out.println(17.0 / 4);//4.25
		System.out.println(8 - 5 * 2.0);//-2.0
		System.out.println(14 + 5 % 2 - 3);//12
		System.out.println(15.0 + 3 / 2);//16.0
		
		//what is the output
		
		int a, b, c;
		double x, y;
		a = 17;
		b = 15;
		a = a + b / 4;
		c = a % 3 + 4;
		x = 17 / 3 + 6.5;
		y = a / 4.0 + 15 % 4 - 3.5;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(x);
		System.out.println(y); 
		
		int x=3,y=5,sum;
		double z=14.1;
		sum = x + y + (int) z;
		
		System.out.println(sum); //22
		
		//assignments
		x*=2;
		x+=(y-2);
		sum+=num;
		y/=(x+5);
		
		
	}
}
