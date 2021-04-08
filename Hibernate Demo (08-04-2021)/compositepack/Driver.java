package compositepack;

import org.hibernate.Session;

import utility.HibernateUtility;

public class Driver {
	public static void main(String[] args) {
		Session ss = HibernateUtility.getSession();

		Invoice invoice = new Invoice();
		CompKey key = new CompKey();
		key.setInv_id(111);
		key.setItem_id(34355);

		invoice.setCompkey(key);
		invoice.setDetails("This the in voice for item 34355");

		ss.save(invoice);

		HibernateUtility.closeSession(null);
	}
}
