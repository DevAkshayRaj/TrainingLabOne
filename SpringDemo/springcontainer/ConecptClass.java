package springcontainer;



public class ConecptClass{
	public static void main(String[] args)throws Exception {
		
	}
}
abstract class Shoe{
	
}
class ShoeBuilder{
	
}
class LeatherShoe extends Shoe{	
	@Override
	public String toString() {
		
		return "This is leather shoe made by bata...:";
	}	
}
class SportsShoe extends Shoe{
	
	@Override
	public String toString() {
		
		return "This is sports shoe made by lakhani...";
	}
}
interface Manufacturer{
	
}
interface ShoeManufacturer extends Manufacturer{
	public Shoe makeShoe();
}
abstract class ShoeFactory implements ShoeManufacturer{
	public String skey;
	
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
}
class BataShoeFactory extends ShoeFactory{

	public BataShoeFactory() {
		System.out.println("bata shoe factory object created...");
	}
	@Override
	public Shoe makeShoe() {
		return new LeatherShoe();
	}
}
class LakhaniShoeFactory extends ShoeFactory{
	@Override
	public Shoe makeShoe() {
		return new SportsShoe();
	}
}
abstract class Customer{
	public Customer() {
		
	}
	private String name;
	public Customer(String name) {
		this.setName(name);
	}
	public final String getName() {
		return name;
	}
	public final void setName(String name) {
		this.name = name;
	}
}
class ShoeCustomer extends Customer implements Cloneable{
	private static ShoeCustomer sc=null;
	public ShoeCustomer getShoe(String nns) {
		if(sc==null) {
			sc= new ShoeCustomer(nns);
			//System.out.println(super.getName());
			return sc;
		}
		ShoeCustomer temp=sc.getClone();
		temp.setName(nns);
		return temp;
	}
	private ShoeCustomer getClone() {
		try {
			return (ShoeCustomer)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ShoeCustomer() {
		// TODO Auto-generated constructor stub
	}
	public ShoeCustomer(String name) {
		super(name);
	}
}
interface Seller{
	
}
interface ShoeSeller extends Seller{
	public Shoe sellShoe(Customer customer);
}
abstract class ShoeShop implements ShoeSeller{
	private ShoeFactory factory;
	public String skey;
	
	public String getSkey() {
		return skey;
	}
	public void setSkey(String skey) {
		this.skey = skey;
	}
	public final ShoeFactory getFactory() {
		return factory;
	}

	public final void setFactory(ShoeFactory factory) {
		System.out.println("set factory called....:"+factory);
		this.factory = factory;
	}
}

class GokulShoeShop extends ShoeShop{

	public GokulShoeShop() {
		System.out.println("gokul shoe shop created...............");
	}
	@Override
	public Shoe sellShoe(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println("Shoe bought by...:"+customer.getName());
		return getFactory().makeShoe();
	}
}

