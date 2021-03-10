package day17;

public class EnumDEmo {
	public static void main(String[] args) {
		Cars car;
		car=Cars.maruti;
		met(car);
	}
	
	public static void met(Cars car) {
		if(car==Cars.maruti) {
			System.out.println("its a maruti.........");
		}
		else if(car==Cars.fiat) {
			System.out.println("its a fiat...");
		}
		
		switch(car){
		case maruti:{
			System.out.println("switch case - its a maruti....");
			break;
		}
		case fiat:{
			System.out.println("switch case- its a fiat....");
			break;
		}
		default:{
			System.out.println("unknown..........");
		}
		}
		
		Cars c[]=Cars.values();
		for(Cars cc:c) {
			System.out.println(cc.getPrice());
		}
		Cars.maruti.setPrice(500);
		System.out.println("maruti price..:"+Cars.maruti.getPrice());
	}
}
enum Cars{
	maruti(1000),suzuki(2000),porsche(3000),fiat(4000),tata(9000);
	private int price;
	Cars(int price){
		this.price=price;
	}
	
	public int getPrice() {
		return this.price;
	}
	public void setPrice(int price) {
		this.price=price;
	}
}