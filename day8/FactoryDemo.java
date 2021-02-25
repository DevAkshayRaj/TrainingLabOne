package day8;

public class FactoryDemo {
	public static void main(String[] args) throws Exception{
		
		ShoeFactory bataSF=Container.getShoeFactory("day8.BataShoeFactory");
		bataSF.printAddress();
		bataSF.produceShoe();
		ShoeShop gsf=Container.getShoeShop("day8.GokulShoeShop");
		gsf.printType();
		gsf.shoe=Container.getShoe("day8.SportsShoe");
		Customer bala=new ShoeCustomer("bala",gsf.shoe);
		Shoe s1=gsf.sellShoe(bala);
		System.out.println(s1);
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		ShoeFactory lakhaniSF=Container.getShoeFactory("day8.LakhaniShoeFactory");
		lakhaniSF.printAddress();
		lakhaniSF.produceShoe();
		ShoeShop gsf1=Container.getShoeShop("day8.GokulShoeShop");
		gsf.printType();
		gsf1.shoe=Container.getShoe("day8.LeatherShoe");
		Customer ramu=new ShoeCustomer("ramu",gsf1.shoe);
		Shoe ss=gsf.sellShoe(ramu);
		System.out.println(ss);
	}

}


class Container{
	public static Manufacturer getManufacturer(String ManufacName) throws Exception{
		Manufacturer manu;
		manu=(Manufacturer)Class.forName(ManufacName).newInstance();
		return manu;
	}
	
	public static ShoeManufacturer getShoeManu(String facname) throws Exception{
		ShoeManufacturer temp;
		temp=(ShoeManufacturer)Class.forName(facname).newInstance();
		return temp;
	}
	
	public static Shoe getShoe(String type) throws Exception{
		Shoe shoe;
		shoe=(Shoe)Class.forName(type).newInstance();
		return shoe;
	}
	
	public static ShoeFactory getShoeFactory(String type) throws Exception{
		ShoeFactory shoef;
		shoef=(ShoeFactory)Class.forName(type).newInstance();
		return shoef;
	}
	
	public static ShoeShop getShoeShop(String name) throws Exception{
		ShoeShop shoeshop;
		shoeshop=(ShoeShop)Class.forName(name).newInstance();
		return shoeshop;
	}
}


interface Manufacturer{
	public void printAddress();
}


interface ShoeManufacturer extends Manufacturer{
	public void produceShoe();
}



abstract class ShoeFactory implements ShoeManufacturer{
	public Shoe shoe;
	
	
}

class BataShoeFactory extends ShoeFactory{

	@Override
	public void produceShoe() {
		System.out.println("Shoe Produced By Bata ShoeFactory");
		
	}

	@Override
	public void printAddress() {
		System.out.println("Address of Bata Shoe Factory");
		
	}
	
}


class LakhaniShoeFactory extends ShoeFactory{

	@Override
	public void produceShoe() {
		System.out.println("Shoe Produced By Lakhani ShoeFactory");
		
	}

	@Override
	public void printAddress() {
		System.out.println("Address of Lakhani Shoe Factory");
		
	}
	
	
}


interface Seller{
	public void printType();
}

interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer customer);
}

abstract class ShoeShop implements ShoeSeller{
	public ShoeFactory shoefac;
	public Shoe shoe;
}


class GokulShoeShop extends ShoeShop{

	@Override
	public Shoe sellShoe(Customer customer) {
		
		System.out.println("Shoe Sold forom GokulShoeShop");
		return customer.s;
	}

	@Override
	public void printType() {
		System.out.println("GokulShoeShop is a Retail Seller");
		
	}
	
}


abstract class Shoe{
	abstract void shoeType();
	
}

class LeatherShoe extends Shoe {

	@Override
	void shoeType() {
		System.out.println("I am LeatherShoe ");
	}

	@Override
	public String toString() {
		return "LeatherShoe";
	}
	
	
}


class SportsShoe extends Shoe{

	@Override
	void shoeType() {
		System.out.println("I am SportsShoe");
		
	}
	@Override
	public String toString() {
		return "SportsShoe";
	}
}


abstract class Customer{
	public String Name;
	public ShoeShop shoeshop;
	public Shoe s;
	public abstract void printName(String name);
	
}


class ShoeCustomer extends Customer{

	public ShoeCustomer(String name,Shoe shoe) {
		System.out.println("The Name of the Customer is : "+name);
		this.s=shoe;
		
	}

	@Override
	public void printName(String name) {
		System.out.println(Name);
		
	}
	
}



