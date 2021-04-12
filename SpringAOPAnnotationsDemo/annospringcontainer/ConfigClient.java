package annospringcontainer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigClient {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigAnnoDemo.class);

		System.out.println(ctx.getBean("getH"));
		
		ctx.close();
	}
}
