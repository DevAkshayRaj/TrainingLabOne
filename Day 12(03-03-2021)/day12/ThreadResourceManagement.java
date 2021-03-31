package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadResourceManagement {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			Laptop laptop=Office.getLaptop("ram");
			Laptop laptop1=Office.getLaptop("ram");
		});
		es.execute(()->{
			Laptop laptop=Office.getLaptop("som");
			Laptop laptop1=office.getLaptop("som");
		});
	}
}
class Office {
	private static ThreadLocal locker=new ThreadLocal();
	public static Laptop getLaptop(String name) {
		Laptop laptop=(Laptop)locker.get();
		if(laptop==null)
		{
			laptop=new Laptop(name);
			locker.set(laptop);
		}
		return laptop;
	}
	public static void removeLaptop() {
		Laptop laptop=(Laptop)locker.get();
		if(laptop!=null)
		{
			locker.remove();
		}
	}
}

class Laptop {
	String name;
	public Laptop(String name) {
		System.out.println("Laptop created....");
		this.name=name;
	}
	@Override
	public String toString() {
		return "Laptop belongs to..:"+name;
	}	
}
