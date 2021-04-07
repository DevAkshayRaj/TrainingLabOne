package springcontainer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContainerDemo {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("config.xml");
		GokulShoeShop ss=ctx.getBean("shop",GokulShoeShop.class);
		
		ShoeSeller ss1=ctx.getBean("shop",ShoeSeller.class);
		ShoeCustomer ak=ctx.getBean("cus",ShoeCustomer.class);
		Customer one=new ShoeCustomer("Raja");
		Customer two =ak.getShoe("Raj");
		Customer three =ak.getShoe("Rajsdsda");
		System.out.println(three.getName());
		Shoe sold=ss.sellShoe(one);
	Shoe sold1=ss.sellShoe(two);
		Shoe sold2=ss.sellShoe(three);
		System.out.println(ss.getFactory().getSkey());
		System.out.println(ss.getSkey());
		System.out.println(one);
		System.out.println(two);
		
	}
}
