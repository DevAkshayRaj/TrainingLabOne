package second_session;

 class Driver3 {
	protected int a;
	protected int b;
	protected int sum;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}

}
public class ProtectedTest{
	public static void main(String[] args) {
		Driver3 obj=new Driver3();
		obj.setA(45);
		obj.setB(56);
		obj.setSum(obj.getA()+obj.getB());
		System.out.println("The sum is : "+ obj.getSum());
	}
}
