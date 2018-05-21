package kr.or.ddit.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Aspect {
	Logger logger = LoggerFactory.getLogger(Aspect.class);
	
	public void before(JoinPoint joinPoint){
		logger.debug("{}.{}, {}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), "before()");
	}
	
	public void after(JoinPoint joinPoint){
		logger.debug("{}.{}, {}", joinPoint.getTarget().getClass().getName(), joinPoint.getSignature().getName(), "after()");
	}
	
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		//before
		logger.debug("{}", "around - before");
		long startTime = System.currentTimeMillis();
		
		//핵심로직
		Object result = joinPoint.proceed();
		
		//after
		logger.debug("{}", "around - after");
		long endTime = System.currentTimeMillis();
		
		logger.debug("{} : {} {}", "duration", endTime-startTime, "ms");
		return result;
	}
}
