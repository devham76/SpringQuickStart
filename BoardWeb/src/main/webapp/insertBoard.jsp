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
<h1>�� ��</h1>
<a href="logout_proc.jsp">�α׾ƿ�(mvc1)</a> &nbsp;
<a href="logout.do">�α׾ƿ�(mvc2)</a>
<hr>
<form action="insertBoard.dos" method="post">
	<table>
		<tr>
			<td>����</td>
			<td><input type=text name=title/></td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td><input type=text name=writer /></td>
		</tr>
		<tr>
			<td>����</td>
			<td><textarea type=text name=content></textarea></td>
		</tr>

		<tr>
			<td colspan=2> <input type=submit value="�� ���" /></td>
		</tr>
	</table>
</form>
<hr>
<a href="getBoardList.jsp">�� ���</a>&nbsp;
</center>
</body>
</html>