<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理者ログイン</title>
</head>
<body>

<h1>管理者ログイン</h1>

<form action="/nhk/MemberLoginServlet" method="post">
user:<input type="text" name="username"><br>
password:<input type="text" name="password"><br>
<input type="hidden" name="usertype" value="admin">
<input type="submit" value="login">
</form>


<c:if test="${isLogin eq 1}">
ユーザ名もしくはパスワードが間違っています。
</c:if>

</body>
</html>