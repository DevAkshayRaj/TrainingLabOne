package hiberdemo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utility.HibernateUtility;

import org.hibernate.Session;

public class ReadDriver {
	public static void main(String[] args) {
	
		
		Session session=HibernateUtility.getSession();
		
		AirConditionerDto getobj=(AirConditionerDto)session.get(AirConditionerDto.class,Integer.valueOf(1));
				
				System.out.println(getobj);
	}
}
