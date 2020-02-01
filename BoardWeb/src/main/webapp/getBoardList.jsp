<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List" %>
<%@page import="com.springbook.biz.board.impl.*" %>
<%@page import="com.springbook.biz.board.*" %>

<% 
	// ���ǿ� ����� �� ����� ������
	List<BoardVO> boardList = (List)session.getAttribute("boardList");
%>
<body>
<center>
	<h1>�� ���</h1>
	<h3>${userName}�� ȯ���մϴ�...<a href="logout_proc.jsp">�α� �ƿ�</a></h3>
	
	<!-- �˻� ���� -->
	<form action=getBoardList.jsp method="POST">
		<table width=700> 
		<tr>
			<td aling=right>
				<select name="searchCondition">
				<!-- @ModelAttributeȰ�� -->
				<c:forEach items="${conditionMap}" var="option">
					<option value="${option.value}">${option.key}</option>
				</c:forEach>
				</select>
				<input name="searchKeyword" type="text" />
				<input type="submit" value="�˻�" />
			</td>
		</tr>
		</table>
	</form>
	<!-- �˻� ���� -->
	
	<table width=700>
		<tr>
			<td>��ȣ</td>
			<td>����</td>
			<td>�ۼ���</td>
			<td>�����</td>
			<td>��ȸ��</td>
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
	<a href="insertBoard.jsp">���� ���</a>
	
</center>
</body>