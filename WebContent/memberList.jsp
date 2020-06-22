<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員一覧</title>
</head>
<body>
<h1>会員一覧</h1>
<form action="/nhk/MemberUpdateServlet" method="post">
<input type="hidden" name="action" value="confirm">
<input type="submit" value="変更">
</form>
<form action="/nhk/MemberDeleteServlet" method="post">
<input type="hidden" name="action" value="confirm">
<input type="submit" value="退会">
</form>
<a href="/nhk/memberMenu">メニューに戻る</a>

</body>
</html>