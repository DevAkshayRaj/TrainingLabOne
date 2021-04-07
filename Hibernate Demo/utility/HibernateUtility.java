package utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
//	private static ThreadLocal<Session> tsession=new ThreadLocal<Session>();
//	private static Configuration cc;
//	static {
//		cc=new Configuration();
//	}
//	public static Session getSession() {
//		Session sessionobj=null;
//		try {
//			Session s=tsession.get();
//			if(s==null) {
//				SessionFactory factory=cc.configure().buildSessionFactory();
//				sessionobj=factory.openSession();
//				tsession.set(sessionobj);
//			}
//			return sessionobj;
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//
//		
//	}
//	public static void closeSession(Exception e) {
//		try {
//			
//		}catch(Exception ee) {
//			ee.printStackTrace();
//		}
//	}
	private HibernateUtility() {
		// TODO Auto-generated constructor stub
	}
	private final static ThreadLocal<Session> tlocal=new ThreadLocal<Session>();
	static {
		Configuration cfg=new Configuration().configure();
		sessionFactory=cfg.buildSessionFactory();
	}
	private static SessionFactory sessionFactory; 
	private static Session session;
	private static Transaction tx;
	synchronized public static Session getSession() {
		try {
			session=tlocal.get();
			if(session==null) {
				session=sessionFactory.openSession();
				tx=session.beginTransaction();
				tlocal.set(session);
			}
			return session;
		}catch(Exception e) {e.printStackTrace();return null;}
	}
	synchronized public static void closeSession(Exception e) {
		session=tlocal.get();
		if(e==null) {
			if(session!=null) {
				tx.commit();
				session.close();
				tlocal.remove();
				
			}
		}
		else {
			if(session!=null) {
				tx.rollback();
				session.close();
				tlocal.remove();
			}
		}
	
}
}
