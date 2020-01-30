<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.List" %>
<%@page import="com.springbook.biz.board.impl.*" %>
<%@page import="com.springbook.biz.board.*" %>

<% 
	// 1. ����� �Է� ��������(�˻� ����� ���ֿ� ����)
	// 2. DB ���� ó��
	BoardDAOSpring boardDao = new BoardDAOSpring();
	// ���̺� ����
	boardDao.createtable();
	// �ӽñ� �ۼ�
	BoardVO vo = new BoardVO();
	vo.setTitle("���� �׽�Ʈ��");
	vo.setWriter("������");
	vo.setContent("�ӽ� �����̶�� spring boot �ѼŹ����ڴ�~~");
	boardDao.insertBoard(vo);
	
	List<BoardVO> boardList = boardDao.getBoardList();
	
	// 3. ���� ȭ�� ����

%>
<body>
<center>
	<h1>�� ���</h1>
	<h3>�׽�Ʈ�� ȯ���մϴ�...<a href="logout_proc.jsp">�α� �ƿ�</h3>
	
	<!-- �˻� ���� -->
	<form action=getBoardList.jsp method="POST">
		<table width=700> 
		<tr>
			<td aling=right>
				<select name="searchCondition">
					<option value="TITLE">����</option>
					<option value="CONTENT">����</option>
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
	<a href="insertBoard.jsp">���� ���</a>
	
</center>
</body>