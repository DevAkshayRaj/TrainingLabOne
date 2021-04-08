package inherdemo;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utility.HibernateUtility;
public class InherReadClient {
	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		
		Query query=session.createQuery("from ShoeFactory");
		
		List list=query.list();
		
		Iterator iter=list.iterator();
		
		while(iter.hasNext()) {
			Object factory=iter.next();
			//System.out.println(factory.getSid()+":"+factory.getName());
			if(factory instanceof BataShoeFactory) {
				BataShoeFactory bsf=(BataShoeFactory)factory;
				System.out.println(bsf.getSid()+":"+bsf.getPname()+":"+bsf.getBataName());
			}
			else if(factory instanceof LakhaniShoeFactory) {
//				Lakhani
			}
		}
	}
}