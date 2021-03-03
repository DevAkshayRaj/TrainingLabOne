package day12;

public class LambdaDemo {
	public static void main(String[] args) {
		new test() {
			@Override
			public void temp() {
				System.out.println("Test printed from anonymous class ");
				
			}
		}.temp();
		
		test t=()->{System.out.println("Test printed from Lambda Expression");};
		t.temp();
		test1 a=(int m,String b)->{
			System.out.println("Test1 printed from Lambda");
				System.out.println("Int  : "+m);
				System.out.println("String : "+b);
			};
		a.temp(767, "Akshay");	
			
		test2 c=(int e,int f)->{
			
			return e+f;
		};
		int sum=c.add(344, 3242);
		System.out.println(sum);
	}

}

@FunctionalInterface
interface test{
	public void temp();
}


interface test1{
	public void temp(int a,String b);
}


interface test2{
	public int add(int a,int b);
}

