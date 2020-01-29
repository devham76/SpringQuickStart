package com.springbook.biz.polymorphism;

import org.springframework.stereotype.Component;

@Component("lgTV")
public class LgTV implements TV {
	public void initMethod() {
		System.out.println("��ü �ʱ�ȭ �۾� ó��");
	}
	public void destoryMethod() {
		System.out.println("��ü ���� ���� ó���� ���� ó��");
	}
	public void powerOn() {
		System.out.println("LgTV �����Ҵ�");
	}
	public void powerOff() {
		System.out.println("LgTV ��������");
	}

	public void volumnUp() {
		System.out.println("LgTV �Ҹ� �ø���");
	}
	public void volumnDown() {
		System.out.println("LgTV �Ҹ� ������");
	}
}
