package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorThreadFactory {
	static Thread t;
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(1, new ThreadFactory() {
			@Override
			public Thread newThread(Runnable r) {
				// TODO Auto-generated method stub
				t=Executors.defaultThreadFactory().newThread(r);
				t.setName("MyThread");
				System.out.println("Thread...");
				return t;
			}
		});
		es.execute(()->{
			System.out.println("Thread Called!!");
		});
		System.out.println(t);
	}
}

