package day5_lab;

public class JavaMcq9 {
	public static void main(String[] args) {
		int i=1;
		switch (i) {
		case 0:
		System.out.println("zero");
		break;
		case 1:
		System.out.println("one");
		case 2:
		System.out.println("two");
		default:
		System.out.println("default");
		}
		/*Out put of one,two and default are printed because break statements are not used in case 1 and case 2;*/
	}

}
