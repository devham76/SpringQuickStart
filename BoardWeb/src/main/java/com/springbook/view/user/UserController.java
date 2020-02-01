package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class UserController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�");
		// �� �κ��� �̿��ϸ� ���̵� ����ϱ⸦ �����Ҽ��ִ�
		vo.setId("test");
		vo.setPassword("1234");
		
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userdao, HttpSession session) {
		System.out.println("�α��� ���� ó��");
		UserVO user = userdao.getUser(vo);
		if(user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		}
		else 
			return "login.jsp";
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α׾ƿ� ó��");
		
		// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
		session.invalidate();
		
		// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
		return "login.jsp";
	}

}
