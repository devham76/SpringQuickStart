<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.user.impl.UserDAO"%>
<%@page import="com.springbook.biz.user.UserVO"%>
<% 

/*
	MVC1 : controller + view 가 JSP에 있었다
	MVC2 : java 부분을 controller로써  DispathcerServlet.java로 빼서 JSP에는 view만 있도록한다 !

*/
	//-- 로그인 프로세스 
	// 1. 사용자 입력 정보 추출
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	// 2. DB연동 처리
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
	
	
	// 3. 화면 네비게이션
%>
