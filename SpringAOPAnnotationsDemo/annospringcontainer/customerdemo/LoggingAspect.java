package annospringcontainer.customerdemo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	@Before("execution(* annospringcontainer.customerdemo.CustomerBo.addCustomer(..))")
	public void logBefore(JoinPoint jp) {
		System.out.println("logBefore() is called !!");
		System.out.println("Inside before:" + jp.getSignature().getName());
		System.out.println("*********");
	}

	@After("execution(* annospringcontainer.customerdemo.CustomerBo.addCustomer(..))")
	public void logAfter(JoinPoint jp) {
		System.out.println("logAfter() is called !!");
		System.out.println("Inside After:" + jp.getSignature().getName());
		System.out.println("*********");
	}

	@AfterReturning(pointcut = "execution(* annospringcontainer.customerdemo.CustomerBo.addCustomerReturnValue(..))", returning = "result")
	public void logAfterREturning(JoinPoint jp, Object result) {
		System.out.println("logAfterReturning() is running!");
		System.out.println("Inside after returning : " + jp.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");

	}

	@AfterThrowing(
	pointcut = "execution(* annospringcontainer.customerdemo.CustomerBo.addCustomerThrowException(..))", 
	throwing= "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
			System.out.println("logAfterThrowing() is running!");
			System.out.println("Inside After Throwing-excep: " +joinPoint.getSignature().getName());
			System.out.println("Exception : " + error);
			System.out.println("******");
	}
	
	@Around("execution(* annospringcontainer.customerdemo.CustomerBo.addCustomerAround(..))") 
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("logAround() is running!");
		System.out.println("Around method : " +joinPoint.getSignature().getName());
		System.out.println("Around Method arguments : " +Arrays.toString(joinPoint.getArgs()));
		System.out.println("Around before is running!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("Around after is running!");
		System.out.println("******");
	}

	
}
