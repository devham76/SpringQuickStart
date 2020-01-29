package com.springbook.biz.polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class SamsungTV implements TV{
	/*
	// 의존성 주입 방법 1.
	@Autowired
	@Qualifier("apple")
	*/
	// 의존성 주입 방법 2.
	@Resource(name="apple")
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV(1) 객체 생성");
	}
	
	public void setSpeaker(Speaker speaker) {
		System.out.println("---> setSpeaker() 호출");
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		System.out.println("---> setPrice() 호출");
		this.price = price;
	}
	
	
	public void powerOn() {
		System.out.println("SamsungTV 전원켠다  / 가격: "+price);
	}
	public void powerOff() {
		System.out.println("SamsungTV 전원끈다");
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
