package hibernateonetomany;

import java.io.Serializable;

public class Address implements Cloneable,Serializable,Comparable<Address>{
	private int doorno;
	private String Street;
	private String City;
	private int pin;
	private int aid;
	private Employee emp;
	
	
	
	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getDoorno() {
		return doorno;
	}

	public void setDoorno(int doorno) {
		this.doorno = doorno;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Address [doorno=" + doorno + ", Street=" + Street + ", City=" + City + ", pin=" + pin + ", aid=" + aid
				+ ", emp=" + emp + "]";
	}

	@Override
	public int compareTo(Address o) {
		
		return this.Street.compareTo(o.Street);
	}
	
}
