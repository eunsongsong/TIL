<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>����� ����Ʈ</h2>
	<table>
		<tr>
			<th>USERID</th>
			<th>NAME</th>
		</tr>

		<c:forEach var="user" items="${users}">
			<tr>
				<td>
					<a href="getUser.do?userid=${user.userId}">${user.userId}</a>
				</td>
				<td>${user.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>

