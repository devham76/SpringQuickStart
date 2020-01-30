package com.springbook.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동한다.
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 UserServiceImpl 객체를 요청(Lookup)한다.
		UserService userService = (UserService) container.getBean("userService");
		
		//-- 테이블 생성 테스트 
		userService.createTable();
		
		// 3. 사용자 등록 기능 테스트
		UserVO vo = new UserVO();
		vo.setId("devham");
		vo.setPassword("devham11");
		vo.setName("이혜미");
		vo.setRole("관리자");
		userService.insertUser(vo);
		
		// 4. 특정 사용자 검색 기능 테스트
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "님 환영해유");
		}else {
			System.out.println("로그인 실패");
		}
		
		// 5. Spring컨터이터 종료
		container.close();
	}
}
