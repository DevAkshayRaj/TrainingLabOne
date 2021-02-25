package day8;

public class InheritanceDemo {

	public static void main(String[] args) {
		Date date=new Date();
		date.setDate("11/12/1999");
		Employee e1=new SalesTerritoryManager("akshay", date);
		e1.calcPay();
		
		System.out.println();
		System.out.println();
		
		Date d=new Date();
		d.setDate("01/01/2000");
		Employee e=new SalesManager("Raj",d);
		e.calcPay();

		System.out.println();
		System.out.println();

		Date d1=new Date();
		d.setDate("01/08/2005");
		Employee e3=new SalesPerson("RajuBhai",d1);
		e3.calcPay();
		 
		System.out.println();
		System.out.println();

		Date d2=new Date();
		d.setDate("08/12/2003");
		Employee e4=new Worker("Rohit",d2);
		e4.calcPay();
		
		
	}
	
}

class Date{
	private String Date;

	public final String getDate() {
		return Date;
	}

	public final void setDate(String date) {
		Date = date;
		
	}
	
}

abstract class Employee{
	long basic=20000;
	abstract void calcPay();
	
}

class SalesPerson extends Employee{
	String name;
	Date doj;
	long salary;
	
	
	public SalesPerson() {
		super();
	}


	public SalesPerson(String name, Date doj) {
		//super();
		this.name = name;
		this.doj = doj;
	}


	@Override
	void calcPay() {
		salary=basic*2;
		System.out.println("Name:"+name+"\n"+"DOJ:"+doj.getDate());
		System.out.println("Sales Person Salary : "+salary);
	}
	
}

class Worker extends Employee{
	String name;
	Date doj;
	long salary;
	
	public Worker(String name, Date doj) {
		//super();
		this.name = name;
		this.doj = doj;
	}

	@Override
	void calcPay() {
		salary=basic*1;
		System.out.println("Name:"+name+"\n"+"DOJ:"+doj.getDate());
		System.out.println("Worker Salary : "+salary);	
	}
	
}

class SalesManager extends SalesPerson{
	String name;
	Date doj;
	long salary;
	
	public SalesManager() {
		super();
	}



	public SalesManager(String name, Date doj) {
		//super(name, doj);
		this.name = name;
		this.doj = doj;
	}



	void calcPay() {
		salary=basic*5;
		System.out.println("Name:"+name+"\n"+"DOJ:"+doj.getDate());
		System.out.println("Sales Manager Salary : "+salary);	
	}
}

class SalesTerritoryManager extends SalesManager{
	String name;
	Date doj;
	long salary;
	
	public SalesTerritoryManager(String name, Date doj) {
		this.name = name;
		this.doj = doj;
	}

	
	void calcPay() {
		salary=basic*10;
		System.out.println("Name:"+name+"\n"+"DOJ:"+doj.getDate());
		System.out.println("Sales Teritory Manager Salary : "+salary);	
	}
	
}