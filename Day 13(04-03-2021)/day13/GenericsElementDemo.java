package day13;

public class GenericsElementDemo {
	public static void main(String[] args) {
		Gen g=new Gen();
		String arr[]= {"Akshay","Raj","aishu","uma","bala"};
		Integer a[]= {264,178,168,209};
		g.getSome(arr);
		g.getSome(a);
	}
}

class Gen{
	public <E> E getSome(E []ele) {
	for(E a:ele) {
		System.out.println(a);
	}
		return null;
	}
}