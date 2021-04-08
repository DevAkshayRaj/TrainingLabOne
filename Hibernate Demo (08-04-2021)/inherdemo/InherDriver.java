package inherdemo;

import org.hibernate.Session;

import utility.HibernateUtility;

public class InherDriver {
	public static void main(String[] args) {
		Session ss = HibernateUtility.getSession();
		ShoeFactory sf = new ShoeFactory();
		sf.setPname("Helloo from Parent");

		BataShoeFactory bsf = new BataShoeFactory();
		bsf.setPname("Hello to Parent From Bata");
		bsf.setBataName("Welcome to Bata");

		LakhaniShoeFactory lsf = new LakhaniShoeFactory();
		lsf.setPname("Hello to Parent From Lakhani");
		lsf.setLakName("Welcome to Lakhani");
		
		ss.save(sf);
		ss.save(bsf);
		ss.save(lsf);
		ss.beginTransaction().commit();
	}
}
