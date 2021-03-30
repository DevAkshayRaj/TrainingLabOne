package databaseutils;

import java.io.Serializable;

public class CustomerDetialsDto implements Serializable{
	private long custno;
	private String email;
	private String name;
	private String phone;
	private String address;
	public synchronized final long getCustno() {
		return custno;
	}
	public synchronized final void setCustno(long custno) {
		this.custno = custno;
	}
	public synchronized final String getEmail() {
		return email;
	}
	public synchronized final void setEmail(String email) {
		this.email = email;
	}
	public synchronized final String getName() {
		return name;
	}
	public synchronized final void setName(String name) {
		this.name = name;
	}
	public synchronized final String getPhone() {
		return phone;
	}
	public synchronized final void setPhone(String phone) {
		this.phone = phone;
	}
	public synchronized final String getAddress() {
		return address;
	}
	public synchronized final void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "CustomerDetialsDto [custno=" + custno + ", email=" + email + ", name=" + name + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
	

}
