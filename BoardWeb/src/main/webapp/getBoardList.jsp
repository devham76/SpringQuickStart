<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List" %>
<%@page import="com.springbook.biz.board.impl.*" %>
<%@page import="com.springbook.biz.board.*" %>

<% 
	// 1. 사용자 입력 정보추출(검색 기능은 나주에 구현)
	// 2. DB 연동 처리
	BoardDAOSpring boardDao = new BoardDAOSpring();
	// 테이블 생성
	boardDao.createtable();
	// 임시글 작성
	BoardVO vo = new BoardVO();
	vo.setTitle("제목 테스트얌");
	vo.setWriter("이혜미");
	vo.setContent("임시 내용이라능 spring boot 뿌셔버리자능~~");
	boardDao.insertBoard(vo);
	
	List<BoardVO> boardList = boardDao.getBoardList();
	
	// 3. 응답 화면 구성

%>
<body>
<center>
	<h1>글 목록</h1>
	<h3>테스트님 환영합니다...<a href="logout_proc.jsp">로그 아웃</h3>
	
	<!-- 검색 시작 -->
	<form action=getBoardList.jsp method="POST">
		<table width=700> 
		<tr>
			<td aling=right>
				<select name="searchCondition">
					<option value="TITLE">제목</option>
					<option value="CONTENT">내용</option>
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
	
	<% for(BoardVO board : boardList) { %>
	<tr>
		<td><%=board.getSeq() %></td>
		<td><a href="getBoard.jsp?seq=<%board.getSeq(); %>">
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