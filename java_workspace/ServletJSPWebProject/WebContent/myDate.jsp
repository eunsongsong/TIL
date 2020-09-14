<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="EUC-KR"> -->
<title>Insert title here</title>
</head>
<body>
	<%-- JSP Comment --%>
	<% Date myDate = new Date(); %>
	<h1> 현재 날짜는 : <% out.println(myDate); %></h1>
	<h2> 현재 날짜는 : <%= myDate %></h2>
</body>
</html>