package com.springbook.biz.common;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service	// 해당 클래스의 객체가 생성되어야 사용할 수 있으므로 @Service를 이용해 생성해준다.
@Aspect		// LogAdvice 어드바이스(공통횡단관심의 기능) + allPointcut 포인트컷(어디서 발생시킬지) 둘을 연결시켜준다
public class LogAdvice {
	
	@Before("PointcutCommon.allPointcut()")
	public void printLog() {
		//System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
	}
}
