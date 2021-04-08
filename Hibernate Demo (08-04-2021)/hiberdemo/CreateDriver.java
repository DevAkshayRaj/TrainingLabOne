package hiberdemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;

public class CreateDriver {
	public static void main(String[] args) {
		Description dd=new Description();
		dd.setDesc("Split AC is the chosen model with five star rating");
		AirConditionerDto aircon=new AirConditionerDto(2,"Voltas","1.5 TON",28000,dd);
		
		//Step1 - Load Configuration
		Configuration cfg=new Configuration();

		//Step 2 - Build SessionFactory
		SessionFactory factory=cfg.configure().buildSessionFactory();
		
		//Step 3 - Create a session (Local Cache - Client specific)
		Session session=factory.openSession();
		
		//Create a HibernateUtility class with ThreadLocal to get a unique session for every thread.-----class work
		
		//To make the DTO hibernate aware, ensure that you call save method of session with the DTO object.
		session.save(aircon);
		
		session.beginTransaction().commit();
	}
}
