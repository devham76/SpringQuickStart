package com.springbook.biz.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
	/*
	// ������ ���� ��� 1.
	@Autowired
	@Qualifier("apple")
	*/
	// ������ ���� ��� 2.
	@Resource(name="apple")
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV(1) ��ü ����");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("---> setSpeaker() ȣ��");
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		System.out.println("---> setPrice() ȣ��");
		this.price = price;
	}
	
	
	public void powerOn() {
		System.out.println("SamsungTV �����Ҵ�  / ����: "+price);
	}
	public void powerOff() {
		System.out.println("SamsungTV ��������");
	}

	@Override
	public void volumnUp() {
		speaker.volumeUp();
	}
	@Override
	public void volumnDown() {
		speaker.volumeDown();
	}
}
