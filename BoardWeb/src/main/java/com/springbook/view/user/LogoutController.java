package com.springbook.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("�α׾ƿ� ó��");
		
		HttpSession session = request.getSession();
		// 1. �������� ����� ���� ��ü�� ���� �����Ѵ�.
		session.invalidate();
		
		// 2. ���� ���� ��, ���� ȭ������ �̵��Ѵ�.
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:login.jsp");
		return mv;
	}

}
