
package net.antra.sep.springassignment.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatabaseManipulationAop {
	
	@After("insertStatement()")
	public void insertResult(JoinPoint jp) {
		System.out.println("An (" + jp.getSignature().getName() + ") is executed on (" + jp.getTarget().getClass() + ")");
	}

	@Before("selectStatement()")
	public void selectAction(JoinPoint jp) {
		System.out.println("A (" + jp.getSignature().getName() + ") statement is about to run on (" + jp.getTarget().getClass() + ")");
	}
	
//	@Around("execution(* saveEmployee(..))")
	@Around("execution(* *.setEmpAge(..))")
//	@Around("execution(* *.Integer.parseInt(..))")
	public Object parseIntError(ProceedingJoinPoint pjp) {
		Object value = null;
		System.out.println("A (" + pjp.getSignature().getName() + ") statement is about to run on (" + pjp.getTarget().getClass() + ")");
		try {
			value = pjp.proceed();
			System.out.println("The (" + pjp.getSignature().getName() + ") is executed without error on (" + pjp.getTarget().getClass() + ")");
		} catch (Throwable e) {
			System.out.println("---------------------------------Please input a integer for the age!!---------------------------------");
//			e.printStackTrace();
		}
		
		return value;
	}
	
	@Pointcut("execution(* setEmpAge(..))")
	public void parseInt(){}
	
	@Pointcut("execution(* *.select(..))")
	public void selectStatement() {}
	
	@Pointcut("execution(* *.save(..))")
	public void insertStatement() {}
}
