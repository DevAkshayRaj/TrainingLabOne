package day5_lab;

public class JavaMcq10 {
	public static void main(String[] args) {
		int i=9;
		switch (i) {
		default:
		System.out.println("default");
		//break;
		case 0:
		System.out.println("zero");
		break;
		case 1:
		System.out.println("one");
		case 2:
		System.out.println("two");
		}// Here THe output is default , zero . since 9 is not a case identifier default gets executed .always default block should be 
		 // at the bottom of the switch case else it should have break keyword or else the case following the default block will be executed
		 // which makes it ill logical.
	}
}
