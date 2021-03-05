package day14;

import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ObserverDemo {
	public static void main(String[] args) {
		FireAlarm11 f=new FireAlarm11();
		Student1 s=new Student1();
		Teacher1 t=new Teacher1();
		Teacher2 t2=new Teacher2();
	    f.addObserver(s);
	    f.addObserver(t);
	    f.addObserver(t2);
	    f.setAlarm();
	}
}


class MultiThreadedObservable1 extends Observable{
	Vector<Observer> v=new Vector<>();
	@Override
	public synchronized void addObserver(Observer o) {
		v.add(o);
	}
	 
	@Override
	public void notifyObservers(Object arg) {
		ExecutorService es=Executors.newFixedThreadPool(v.size());
		Object []temp=v.toArray();
		for(int i=0;i<v.size();i++) {
			Observer o=((Observer)temp[i]);
			es.execute(()->{
				o.update(this, arg);
			});
		}
		es.shutdown();
	}
}
class FireAlarm11 extends MultiThreadedObservable1{
	public void setAlarm() {
		setChanged();
		notifyObservers();
	}
	
}

class Student1 implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		run();
	}
	public void run() {
		System.out.println("Student is Running ..................!");
	}
}

class Teacher1 implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		run();
	}
	public void run() {
		System.out.println("Teacher  is Thinking ");
		try {
			Thread.sleep(10000);
		}catch(Exception e) {
			
		}
		System.out.println("Teacher is Running ..................!");
	}
}

class Teacher2 implements Observer{
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		run();
	}
	public void run() {
		System.out.println("Teacher2 is Running ..................!");
	}
}