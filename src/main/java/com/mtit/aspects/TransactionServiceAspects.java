package com.mtit.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.mtit.service.UserValidationService;

@Aspect
public class TransactionServiceAspects {
	@Autowired
	private UserValidationService userValidationService;

	@Before("execution(* com.mtit.service.TransactionService.getAllTransactions())")
	public void getAllTransactionBefore(JoinPoint joinPoint) {
		System.out.println("******");
		System.out.println("getting all available transactions");
		System.out.println("invoked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@After("execution(* com.mtit.service.TransactionService.getAllTransactions())")
	public void getAllTransactionAfter(JoinPoint joinPoint) {
		System.out.println("all transactions are listed accordingly");
		System.out.println("invoked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterReturning(pointcut = "execution(* com.mtit.service.TransactionService.getAllTransactions())", returning = "result")
	public void getAllTransactionAfterReturning(JoinPoint joinPoint,
			Object result) {
		System.out.println("listing all transactions are successfull");
		System.out.println("invoked : " + joinPoint.getSignature().getName());
		System.out.println("Method returned value is : " + result);
		System.out.println("******");
	}

	/*@Around("execution(* com.mtit.service.TransactionService.deposit(*))")
	public void doDeposit(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("******");
		System.out
				.println("deposit service has been started and it is under security check");
		System.out.println("invoked : " + joinPoint.getSignature().getName());
		System.out.println("invoked arguments are : "
				+ Arrays.toString(joinPoint.getArgs()));
		System.out.println("security check is running!");
		joinPoint.proceed();
		System.out.println("completing securty check!");
		System.out.println("******");
	}*/

}
