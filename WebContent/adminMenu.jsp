<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>管理者メニュー</h1>
<a href ="/nhk/innInsert.jsp">新規宿登録</a>
<a href ="/nhk//HotelSowServlet?action=admin">宿一覧</a>
<form action="/nhk/MemberShowServlet" method="post">
<input type="hidden" name="list" value="${list}">
<input type="submit" value="会員一覧">
</form>




</body>
</html>