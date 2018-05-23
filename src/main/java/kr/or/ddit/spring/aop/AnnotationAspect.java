package kr.or.ddit.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AnnotationAspect.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 23.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 23. "K.S.J" 최초 생성
 *
 * </pre>
 */

@Aspect
public class AnnotationAspect {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
//	Logger logger = LoggerFactory.getLogger(AnnotationAspect.class);
	
	//<aop:pointcut id="logging" expression="execution(* kr.or.ddit..*Service.*(..))"/>
	@Pointcut("execution(* kr.or.ddit..*Service.*(..))")
	public void dummy(){}
	
	//<aop:before method="before" pointcut-ref="logging"/>
	@Before("dummy()")
	public void beforeMethod(){
		logger.debug("{}", "AnnotationAspect.beforeMethod()");
	}
	
	@After("dummy()")
	public void afterMethod(){
		logger.debug("{}", "AnnotationAspect.afterMethod()");
	}
	
	@Around("dummy()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
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
