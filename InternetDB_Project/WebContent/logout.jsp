<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
session.invalidate(); // 세션 무효화
response.sendRedirect("index.jsp"); // 로그아웃 후 메인 페이지로 리디렉션
%>
</body>
</html>