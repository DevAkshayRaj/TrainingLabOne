package databaseutils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateutility.HibernateUtility;
@SuppressWarnings("unchecked")
public class ITemTransactionDetailsDaoImpl implements ItemTransactionDetailsDao{

	@Override
	public boolean insertItemTransactionDetails(ItemTransactionDetailsDto ItemTransactionDetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.save(ItemTransactionDetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItemTransactionDetails(ItemTransactionDetailsDto ItemTransactionDetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.update(ItemTransactionDetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteItemTransactionDetails(int invid,int itemId) {
		try {
			ItemTransactionDetailsDto itd=this.findTransactionById(invid,itemId);
			Session session=HibernateUtility.getSession();
			session.delete(itd);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ItemTransactionDetailsDto findTransactionById(int invid,int itemId) {
		try {
			Session session=HibernateUtility.getSession();
			InvoiceKey ikey=new InvoiceKey();
			ikey.setInvno(invid);
			ikey.setItemno(itemId);
			ItemTransactionDetailsDto trans=(ItemTransactionDetailsDto)session.get(ItemTransactionDetailsDto.class, ikey);
			HibernateUtility.closeSession();
			return trans;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ItemTransactionDetailsDto> getAllItemTransactionDetails() {
		List<ItemTransactionDetailsDto> list=null;
		try {
			Session session=HibernateUtility.getSession();
			Query query=session.createQuery("from ItemTransactionDetailsDto");
			list=query.list();
			HibernateUtility.closeSession();
			return list;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		ItemTransactionDetailsDto temp=new ItemTransactionDetailsDto();
//		temp.setQty(504323);
//		InvoiceKey ik=new InvoiceKey();
//		ik.setInvno(1);
//		ik.setItemno(19);
//		temp.setInvkey(ik);
//		
//		new ITemTransactionDetailsDaoImpl().deleteItemTransactionDetails(19, 1);
//	}
}
