package day10;
/*
 * import java.lang.reflect.Proxy;
 * 
 * public class InterfaceDemo { public static void main(String[] args) { KgMc
 * kgmc=new KgMc(); Human h=new Human(); h.doCry();
 * 
 * Object obj=Proxy.newProxyInstance(Human.class.getClassLoader(),{Doctor.class}
 * ,new InterfaceDemo.MyInvocationHandler(h));
 * 
 * } }
 * 
 * class Human{ public void doCry() { System.out.println("crying...."); } }
 * interface Doctor{ public void doCure(); }
 * 
 * class PsgMc implements doctor{
 * 
 * @Override public void doCure() {
 * System.out.println("Curing taught by Psg Mc"); } }
 * 
 * class KgMc implements doctor{
 * 
 * @Override public void doCure() {
 * System.out.println("Curing Taught By Kg MC"); } } interface Pilot{ public
 * void doFly(); }
 * 
 * interface steward{ public void doServe(); } class JetAcademy{
 * 
 * }
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;

import javax.print.Doc;

public class InterfaceDemo {
	public static void main(String[] args) {
		/*
		 * Interface is a special class whose activity is promised by the class which
		 * implements it, and when an behavioral object is subjected to the
		 * implementation, the behavioral object becomes a component.
		 *
		 * Doctor is a special class whose activity is implemented in medical college,
		 * when shoiab is subjected to medical college, shoiab becomes a part
		 * of(Component) medical fraternity as doctor, and people REALIZE the objective
		 * of getting cured by going to shoiab, who in turn is now playing the role of
		 * doctor.
		 *
		 */

		Object shoiab = new Human1();// 1974
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please god make me a doctor.....");
		scanner.next();

		// today in 2021 i decided to become a doctor...

		StanleyAlopathyMC stanley = new StanleyAlopathyMC();
		JetAcademy jet = new JetAcademy();
		// shoiab=Proxy.newProxyInstance
		// (Human.class.getClassLoader(), new Class[] {Pilot.class}, new
		// MyInvocationHandler(jet));//subjection - THIS IS HAPPENING AT RUNTIME

		shoiab = Proxy.newProxyInstance(Human.class.getClassLoader(), new Class[] { Doctor.class, Pilot.class },
				new MyInvocationHandler(shoiab));// subjection - THIS IS HAPPENING AT RUNTIME

		Pilot pilotShoiab = (Pilot) shoiab;
		pilotShoiab.doFly();

		Doctor doctorShoiab = (Doctor) shoiab;// THIS IS HAPPENING AT RUNTIME..
		doctorShoiab.doCure();

	}

}

class Human {

}

class Human1 implements Doctor, Pilot {

	@Override
	public void doFly() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doCure() {
		// TODO Auto-generated method stub

	}// behavioral class

}

class MyInvocationHandler implements InvocationHandler {
	Object obj;

	public MyInvocationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("invoke method called.....");
		Object o = method.invoke(obj, args);
		return o;
	}
}

interface Doctor {
	public void doCure();
}

class StanleyAlopathyMC implements Doctor {// implementation class
	@Override
	public void doCure() {
		System.out.println("do cure as per alopathy.....");
	}
}

interface Pilot {
	public void doFly();
}

class JetAcademy implements Pilot {
	@Override
	public void doFly() {
		System.out.println("pilot pilot pilot...................");
	}
}
