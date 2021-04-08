package query;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import hibernateonetomany.Address;
import hibernateonetomany.Employee;
import utility.HibernateUtility;

public class QueryClient2 {
	public static void main(String[] args) {
		QueryClient2 obj = new QueryClient2();
		obj.query3();
	}

	public static void display(Criteria criteria) {
		List<Employee> employees = criteria.list();
		Iterator<Employee> iter = employees.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().getName());
		}
	}

	public void query1() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Employee.class);
		display(criteria);
	}

	public void query11() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.addOrder(Order.desc("name"));
		display(criteria);
	}

	public void query2() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Employee.class);
		// criteria.add(Restrictions.eq("name", "ramu"));
		// or
		criteria.add(Property.forName("name").eq("Akshay"));
		Employee emp = (Employee) criteria.uniqueResult();
		System.out.println(emp.getName());
	}

	public void query3() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Address.class).createAlias("emp", "emp");
		criteria.add(Restrictions.eq("emp.name", "Akshay"));
		// or
		// criteria.add(Property.forName("emp.name").eq("Akshay"));
		List<Address> addresses = criteria.list();
		Iterator<Address> iter = addresses.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().getCity());
		}
	}

	public void query4() {
		Session session = HibernateUtility.getSession();
		Object[] temp=new Object[]{new Float(22000),new Float(30000)};
		Criteria criteria = session.createCriteria(Employee.class);
		//criteria.add(Restrictions.between("salary",new Float(20),new Float(40000)));
		criteria.add(Property.forName("salary").in(temp));
		display(criteria);
	}

	public void query5() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.like("name", "A%").ignoreCase());
		display(criteria);
	}

	public void query6() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.like("name", "A%").ignoreCase()).add(Restrictions.gt("salary", new Float(20000)));
		display(criteria);
	}

	public void query7() {
		Session session = HibernateUtility.getSession();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(
				Restrictions.or(Restrictions.like("name", "A%").ignoreCase(), Restrictions.gt("salary", new Float(20000))));
		display(criteria);
	}

	public void query8() {
		Session session = HibernateUtility.getSession();
		DetachedCriteria dc = DetachedCriteria.forClass(Employee.class);
		dc.add(Restrictions.or(Restrictions.like("name", "R%"), Restrictions.gt("salary", new Float(20000))));
		Criteria criteria = dc.getExecutableCriteria(session);
		display(criteria);
	}
}