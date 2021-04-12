package annospringcontainer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContainerDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		
		ShoeShop shop=ctx.getBean("gokulShoeShop",GokulShoeShop.class);
		
		//Shoe shoe=new LeatherShoe();
		
		Customer cus=new ShoeCustomer("Akshay");
		
		Shoe s=shop.sellShoe(cus);
		
		System.out.println(s);
		
		ctx.close();
	}
}
