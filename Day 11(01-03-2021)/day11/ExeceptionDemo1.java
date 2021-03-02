package day11;

import java.io.IOException;

public class ExeceptionDemo1 {
	public static void main(String[] args) {
		Demo.method();
	}
}

class Demo{
	public static void method() {
		throw new IOException();
	}
}