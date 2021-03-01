package day10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ACIdemo {
	public static void main(String[] args) throws Exception {

		Cricketer cricket = MrfAcademy.getMrfObj().getMrfCloneObj();
		TennisPlayer tennis = CeatAcademy.getCeatObj().getCeatCloneObj();

		Object sportsperson = new SportsPerson();

		sportsperson = Proxy.newProxyInstance(SportsPerson.class.getClassLoader(), new Class[] { Cricketer.class },
				new NextInvocationHandler(cricket));

		Cricketer c = (Cricketer) sportsperson;
		c.playCricket();

		sportsperson = Proxy.newProxyInstance(SportsPerson.class.getClassLoader(), new Class[] { TennisPlayer.class },
				new NextInvocationHandler(tennis));

		TennisPlayer t = (TennisPlayer) sportsperson;
		t.playTennis();

		MultiSportsPerson msp = MultiSportsPerson.getMspObj().getMultiClone();
		sportsperson = Proxy.newProxyInstance(SportsPerson.class.getClassLoader(),
				new Class[] { TennisPlayer.class, Cricketer.class }, new NextInvocationHandler(msp));

		Cricketer c1 = (Cricketer) sportsperson;
		c1.playCricket();
		TennisPlayer t1 = (TennisPlayer) sportsperson;
		t1.playTennis();

	}

}

class NextInvocationHandler implements InvocationHandler {
	Object obj;

	public NextInvocationHandler(Object obj) {
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Invoke Method Called");
		Object re = method.invoke(obj, args);
		return re;
	}
}

class MultiSportsPerson implements Cricketer, TennisPlayer, Cloneable {

	private static MultiSportsPerson msp;

	private MultiSportsPerson() {

	}

	@Override
	public void playCricket() {
		System.out.println("Cricket Played By MultiSportsPerson !");

	}

	@Override
	public void playTennis() {
		System.out.println("Tennis Played By MultiSportsPerson !");

	}

	public MultiSportsPerson getMultiClone() throws Exception {
		return (MultiSportsPerson) super.clone();
	}

	public static MultiSportsPerson getMspObj() {
		if (msp == null) {
			msp = new MultiSportsPerson();
		}
		return msp;
	}

}

class SportsPerson {

}

interface Cricketer {
	public void playCricket();
}

interface TennisPlayer {
	public void playTennis();
}

class MrfAcademy implements Cricketer, Cloneable {
	private static MrfAcademy obj;

	private MrfAcademy() {

	}

	public MrfAcademy getMrfCloneObj() throws Exception {

		return (MrfAcademy) super.clone();
	}

	@Override
	public void playCricket() {
		System.out.println("Cricket taught by MRF academy !");

	}

	public static MrfAcademy getMrfObj() {
		if (obj == null) {
			obj = new MrfAcademy();
		}
		return obj;
	}
}

class CeatAcademy implements TennisPlayer, Cloneable {

	private static CeatAcademy c;

	private CeatAcademy() {

	}

	@Override
	public void playTennis() {
		System.out.println("Tennis taught by CEAT academy !");

	}

	public CeatAcademy getCeatCloneObj() throws Exception {
		return (CeatAcademy) super.clone();
	}

	public static CeatAcademy getCeatObj() {
		if (c == null) {
			c = new CeatAcademy();
		}
		return c;
	}

}