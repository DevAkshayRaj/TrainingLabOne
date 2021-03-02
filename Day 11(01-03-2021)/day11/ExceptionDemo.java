package day11;

import java.util.Scanner;

public class ExceptionDemo {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int age=0;
		
			try {
				System.out.println("Please Enter Age !");
				age=s.nextInt();
				AgeLimit.validateAge(age);
				
			}
			catch(Throwable t) {
				System.out.println(t);
			}
			finally{
				s.close();
			}
		
		
	}

}

class AgeLimit {
	public static void validateAge(int age) throws CustomException{
		if(age<=18 ) {
			throw new CustomException("Age Should Not be Less than 18");
		}
		if(age>60) {
			throw new CustomException("Age Should Not be Greater than 60");
		}
	}
}

class CustomException extends Throwable{
	String m;
	public CustomException(String m) {
		this.m=m;
	}
	public CustomException() {
		
	}
	@Override
	public String toString() {
		
		return this.m;
	}
	
}
