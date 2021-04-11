package databaseutils;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateutility.HibernateUtility;
@SuppressWarnings("unchecked")
public class UsersMasterDaoImpl implements UsersMasterDao{

	@Override
	public boolean insertUsersDetails(UsersMasterDto UsersDetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.save(UsersDetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateUsersDetails(UsersMasterDto UsersDetails) {
		try {
			Session session=HibernateUtility.getSession();
			session.update(UsersDetails);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteUsersDetails(int userId) {
		try {
			UsersMasterDto user=this.findCustomerById(userId);
			Session session=HibernateUtility.getSession();
			session.delete(user);
			HibernateUtility.closeSession();
			return true;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return false;	
		}
	}

	@Override
	public List<UsersMasterDto> findCustomerByName(String userName) {
		List<UsersMasterDto> list=null;
		try {
			Session session=HibernateUtility.getSession();
			Query query=session.createQuery("from UsersMasterDto ud where ud.name=:un");
			query.setParameter("un",userName);
			list=query.list();
			HibernateUtility.closeSession();
			return list;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public UsersMasterDto findCustomerById(int userId) {
		UsersMasterDto obj=null;
		try {
			Session session=HibernateUtility.getSession();
			obj=(UsersMasterDto)session.get(UsersMasterDto.class,userId);
			HibernateUtility.closeSession();
			return obj;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
			
		}
		
	}

	@Override
	public List<UsersMasterDto> getAllUsersDetails() {
		List<UsersMasterDto> list=null;
		try {
			Session session=HibernateUtility.getSession();
			list=session.createQuery("from UsersMasterDto").list();
			HibernateUtility.closeSession();
			return list;
		}catch(Exception e) {
			HibernateUtility.closeSession(e);
			e.printStackTrace();
			return null;
		}
	}
	
//	public static void main(String[] args) {
//		UsersMasterDto temp=new UsersMasterDto();
//		temp.setFlag(0);
//		temp.setName("AKshayRaj");
//		temp.setPwd("Akshay@123");
//		temp.setUid(1);
//		
//		System.out.println(new UsersMasterDaoImpl().deleteUsersDetails(1));
//	}
	
}
