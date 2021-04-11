package databaseutils;

import java.io.Serializable;

import org.hibernate.Session;


import hibernateutility.HibernateUtility;

public class Driver {
	public static void main(String[] args) {
		Session s=HibernateUtility.getSession();
		ItemTransactionDetailsDto temp=new ItemTransactionDetailsDto();
		temp.setQty(500);
		InvoiceKey ik=new InvoiceKey();
		ik.setInvno(1);
		ik.setItemno(19289);
		temp.setInvkey(ik);
		s.save(temp);
		//Serializable sa=s.save(temp);
		//System.out.println(sa.toString());
		HibernateUtility.closeSession();
	}
}
