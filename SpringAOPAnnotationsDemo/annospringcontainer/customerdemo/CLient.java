package annospringcontainer.customerdemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CLient {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("anno-config2.xml");
		
		CustomerBo customer=(CustomerBo) ctx.getBean("customerBoImpl",CustomerBoImpl.class);
		
		customer.addCustomer();
		customer.addCustomerReturnValue();
		try {
		customer.addCustomerThrowException();}
		catch(Exception e) {
			e.printStackTrace();
		}
		customer.addCustomerAround("Akshay");
	}
}
