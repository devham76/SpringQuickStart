package com.springbook.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
// ProceedingJoinPoint객체의 proceed()를 통해 비즈니스 메소드를 호출할 수 있다.

	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		//System.out.println("[Before] : 비즈니스 메소드 수행 전에 처리내용...");
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println(method + "() 메소드 수행 시간 : "+ stopWatch.getTotalTimeMillis()+"(ms)초");
		return returnObj;
	}
}
