package day9_lab;

public class BankArray {
	public static void main(String[] args) {
		BankAccount1 []b=new BankAccount1[7];
		String name="Akshay";
		for(int i=0;i<7;i++) {
			b[i]=new BankAccount1( (name+ Integer.toString(i)),Integer.toHexString(i));
		}
		for(BankAccount1 ba:b) {
			ba.getNameANdBalance();
		}
	}
}
