package hibernateutility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static ThreadLocal<Session> tSession=new ThreadLocal<>();
	private static SessionFactory factory;
	private static  Transaction transac;
	static {	
		factory = 
				new Configuration()
				.configure("hibernate.anno.cfg.xml")
				.buildSessionFactory();
	}
	
	synchronized public static Session getSession() {
		Session session=tSession.get();
		try {
			if(session==null) {
				session = factory.openSession();
				transac = session.beginTransaction();
				tSession.set(session);
			}
			return session;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	synchronized public static void closeSession(){
		Session session=tSession.get();
		try {
			if(session!=null&&transac!=null) {
				transac.commit();
				session.close();
				tSession.remove();
				transac=null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	synchronized public static void closeSession(Exception e){
		Session session=tSession.get();
		try {
			if(session!=null&&transac!=null) {
				transac.rollback();
				session.close();
				tSession.remove();
				transac=null;
			}
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}
}
