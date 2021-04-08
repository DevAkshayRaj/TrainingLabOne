package manytomany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import utility.HibernateUtility;

public class Driver {
	public static void main(String[] args) {
		Session ss=HibernateUtility.getSession();
		Student s1=new Student();
		s1.setName("Akshay");
		s1.setMarks(100);
		s1.setSid(1);
		
		Training t1=new Training();
		t1.setStartdate(LocalDate.now());
		t1.setTname("Java");
		//t1.setStudents(s1);
		
		Training t2=new Training();
		t2.setStartdate(LocalDate.now());
		t2.setTname("Hibernate");
		//t2.setStudents(s1);
		
		Set<Training> tt=new HashSet<Training>();
		tt.add(t2);
		tt.add(t1);
		
		s1.setTrainings(tt);
		
		ss.save(s1);
		
		HibernateUtility.closeSession(null);
	}
}
