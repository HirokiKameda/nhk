<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

     <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員一覧</title>
</head>
<body>
<h1>会員一覧</h1>




<c:forEach items="${list}" var="memlist">

<table border="1">
<tr><td>NO.</td><td>名前</td><td>生年月日</td><td>電話番号</td><td>住所</td><td>メールアドレス</td><td>パスワード</td></tr>

<tr><td>${memlist.id}</td><td>${memlist.name}</td><td>${memlist.birthday}</td><td>${memlist.address}</td><td>${memlist.tel}</td><td>${memlist.email}</td></tr>

</table>

<form action="/nhk/MemberUpdateServlet" method="post">
<input type="hidden" name="action" value="nyuryoku">
<input type="hidden" name="id" value="${memlist.id}">
<input type="submit" value="変更">
</form>
<form action="/nhk/MemberDeleteServlet" method="post">
<input type="hidden" name="action" value="confirm">
<input type="hidden" name="id" value="${memlist.id}">
<input type="submit" value="退会">
</form>

<br>

</c:forEach>

<a href="/nhk/memberMenu.jsp">メニューに戻る</a>

</body>
</html>