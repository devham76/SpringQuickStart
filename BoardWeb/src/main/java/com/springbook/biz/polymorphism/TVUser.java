package com.springbook.biz.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {

		// 1. Spring �����̳ʸ� �����Ѵ�., bean�� ��ϵ� ��ü�����Ѵ�.
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �������ͷκ��� �ʿ��� ��ü�� ��û(lookup)�Ѵ�
		TV tv = (TV) factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumnUp();
		tv.volumnDown();
	}
}
