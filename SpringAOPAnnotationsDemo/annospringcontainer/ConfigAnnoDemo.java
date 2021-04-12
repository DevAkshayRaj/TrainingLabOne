package annospringcontainer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ConfigAnnoDemo {
	
	@Bean(name = "getH")
	public HelloWorld getHello() {
		return new HelloWorld();
	}
}
class HelloWorld{
	
}