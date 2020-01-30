package com.springbook.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AfterThrowingAdvice {
	
	
	// 포인트컷 설정 및 (예외)결과값 받아오기
	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName(); // 실행된 메소드 이름 가져오기
		System.out.println(method + "() 메소드 수행 중 예외 발생");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력되었습니다");
		} else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자 형식의 값이 아닙니다");
		} else if(exceptObj instanceof Exception) {
			System.out.println("문제가 발생했습니다");
		}
	}
}
