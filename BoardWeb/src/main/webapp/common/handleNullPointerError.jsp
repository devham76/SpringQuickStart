<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ȭ��</title>
</head>
<body bgcolor='#ffffff' text="#000000">

<!-- Ÿ��Ʋ ���� -->
<table width="100%" border=1 cellspacing=0 cellpadding=0>
	<tr><td align="center" >�⺻ ���� ȭ���Դϴ�</td></tr>
</table>

<br>
<!--  error message -->
<table width="100%" border=1 cellsapcing=0 cellpadding=0 align=center>
	<tr>
		<td align="center">
			<br><br><br><br>
			Message : ${exception.message }
			<br><br><br><br>
		</td>
	</tr>
</table>
</body>
</html>