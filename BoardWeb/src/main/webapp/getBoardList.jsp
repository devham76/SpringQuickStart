<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List" %>
<%@page import="com.springbook.biz.board.impl.*" %>
<%@page import="com.springbook.biz.board.*" %>

<% 
	// 세션에 저장된 글 목록을 꺼낸다
	List<BoardVO> boardList = (List)session.getAttribute("boardList");
%>
<body>
<center>
	<h1>글 목록</h1>
	<h3>${userName}님 환영합니다...<a href="logout_proc.jsp">로그 아웃</a></h3>
	
	<!-- 검색 시작 -->
	<form action=getBoardList.jsp method="POST">
		<table width=700> 
		<tr>
			<td aling=right>
				<select name="searchCondition">
				<!-- @ModelAttribute활용 -->
				<c:forEach items="${conditionMap}" var="option">
					<option value="${option.value}">${option.key}</option>
				</c:forEach>
				</select>
				<input name="searchKeyword" type="text" />
				<input type="submit" value="검색" />
			</td>
		</tr>
		</table>
	</form>
	<!-- 검색 종료 -->
	
	<table width=700>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>등록일</td>
			<td>조회수</td>
		</tr>
	
	<%  for(BoardVO board : boardList) { %>
	<tr>
		<td><%=board.getSeq() %></td>
		<td><a href="getBoard.do?seq=<%board.getSeq(); %>">
				<%=board.getTitle() %>
			</a> 
		</td>
		<td><%=board.getWriter() %></td>
		<td><%=board.getRegDate() %></td>
		<td><%=board.getCnt() %></td>
	</tr>
	<% } %>
	</table>

<br>
	<a href="insertBoard.jsp">새글 등록</a>
	
</center>
</body>