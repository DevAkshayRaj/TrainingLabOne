package day8;

public class StudentDriver {
	public static void main(String[] args) {
		Results r=new Results(98.5,99,89.5);
		r.setStudent("Akshay",280960);
		//System.out.println(r.m1);
		r.calcTotal();
		r.printResults();
	}

}

class Student{
	String name;
	long roll;
	Student(){
		
	}
	public void setStudent(String name, long roll) {
		this.name = name;
		this.roll = roll;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + "]";
	}
	
}

class Exam extends Student{
	double m1,m2,m3;
	Exam(){
		
	}
	public Exam(double m1, double m2, double m3) {
		super();
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}
	@Override
	public String toString() {
		System.out.println(super.toString());
		return "Exam [m1=" + m1 + ", m2=" + m2 + ", m3=" + m3 + "]";
	}
	
	
}

class Results extends Exam{
	double totalmarks;
	Results(double m1,double m2,double m3){
		super(m1,m2,m3);
		
	}
	public void calcTotal() {
		//System.out.println(m1);
		this.totalmarks=this.m1+this.m2+this.m3;
	}
	public void printResults() {
		System.out.println(super.toString());
		System.out.println("Total: " + this.totalmarks );
		
	}
}