<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<% 

/*
	MVC1 : controller + view �� JSP�� �־���
	MVC2 : java �κ��� controller�ν�  DispathcerServlet.java�� ���� JSP���� view�� �ֵ����Ѵ� !

*/
	//-- �α��� ���μ��� 
	// 1. ����� �Է� ���� ����
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB���� ó��
	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userdao = new UserDAO();
	UserVO user = userdao.getUser(vo);
	if(user != null){
		response.sendRedirect("getBoardList.jsp");
	}else {
		response.sendRedirect("login.jsp");
	}
	
	
	// 3. ȭ�� �׺���̼�
%>
