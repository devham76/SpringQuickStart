package com.springbook.biz.common;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service	// �ش� Ŭ������ ��ü�� �����Ǿ�� ����� �� �����Ƿ� @Service�� �̿��� �������ش�.
@Aspect		// LogAdvice �����̽�(����Ⱦ�ܰ����� ���) + allPointcut ����Ʈ��(��� �߻���ų��) ���� ��������ش�
public class LogAdvice {
	
	@Before("PointcutCommon.allPointcut()")
	public void printLog() {
		//System.out.println("[���� �α�] ����Ͻ� ���� ���� �� ����");
	}
}
