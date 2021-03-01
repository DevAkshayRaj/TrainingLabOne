package day10;

public class ClassCastExceptionDemo {
	public static void main(String[] args) {
		B obj =new B();
		a o=(a)obj;
		o.doSome();
	}
}

interface a{
	public void doSome();
}

class B {
	public void dos() {
	}
}

	