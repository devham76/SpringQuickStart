<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="com.springbook.biz.board.impl.BoardDAO" %>    
<%@page import="com.springbook.biz.board.BoardVO" %>      
<%
	// 1. 검색할 게시글 번호 추출
	String seq = request.getParameter("seq");

	// 2. DB연동
	BoardVO vo = new BoardVO();
	vo.setSeq(Integer.parseInt(seq));
	
	BoardDAO boardDao = new BoardDAO();
	BoardVO boardVo = boardDao.getBoard(vo);
	
	// 3. 응답화면
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
<form action="updateBoard_proc.jsp" method="post">
	<input type=hidden name=seq value=<%=boardVo.getCnt() %> />
	<table>
		<tr>
			<td>제목</td>
			<td><input type=text name=title value=<%=boardVo.getTitle() %> /></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type=text name=writer value=<%=boardVo.getWriter() %> /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><textarea type=text name=content><%=boardVo.getContent() %></textarea></td>
		</tr>
		<tr>
			<td>등록일</td>
			<td><input type=text name=regDate value=<%=boardVo.getRegDate() %> /></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td><input type=text name=cnt value=<%=boardVo.getCnt() %> /></td>
		</tr>
		<tr>
			<td colspan=2> <input type=submit value="글 수정" /></td>
		</tr>
	</table>
</form>
<hr>
<a href="insertBoaard.jsp">글 등록</a>&nbsp;
<a href="deleteBoard.jsp">글 삭제</a>&nbsp;
<a href="getBoardList.jsp">글 목록</a>&nbsp;
</center>
</body>
</html>