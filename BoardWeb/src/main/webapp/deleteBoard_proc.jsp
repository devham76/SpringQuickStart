<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO" %>
<%@page import="com.springbook.biz.board.BoardVO" %>
<%
	// 1. ����� �Է� ���� ����
	String seq = request.getParameter("seq");
	
	// 2. DB ����
	BoardVO board = new BoardVO();
	board.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDao = new BoardDAO();
	boardDao.deleteBoard(board);
	
	// 3. ȭ�� �׺���̼�
	response.sendRedirect("getBoardList.jsp");
%>