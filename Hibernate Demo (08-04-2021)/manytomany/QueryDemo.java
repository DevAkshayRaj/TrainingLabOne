package manytomany;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import utility.HibernateUtility;
public class QueryDemo {
	public static void main(String[] args) {
		Session session=HibernateUtility.getSession();
		
		System.out.println("---------Query 1-----------");
		
		Query query=session.createQuery("from Student");
		List<Student> list=query.list();
		Iterator<Student> iter=list.iterator();
		while(iter.hasNext()) {
			Student student=iter.next();
			System.out.println(student.getName());
			Set<Training> tset=student.getTrainings();
			for(Training t:tset) {
				System.out.println(t.getTname());
			}
		}
		System.out.println("----------Query 2-----------");
		
		Query query2=session.createQuery("select s.name from Student s");
		List<String> list2=query2.list();
		Iterator<String> iter2=list2.iterator();
		while(iter2.hasNext()) {
			System.out.println(iter2.next());
		}
		
		System.out.println("----------Query 3-----------");
		
		Query query3=session.createQuery("select s.name,s.marks from Student s");
		List<Object[]> list3=query3.list();
		Iterator<Object[]> iter3=list3.iterator();
		while(iter3.hasNext()) {
			Object o[]=iter3.next();
			for(Object obj:o) {
				System.out.println(obj.toString());
			}
		}
	}
}