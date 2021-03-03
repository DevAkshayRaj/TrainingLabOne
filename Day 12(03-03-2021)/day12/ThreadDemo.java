package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ThreadDemo {
	public ThreadDemo() {
//		Thread t=new Thread(new A());
//		t.start();
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{System.out.println("Printed using Lambda Expression");});
		es.shutdown();
	}
	public static void main(String[] args) throws Exception{
		new ThreadDemo();
		Thread t=Thread.currentThread();
		t.setName("Akshay");
		System.out.println(t);
		for(int i=0;i<5;i++) {
			System.out.println(i);
			Thread.sleep(1000);
		}
	}
}

//class A implements Runnable{
//	@Override
//	public void run() {
//		System.out.println("From Run of A class");
//		
//	}
//}