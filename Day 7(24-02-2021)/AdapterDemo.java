package Day7;

public class AdapterDemo {
	public static void main(String args[]) {
		IndianSocket in=new India();
		AmericanPin am=new America();
		//in.indianPinHole(am);
		Adapt ad=new Adapt(am);
		ad.indianPlug();
	}
}

class Adapt extends IndianPin {
	AmericanPin am;
	public Adapt(AmericanPin am) {
		// TODO Auto-generated method stub
		this.am=am;
	}
	@Override
	public void indianPlug() {
		// TODO Auto-generated method stub
		am.americanPlug();
	}
}

abstract class AmericanPin {
	public abstract void americanPlug();
}

abstract class IndianPin {
	public abstract void indianPlug();
}

abstract class AmericanSocket {
	public abstract void americanPinHole(AmericanPin ap);
}

abstract class IndianSocket {
	public abstract void indianPinHole(IndianPin ip);
}

class India extends IndianSocket {
	@Override
	public void indianPinHole(IndianPin ip) {
		// TODO Auto-generated method stub
		ip.indianPlug();
	}
}

class America extends AmericanPin {
	@Override
	public void americanPlug() {
		// TODO Auto-generated method stub
		System.out.println("Socket Working");
	}
}