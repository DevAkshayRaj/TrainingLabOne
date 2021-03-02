package day11;

import java.io.IOException;

public class ConstructorExceptionDemo {
	public static void main(String[] args) {
		
	}
}

class Demo1{
	public Demo1() throws IOException{
		throw new IOException();
	}
}

class Demo2 extends Demo1{
	public Demo2() throws Exception{
	
	}
}
