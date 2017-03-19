package com.mtit.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TransactionAspect {
	@Before("execution(public int getTransactionId())")
	public void getTransactionIdAdvice(JoinPoint joinPoint){
		System.out.println("model method getter called");
		System.out.println("invoked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}
}
