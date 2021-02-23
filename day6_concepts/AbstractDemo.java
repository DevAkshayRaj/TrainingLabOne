package day6_concepts;

public class AbstractDemo {
	public static void main(String[] args) {
		EyLaptop ip=new InternLaptop();
		ip.getLaptop();
	}
}

abstract class EyLaptop{
	public final void privacyPolicies() {
		System.out.println("Policies Defined By EY");
	}
	public abstract void installSoftware();
	protected abstract void changePassword();
	public final void selectOs() {
		System.out.println("OS selected by EY");
	}
	final void initializeLaptop() {
		privacyPolicies();
		selectOs();
	}
	abstract void getLaptop();
}

class InternLaptop extends EyLaptop{
	public void getLaptop() {
		initializeLaptop();
		installSoftware();
		changePassword();
		System.out.println("The Laptop is Ready to Use !");
	}

	@Override
	public void installSoftware() {
		System.out.println("Softwares Installed By Intern");
		
	}

	@Override
	public void changePassword() {
		System.out.println("Password changed by Intern");
		
	}
}