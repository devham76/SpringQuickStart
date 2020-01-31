<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO" %>    
<%@page import="com.springbook.biz.board.BoardVO" %>      
<%
	BoardVO boardVo = (BoardVO) session.getAttribute("board"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>글 상세</h1>
<a href="logout_proc.jsp">로그아웃(mvc1)</a> &nbsp;
<a href="logout.do">로그아웃(mvc2)</a>
<hr>
<form action="insertBoard.dos" method="post">
	<table>
		<tr>
			<td>제목</td>
			<td><input type=text name=title/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type=text name=writer /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea type=text name=content></textarea></td>
		</tr>

		<tr>
			<td colspan=2> <input type=submit value="글 등록" /></td>
		</tr>
	</table>
</form>
<hr>
<a href="getBoardList.jsp">글 목록</a>&nbsp;
</center>
</body>
</html>