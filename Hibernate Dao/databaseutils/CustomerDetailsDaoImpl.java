package databaseutils;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateutility.HibernateUtility;

@SuppressWarnings("unchecked")
public class CustomerDetailsDaoImpl implements CustomerDetailsDao{

	@Override
	public boolean insertCustomerDetails(CustomerDetailsDto customerdetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.save(customerdetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCustomerDetails(CustomerDetailsDto customerdetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.update(customerdetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
			
		}
	}

	@Override
	public boolean deleteCustomerDetails(int customerId) {
		try {
			CustomerDetailsDto cust=this.findCustomerById(customerId);
			Session session=HibernateUtility.getSession();
			session.delete(cust);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	
	public List<CustomerDetailsDto> findCustomerByName(String name) {
		try {
			Session session=HibernateUtility.getSession();
			Query q=session.createQuery("from CustomerDetailsDto cd where cd.name=:n");
			q.setParameter("n", name);
			List<CustomerDetailsDto> list=q.list();
			//System.out.println(list);
			HibernateUtility.closeSession();
			return list;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CustomerDetailsDto findCustomerById(int customerId) {
		CustomerDetailsDto obj=null;
		try {
			Session session=HibernateUtility.getSession();
			obj=(CustomerDetailsDto)session.get(CustomerDetailsDto.class, customerId);
			HibernateUtility.closeSession();
			return obj;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CustomerDetailsDto> getAllCustomerDetails() {
		List<CustomerDetailsDto> list=null;
		try {
			Session session=HibernateUtility.getSession();
			list=(List<CustomerDetailsDto>)session.createQuery("from CustomerDetailsDto").list();
			HibernateUtility.closeSession();
			return list;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
	}
//	public static void main(String[] args) {
//		System.out.println(new CustomerDetailsDaoImpl().findCustomerByName("some name"));
//	}
}
