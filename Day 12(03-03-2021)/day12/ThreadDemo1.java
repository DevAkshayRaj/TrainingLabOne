package day12;

public class ThreadDemo1 {
	public static void main(String[] args) {
		System.out.println("1");
		new Thread(()->{met();}).start();
		System.out.println("3");
	}
	public static void met() {
		try {
		Thread.sleep(5000);
		}catch(Exception e) {
			
		}
		System.out.println("2");
	}
}
