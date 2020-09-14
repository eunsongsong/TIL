<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>등록 화면</h2>
	<form action="hello.do" method="get">
		<ul>
			<li>
				UserID : <input type="text" name="userId" />
			</li>
			<li>
				Name : <input type="text" name="firstName" />
			</li>
			<li>
				Age : <input type="text" name="age" >
			</li>
			<li>
				<input type="submit" value="등록" >
			</li>
		</ul>
	</form>
</body>
</html>