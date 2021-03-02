package day11;

public class Sample {
	public void mth1() {
		mth2();
		System.out.println("Caller");
	}
	public void mth2() {
		try {
			Integer.parseInt("a");
			System.exit(0);
		}
		catch(Exception e) {
			System.out.println("Catch-mth2");
		}
		finally {
			System.out.println("Finally Mth2");
		}
	}
	public static void main(String[] args) {
		Sample s=new Sample();
		s.mth1();
	}
}
