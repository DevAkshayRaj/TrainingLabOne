package springdaodemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("config.xml");
		
		DaoDemoImpl dd=ctx.getBean("DaoDemo",DaoDemoImpl.class);
		
		dd.test();
	}
}
