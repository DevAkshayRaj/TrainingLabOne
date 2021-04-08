package compositepack;

import org.hibernate.Session;

import utility.HibernateUtility;

public class ReadDriver {
	public static void main(String[] args) {
		Session ss=HibernateUtility.getSession();
		
		CompKey ckey=new CompKey();
		ckey.setInv_id(111);
		ckey.setItem_id(34355);
		Invoice ii=(Invoice)ss.get(Invoice.class, ckey);
		System.out.println(ii.getDetails());
		
		HibernateUtility.closeSession(null);
	}
}
