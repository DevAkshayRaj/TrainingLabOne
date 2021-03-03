package day11_revision;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

public class AllCombinedDemo {
	public static void main(String[] args) throws Exception {
		Dog tommy = Dog.getDogObj().getDogClone();
		Child baby = Child.getChildObj().getClone();
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("Please Enter The Name of The Item Class : ");
			String ip = s.next();
			if (ip.equals("end"))
				break;
			Item itm = Container.getItem(ip);
			baby.plaWithDog(tommy, itm);
		}
		s.close();
	}
}

class Container {
	public static Item getItem(String a) throws Exception {
		Item itm = (Item) Class.forName(a).getConstructor().newInstance();
		return itm;
	}
}

abstract class DogException extends Exception {
	abstract void doHandle();
}

class DogBarkException extends DogException implements Cloneable {
	String msg;
	private static DogBarkException bark;

	private DogBarkException() {

	}

	public static DogBarkException getDogBarkExceptionObject() {
		if (bark == null) {
			bark = new DogBarkException();
		}
		return bark;
	}

	public DogBarkException getClone(String msg) throws Exception {
		DogBarkException db = (DogBarkException) super.clone();
		db.setMsg(msg);
		return db;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg;
	}

	@Override
	void doHandle() {
		Object o = ProxyHandler.getObj();
		BarkHandler h = (BarkHandler) o;
		h.doHandle(this);
		h = null;
	}

}

class DogBiteException extends DogException implements Cloneable {
	String msg;

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private static DogBiteException db;

	private DogBiteException() {

	}

	@Override
	public String toString() {
		return msg;
	}

	@Override
	void doHandle() {
		Object o = ProxyHandler.getObj();
		BiteHandler h = (BiteHandler) o;
		h.doHandle(this);
		h = null;

	}

	public static DogBiteException getObj() {
		if (db == null)
			db = new DogBiteException();
		return db;
	}

	public DogBiteException getClone(String msg) throws Exception {
		DogBiteException temp = (DogBiteException) super.clone();
		temp.setMsg(msg);
		return temp;
	}
}

class DogSadException extends DogException implements Cloneable {
	private static DogSadException ds;
	String msg;

	public void setMsg(String msg) {
		this.msg = msg;
	}

	private DogSadException() {

	}

	@Override
	public String toString() {
		return msg;
	}

	@Override
	void doHandle() {
		Object o = ProxyHandler.getObj();
		SadHandler h = (SadHandler) o;
		h.doHandle(this);
		h = null;
	}

	public static DogSadException getObj() {
		if (ds == null)
			ds = new DogSadException();
		return ds;
	}

	public DogSadException getClone(String msg) throws Exception {
		DogSadException temp = (DogSadException) super.clone();
		temp.setMsg(msg);
		return temp;

	}
}

abstract class Item {
	abstract public void play() throws Exception;
}

class StickItem extends Item implements Cloneable {
	public StickItem() {

	}

	@Override
	public void play() throws Exception {
		throw DogBarkException.getDogBarkExceptionObject().getClone("You Beat I Bark !!!");
	}

}

class StoneItem extends Item implements Cloneable {

	public StoneItem() {

	}

	@Override
	public void play() throws Exception {
		throw DogBiteException.getObj().getClone("You Beat I Bite You !!!");
	}
}

class FoodItem extends Item implements Cloneable {

	public FoodItem() {

	}

	@Override
	public void play() throws Exception {
		throw DogSadException.getObj().getClone("I Dont Like This Food Give me Meat !");
	}
}

class Dog implements Cloneable {
	static private Dog dog;

	private Dog() {

	}

	public static Dog getDogObj() {
		if (dog == null) {
			dog = new Dog();
		}
		return dog;
	}

	public Dog getDogClone() throws Exception {
		return (Dog) super.clone();
	}

	public void react(Item itm) throws Exception {
		itm.play();
	}
}

class Child implements Cloneable {
	private static Child child;

	public void plaWithDog(Dog dog, Item itm) {
		try {
			dog.react(itm);
		} catch (DogException de) {
			System.out.println("DogException : " + de);
			de.doHandle();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
			e.printStackTrace();
		}
	}

	private Child() {

	}

	public static Child getChildObj() {
		if (child == null) {
			child = new Child();
		}
		return child;
	}

	public Child getClone() throws Exception {
		return (Child) super.clone();
	}
}

class Handler {

}

interface BarkHandler {
	public void doHandle(DogBarkException e);
}

class HandleBarkException implements BarkHandler {
	@Override
	public void doHandle(DogBarkException e) {
		System.out.println("Barking Dogs Wont Bite You !");
	}
}

interface SadHandler {
	public void doHandle(DogSadException e);
}

class HandleSadException implements SadHandler {
	@Override
	public void doHandle(DogSadException e) {
		System.out.println("Give Another Food to the dog !");
	}
}

interface BiteHandler {
	public void doHandle(DogBiteException e);
}

class HandleBiteException implements BiteHandler {
	@Override
	public void doHandle(DogBiteException e) {
		System.out.println("Ambulance Help On the Way !!");
	}
}

class ProxyHandler {
	static {
		HandleBiteException a = new HandleBiteException();
		HandleBarkException b = new HandleBarkException();
		HandleSadException c = new HandleSadException();
		obj = Proxy.newProxyInstance(Handler.class.getClassLoader(),
				new Class[] { BiteHandler.class, BarkHandler.class, SadHandler.class },
				new MyInvocationHandler(new Object[] { c, a, b }));

	}
	public static Object obj;

	public static Object getObj() {
		return obj;
	}
}

class MyInvocationHandler implements InvocationHandler {
	Object[] obj;

	public MyInvocationHandler(Object[] obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object returnObject = null;
		for (Object o : obj) {
			Method m[] = o.getClass().getDeclaredMethods();
			// System.out.println("Invoke Method : "+Arrays.toString(m));
			for (Method met : m) {
				try {
					if (met.getName().equals(method.getName())) {
						met.setAccessible(true);
						returnObject = method.invoke(o, args);
						return returnObject;
					}
				} catch (Exception e) {

				}
			}
		}

		return returnObject;

	}
}
