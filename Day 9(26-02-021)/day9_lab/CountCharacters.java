package day9_lab;

import java.util.Scanner;

public class CountCharacters {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		String ip=s.nextLine();
		int num=0,let=0,space=0,others=0;
		for(int i=0;i<ip.length();i++) {
			char temp=ip.charAt(i);
			if(temp>='0'&& temp <='9') {
				num++;
			}
			else if(temp>='a'&&temp<='z' || temp >='A' && temp<= 'Z'){
				let++;
			}
			else if(temp==' ') {
				space++;
			}
			else {
				others++;
			}
		}
		System.out.println("letter: " + let);
		System.out.println("space: " + space);
		System.out.println("number: " + num);
		System.out.println("other: " + others); 

		s.close();
	}

}
