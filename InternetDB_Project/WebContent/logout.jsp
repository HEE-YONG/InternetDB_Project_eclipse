<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Logout</title>
</head>
<body>
<%
session.invalidate(); // 세션 무효화
response.sendRedirect("index.jsp"); // 로그아웃 후 메인 페이지로 리디렉션
%>
</body>
</html>