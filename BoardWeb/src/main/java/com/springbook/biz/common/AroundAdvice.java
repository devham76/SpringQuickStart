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
// ProceedingJoinPoint��ü�� proceed()�� ���� ����Ͻ� �޼ҵ带 ȣ���� �� �ִ�.

	
	@Around("PointcutCommon.allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String method = pjp.getSignature().getName();
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		//System.out.println("[Before] : ����Ͻ� �޼ҵ� ���� ���� ó������...");
		Object returnObj = pjp.proceed();
		
		stopWatch.stop();
		System.out.println(method + "() �޼ҵ� ���� �ð� : "+ stopWatch.getTotalTimeMillis()+"(ms)��");
		return returnObj;
	}
}
