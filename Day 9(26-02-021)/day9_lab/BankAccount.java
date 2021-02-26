package day9_lab;

public class BankAccount {
	private String Name,AccNo,Type;
	private long balance;
	public BankAccount(String name, String accNo, String type, long balance) {
		super();
		Name = name;
		AccNo = accNo;
		Type = type;
		this.balance = balance;
	}
	public void getNameANdBalance() {
		System.out.println("Name : "+ this.Name);
		System.out.println("Balance : "+this.balance);
	}
	public void setBalance(long balance) {
		if(balance<this.balance)
		this.balance += balance;
		System.out.println(balance +" Has been Credited");
	}
	
	public static void main(String[] args) {
		BankAccount customer1=new BankAccount("AKshay","335445465768","SalaryAccount", 10000);
		customer1.getNameANdBalance();
		customer1.setBalance(9000);
		customer1.getNameANdBalance();
	}

}
