package hibernateonetomany;

import java.io.Serializable;
import java.util.Set;

public class Employee implements Cloneable,Serializable,Comparable<Employee>{
	private String name;
	private int eid;
	private float salary;
	private Set<Address> address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Set<Address> getAddress() {
		return address;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public Employee() {
		
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + ", salary=" + salary ;
	}

	@Override
	public int compareTo(Employee o) {
		
		return this.name.compareTo(o.name);
	}
	
}
