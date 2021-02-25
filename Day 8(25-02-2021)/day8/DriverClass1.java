package day8;
import java.util.Scanner;

public class DriverClass1 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Please Enter the area of the : ");
		House h1=new House(s.nextDouble());
		System.out.println("Please Enter the amount per sq.ft : ");
		h1.calculateCost(s.nextDouble());
		s.close();
	}
}

class House{
	Door d1=new Door();
	Door d5=new Door();
	Door d4=new Door();
	Door d3=new Door();
	Door d2=new Door();
	Window w1=new Window();
	Window w2=new Window();
	Window w3=new Window();
	double area;
	House(double area){
		this.area=area;
	}
	
	public void calculateCost(double amt){
		double total=area+d5.getDoorCost()+w3.getWindowcost();
		System.out.println("The Cost Of Constructing the House is : "+total*amt);
	}
}

class Door{
	static int count=0;
	double size=10.0;
	
	Door(){
		count++;
	}
	
	double getDoorCost() {
		
		return count*size;
	}
	
}

class Window{
	static int count;
	double size=5.2;
	Window(){
		count++;
	}
	
	double getWindowcost(){
		
		return count*size;
	}
	
	
}