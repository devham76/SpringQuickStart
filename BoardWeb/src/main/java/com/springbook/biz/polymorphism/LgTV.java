package com.springbook.biz.polymorphism;

import org.springframework.stereotype.Component;

@Component("lgTV")
public class LgTV implements TV {
	public void initMethod() {
		System.out.println("객체 초기화 작업 처리");
	}
	public void destoryMethod() {
		System.out.println("객체 삭제 전에 처리할 로직 처리");
	}
	public void powerOn() {
		System.out.println("LgTV 전원켠다");
	}
	public void powerOff() {
		System.out.println("LgTV 전원끈다");
	}

	public void volumnUp() {
		System.out.println("LgTV 소리 올린다");
	}
	public void volumnDown() {
		System.out.println("LgTV 소리 내린다");
	}
}
