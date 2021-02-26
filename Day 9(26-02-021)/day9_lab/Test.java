package day9_lab;

public class Test {
	public static void main(String[] args) {
		/*
		 * int a = 1; int b = 2; int c; int d; c = ++b; d = a++; c++;
		 * System.out.println(c+" "+d);//4 1
		 * 
		 * a = 4; b = 1; Boolean ca = a<b; System.out.println(ca);
		 * 
		 * boolean a, b, c, d, e, f, g; a = true; b = false; c = a | b; d = a & b; e = a
		 * ^ b; f = (!a & b) | (a & !b); g = !a;
		 * System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f+" "+g);
		 */
		int a, b, x;
		a = 20;
		b = 10;
		x = a > b ? a : b;
		System.out.println(x);
	}
}
