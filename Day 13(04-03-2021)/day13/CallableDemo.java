package day13;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	public static void main(String[] args) throws Exception{
		ExecutorService es=Executors.newFixedThreadPool(1);
		Future<String> s=es.submit(new Call());
		System.out.println(s.get());
		es.shutdown();
		ExecutorService e=Executors.newFixedThreadPool(1);
		Future<String> fa=e.submit(()->{
			try {
				Thread.sleep(3000);
			}catch(Exception ea) {
				
			}
			return "AkshayRaj";
		});
		System.out.println(fa.get());
		e.shutdown();
		
	}
}

class Call implements Callable<String>{
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		}catch(Exception e) {
			
		}
		return "Akshay";
	}
}
