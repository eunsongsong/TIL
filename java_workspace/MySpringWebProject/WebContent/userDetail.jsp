<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>사용자 상세 정보 조회</h2>
	<ul>
		<li>UserId : ${uservo.userId}</li>
		<li>이름 : ${uservo.name}</li>
		<li>성별 : ${uservo.gender}</li>
		<li>주소 : ${uservo.city}</li>
	</ul>
</body>
</html>