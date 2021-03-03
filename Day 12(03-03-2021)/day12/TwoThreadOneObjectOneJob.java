package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwoThreadOneObjectOneJob {
	public static void main(String[] args) {
		Gun gun=new Gun();
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			for(int i=0;i<5;i++)
			{
				gun.fillGun();
			}
		});
		es.execute(()->{
			for(int i=0;i<5;i++)
			{
				gun.shootGun();
			}
		});
	}
}

class Gun {
	boolean bool;
	synchronized public void fillGun() {
		if(bool) {
			try {
				wait();
			}
			catch(Exception e) {}
		}
		System.out.println("I will Fill the Gun!!");
		bool=true;
		notify();
	}
	synchronized public void shootGun() {
		if(!bool) {
			try {
				wait();
			}
			catch(Exception e) {}
		}
		System.out.println("I will Shoot the Gun!!");
		bool=false;
		notify();
	}
}