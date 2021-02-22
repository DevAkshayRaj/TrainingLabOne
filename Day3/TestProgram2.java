package second_session;

//A Java Program to test the accessibility of methods with different access specifiers.
public class TestProgram2 {
	 int v1;
	 private int v2;
	 protected int v3;
	 public int v4;
	 int getV1() {
		return v1;
	}
	private void setV1(int v1) {
		this.v1 = v1;
	}
	protected int getV2() {
		return v2;
	}
	public void setV2(int v2) {
		this.v2 = v2;
	}
	public int getV3() {
		return v3;
	}
	public void setV3(int v3) {
		this.v3 = v3;
	}
	private int getV4() {
		return v4;
	}
	public void setV4(int v4) {
		this.v4 = v4;
	}
	 
}
class Driver{
	public static void main(String[] args) {
		TestProgram2 obj=new TestProgram2();
		obj.setV2(5);
		obj.setV1(4);
		obj.setV3(3);
		obj.setV4(5);
		obj.getV1();
		obj.getV2();
		obj.getV3();
		obj.getV4();
		
	}
}
