<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%
	// 1. 사용자 입력 정보 추출
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("title");
	String seq = request.getParameter("seq");
	
	// 2. DB 연동
	BoardVO board = new BoardVO();
	board.setSeq(Integer.parseInt(seq));
	board.setTitle(title);
	board.setContent(content);
	
	BoardDAO boardDao = new BoardDAO();
	boardDao.updateBoard(board);
	
	// 3. 화면 네비게이션
	response.sendRedirect("getBoardList.jsp");
%>