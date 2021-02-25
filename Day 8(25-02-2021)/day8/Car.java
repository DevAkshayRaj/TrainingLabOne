package day8;

import vehicle.FourWheeler;

public class Car {

	public static void main(String[] args) {
		FourWheeler fw=new Car1();
		fw.drive();
	}
	
}

class Car1 extends FourWheeler{

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Car Runs using Four Wheels");
		
	}
	
}
