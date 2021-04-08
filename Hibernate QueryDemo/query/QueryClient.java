package query;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernateonetomany.Address;
import hibernateonetomany.BackUpEmployee;
import hibernateonetomany.Employee;
import utility.HibernateUtility;
public class QueryClient {
	public static void main(String[] args) {
		QueryClient obj=new QueryClient();
		obj.query8();
//		Session ss=HibernateUtility.getSession();
//		BackUpEmployee aa=new BackUpEmployee();
//	
//		ss.save(aa);
//		
//	HibernateUtility.closeSession(null);
	}
	
	public void query1() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from Employee");
		List<Employee> list=query.list();
		for(Employee emp:list) {
			System.out.println(emp.getName()+":"+emp.getSalary());
			Set<Address> addresses=emp.getAddress();
			for(Address add:addresses) {
				System.out.println(add.getCity()+":"+add.getStreet());
			}
		}	
		HibernateUtility.closeSession(null);
	}
	//where clause and named query
	public void query2() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("from Employee emp where emp.salary>=20");
		//Query query=session.getNamedQuery("myquery");
		List<Employee> list=query.list();
		for(Employee emp:list) {
			System.out.println(emp.getName());
			Set<Address> addresses=emp.getAddress();
			for(Address add:addresses) {
				System.out.println(add.getCity()+":"+add.getStreet());
			}
		}	
		HibernateUtility.closeSession(null);
	}
	//scalars
	public void query3() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery("select emp.name from Employee emp where emp.salary>=20");
		List<Object> list=query.list();
		for(Object emp:list) {
			System.out.println((String)emp);
		}
		
		Query query2=session.createQuery("select emp.name,emp.salary from Employee emp where emp.salary>=20");
		List<Object[]> list2=query2.list();
		for(Object[] emp:list2) {
			System.out.println((String)emp[0]+":"+(Float)emp[1]);
		}
		HibernateUtility.closeSession(null);
	}
	//query paramter and also multiple objects joined...
	public void query4() {
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery
				("select e.name, a.city from Employee e, Address a where a.city=:c");
			query.setParameter("c", "chennai");
			Iterator<Object[]> obj=query.iterate();
			while(obj.hasNext())
			{
				Object o[]=obj.next();
				System.out.println(o[0]+":"+o[1]);
			}
			HibernateUtility.closeSession(null);
	}
	public void query5() {
		//an inner join will retun a employee name ONLY if their atleast one matching address
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery
				("select e.name, a.city from Employee e join e.address a with a.city=:c");
		query.setParameter("c", "coimbatore");
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			System.out.println(o[0]+":"+o[1]);
		}
		HibernateUtility.closeSession(null);
		
	}
	public void query6() {
		//an outer join will return all employee names once with a NULL address if no
		//matching employees are found.
		Session session=HibernateUtility.getSession();
		Query query=session.createQuery
				("select e.name, a.city from Employee e left join e.address a with a.city=:c");
		query.setParameter("c", "chennai");
		Iterator<Object[]> obj=query.iterate();
		while(obj.hasNext())
		{
			Object o[]=obj.next();
			System.out.println(o[0]+":"+o[1]);
		}	
		HibernateUtility.closeSession(null);
	}
	public void query7()
	{
		Session session=HibernateUtility.getSession();
		Query q=session.createQuery("update Employee set salary=salary+1000");
		int updateditems=q.executeUpdate();
		System.out.println("No of records updated...:"+updateditems);
		
		HibernateUtility.closeSession(null);
	}
	public void query8()
	{	
		Session session=HibernateUtility.getSession();
		Query q=session.createQuery
		("insert into hibernateonetomany.BackUpEmployee (id, name,salary) select e.id,e.name,e.salary from Employee e");
		int createobjects=q.executeUpdate();
		System.out.println(createobjects);
		
		HibernateUtility.closeSession(null);
	}
	
}