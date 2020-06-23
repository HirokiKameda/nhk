<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>会員様ログイン</h1>

<form action="/nhk/MemberLoginServlet" method="post">
Email:<input type="text" name="email"><br>
password:<input type="text" name="password"><br>
<input type="hidden" name="usertype" value="member">
<input type="submit" value="login">
</form>


<c:if test="${isLogin eq 1}">
メールアドレスもしくはパスワードが間違っています。
</c:if>

<a href="/nhk/memberInsert.jsp">新規会員登録</a>

</body>
</html>