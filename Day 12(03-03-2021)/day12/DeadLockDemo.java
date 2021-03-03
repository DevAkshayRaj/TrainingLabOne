package day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockDemo {
	public static void main(String[] args) {
		Cat cat=new Cat();
		Snake snake=new Snake();
		ExecutorService es=Executors.newFixedThreadPool(2);
		es.execute(()->{
			cat.eat(snake);
		});
		es.execute(()->{
			snake.escape(cat);
		});
		es.shutdown();
	}
}
class Cat {
	synchronized public void eat(Snake snake) {
		try {
			Thread.sleep(3000);
		}
		catch(Exception e) {}
		snake.leaveCat();
		System.out.println("Snake Died");
	}
	synchronized public void spitSnake() {
		
	}
}
class Snake {
	synchronized public void escape(Cat cat) {
		cat.spitSnake();
	}
	synchronized public void leaveCat() {
		
	}
}