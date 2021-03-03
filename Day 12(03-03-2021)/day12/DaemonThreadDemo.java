package day12;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class DaemonThreadDemo {
	
	public void Daemon() {
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(true)
			System.out.println("Akshay");
		});
	}
	public static void main(String[] args) {
		new DaemonThreadDemo().Daemon();
		System.out.println("main Tread Started");
		
		
		Thread t=Thread.currentThread();
		System.out.println(t);
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}

		System.exit(1);
	}
}
