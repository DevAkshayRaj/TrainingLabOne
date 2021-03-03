package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo2 {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		Reservation r=new Reservation();
		es.execute(()->{
			
			synchronized(r){
			Thread.currentThread().setName("Akshay Raj");
			r.bookTicket(500);
			r.giveCHange();
			}
			r.attendCall();
		});
		
		es.execute(()->{
			synchronized(r) {
			Thread.currentThread().setName("Rohit sharma");
			r.bookTicket(700);
			r.giveCHange();
			}
		});
	}
}

class Reservation{
	int amount;
	 public void bookTicket(int amount) {
		this.amount=amount;
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Ticket Booked by "+name+" Costs "+amount);
//		try {
//			Thread.sleep(5000);
//		}catch(Exception e) {
//			
//		}
	}
	
	public void giveCHange() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Change of rs."+(amount-100)+" given to "+name);
		
	}
	
	synchronized public void attendCall() {
		Thread t=Thread.currentThread();
		String name=t.getName();
		System.out.println("Call Attended by "+name);
		try {
			Thread.sleep(2000);
		}catch(Exception e) {
			
		}
	}
}