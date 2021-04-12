package annospringcontainer.customerdemo;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CustomerBoImpl implements CustomerBo{

	@Override
	public void addCustomer() {
		System.out.println("addCustomer is Running !!!");
	}

	@Override
	public String addCustomerReturnValue() {
		System.out.println("addCustomerReturnValue is Running !!!");
		return "returned from addCustomerReturnValue !";
	}

	@Override
	public void addCustomerThrowException() throws Exception {
		System.out.println("addCustomerThrowException is Running !!!");
		throw new Exception("Generic Error");
	}

	@Override
	public void addCustomerAround(String name) {
		System.out.println("addCustomerAround is Running !!!");
	}
	
}
