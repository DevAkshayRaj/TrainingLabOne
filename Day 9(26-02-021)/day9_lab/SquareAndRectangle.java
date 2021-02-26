package day9_lab;

public class SquareAndRectangle {
	static void calcArea(int a) {
		System.out.println("Area of Square is : " + a * a);
	}

	static void calcArea(int a, int b) {
		System.out.println("Area of Rectangle is : " + a * b);
	}

	static void calcPerimeter(int a) {
		System.out.println("Perimeter of Square is : " + 2 * a);
	}

	static void calcPerimeter(int a, int b) {
		System.out.println("Perimeter of Rectangle is : " + 2 * (a + b));
	}

	public static void main(String[] args) {
		calcArea(89);
		calcArea(9, 8);
		calcPerimeter(89);
		calcPerimeter(9, 8);
	}
}
