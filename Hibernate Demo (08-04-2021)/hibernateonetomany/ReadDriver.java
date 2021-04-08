package hibernateonetomany;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ReadDriver {
	public static void main(String[] args) {
		Session ss=HibernateUtility.getSession();
		
		Employee ee=(Employee)ss.get(Employee.class, Integer.valueOf(1));
		
		System.out.println(ee);
		
		HibernateUtility.closeSession(null);
	}
}
