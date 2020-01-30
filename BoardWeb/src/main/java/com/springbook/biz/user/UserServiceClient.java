package com.springbook.biz.user;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.springbook.biz.board.BoardService;
import com.springbook.biz.board.BoardVO;

public class UserServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳� �����Ѵ�.
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring �����̳ʷκ��� UserServiceImpl ��ü�� ��û(Lookup)�Ѵ�.
		UserService userService = (UserService) container.getBean("userService");
		
		//-- ���̺� ���� �׽�Ʈ 
		userService.createTable();
		
		// 3. ����� ��� ��� �׽�Ʈ
		UserVO vo = new UserVO();
		vo.setId("devham");
		vo.setPassword("devham11");
		vo.setName("������");
		vo.setRole("������");
		userService.insertUser(vo);
		
		// 4. Ư�� ����� �˻� ��� �׽�Ʈ
		UserVO user = userService.getUser(vo);
		if(user != null) {
			System.out.println(user.getName() + "�� ȯ������");
		}else {
			System.out.println("�α��� ����");
		}
		
		// 5. Spring�������� ����
		container.close();
	}
}
