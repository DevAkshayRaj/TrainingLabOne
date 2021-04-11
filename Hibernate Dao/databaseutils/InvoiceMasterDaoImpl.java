package databaseutils;

//import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateutility.HibernateUtility;
@SuppressWarnings("unchecked")
public class InvoiceMasterDaoImpl implements InvoiceMasterDao{

	@Override
	public boolean insertInvoiceDetails(InvoiceMasterDto InvoiceDetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.save(InvoiceDetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateInvoiceDetails(InvoiceMasterDto InvoiceDetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.update(InvoiceDetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteInvoiceDetails(int invoiceId) {
		try {
			InvoiceMasterDto inv=this.findInvoiceById(invoiceId);
			Session session=HibernateUtility.getSession();
			session.delete(inv);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public InvoiceMasterDto findInvoiceById(int invoiceId) {
		InvoiceMasterDto invoice=null;
		try {
			Session session=HibernateUtility.getSession();
			invoice =(InvoiceMasterDto)session.get(InvoiceMasterDto.class, invoiceId);
			HibernateUtility.closeSession();
			return invoice;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
			
		}
	}

	@Override
	public List<InvoiceMasterDto> getAllInvoiceDetails() {
		List<InvoiceMasterDto> list=null;
		try {
			Session session=HibernateUtility.getSession();
			Query query=session.createQuery("from InvoiceMasterDto");
			list=(List<InvoiceMasterDto>)query.list();
			HibernateUtility.closeSession();
			return list;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		InvoiceMasterDto temp=new InvoiceMasterDto();
//		temp.setCustomerno(11);
//		temp.setInvDate(LocalDate.now());
//		temp.setInvno(1);
//		
//		new InvoiceMasterDaoImpl().deleteInvoiceDetails(1);
//	}
}
