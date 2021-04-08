package hibernateonetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class Driver {
	public static void main(String[] args) {
		Employee e1=new Employee();
		e1.setName("Akshay");
		e1.setEid(1);
		e1.setSalary(20000);
		
		Address a1=new Address();
		a1.setAid(1);
		a1.setCity("Coimbatore");
		a1.setDoorno(20);
		a1.setPin(641045);
		a1.setStreet("Balaji Nagar");
		a1.setEmp(e1);
		
		Address a2=new Address();
		a1.setAid(2);
		a2.setCity("Chennai");
		a2.setDoorno(67);
		a2.setPin(600002);
		a2.setStreet("Somewhere in Guindy");
		a2.setEmp(e1);
		
		Set<Address> a_list=new HashSet<>();
		e1.setAddress(a_list);
		
		Session ss=HibernateUtility.getSession();
		
		ss.save(e1);
		ss.save(a1);
		ss.save(a2);
		
		HibernateUtility.closeSession(null);
	}
}
