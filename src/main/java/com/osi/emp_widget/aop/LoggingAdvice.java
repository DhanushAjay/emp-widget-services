package com.osi.emp_widget.aop;
/*
 * Created by     : Eppalapalli Ajay Kumar
 * Employee ID    : NS2060
 * Created  on    : 6/3/2020 5:15 PM
 * Project        : com.osi.emp_widget.aop
 * Organization   : OSI Digital Pvt Ltd.
 */
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut(value = "execution(* com.osi.emp_widget.controller.*.*(..))")
	public void myPointcut() {
		//defining reusable pointcut method
	}

	/*
	 * This Method is invoked Before and After of any of the method is called in
	 * Controller Package
	 */
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		String methodName = proceedingJoinPoint.getSignature().getName();
		String className = proceedingJoinPoint.getTarget().getClass().toString();
		logger.info("Initial method request invoked Class Name : {} Method Name : {} \n Arguments Passed: {} ",className,methodName,Arrays.toString(proceedingJoinPoint.getArgs()));
		Object result = proceedingJoinPoint.proceed();
		long endTime = System.currentTimeMillis();
		float timeTaken =  endTime - startTime / 1000F;
		logger.info("Response Time {} secs Class Name : {}  Method Name : {} \n Response returning : {} ",timeTaken,className,methodName,result);
		return result;
	}
}
