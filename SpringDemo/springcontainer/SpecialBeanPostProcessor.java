package springcontainer;

import java.lang.reflect.Field;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class SpecialBeanPostProcessor implements BeanPostProcessor{
	@Override
	public Object postProcessAfterInitialization(Object bean, String name) throws BeansException {
		System.out.println("After");
		System.out.println(bean);
		System.out.println(name);
		try {
			Field ff=bean.getClass().getSuperclass().getDeclaredField("skey");
			if(ff!=null) {
				ff.setAccessible(true);
				String value=(String)ff.get(bean);
				if(value==null) {
					ff.set(bean, "Secret Key is Set by post processor");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		return bean;
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String name) throws BeansException {
		System.out.println("Before");
		System.out.println(bean);
		System.out.println(name);
		return bean;
	}
}
