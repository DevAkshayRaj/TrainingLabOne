package day9_lab;
import java.util.Scanner;

public class Vowels {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		char ip=' ';
		while(ip!='[') {
		 ip=s.next().charAt(0);
		switch(ip){
			case 'a':
				System.out.println("'a' is a Vowel");
				break; 
			case 'e':
				System.out.println("'e' is a Vowel");
				break;
			case 'i':
				System.out.println("'i' is a Vowel");
				break; 
			case 'o':
				System.out.println("'o' is a Vowel");
				break; 
			case 'u':
				System.out.println("'u' is a Vowel");
				break; 
			default:
				System.out.println(ip+" is not a Vowel");
		}
		}
		s.close();
	}
}
