<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 관리 메인 화면</h2>
	<form method="get" action="getUser.do">
		<input type="text" name="userid"><br/>
		<input type="submit" value="조회">
	</form>
	<hr>
	<a href="getUserList.do">사용자 리스트</a>
</body>
</html>