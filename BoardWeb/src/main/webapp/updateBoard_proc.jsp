<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%
	// 1. ����� �Է� ���� ����
	request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("title");
	String seq = request.getParameter("seq");
	
	// 2. DB ����
	BoardVO board = new BoardVO();
	board.setSeq(Integer.parseInt(seq));
	board.setTitle(title);
	board.setContent(content);
	
	BoardDAO boardDao = new BoardDAO();
	boardDao.updateBoard(board);
	
	// 3. ȭ�� �׺���̼�
	response.sendRedirect("getBoardList.jsp");
%>