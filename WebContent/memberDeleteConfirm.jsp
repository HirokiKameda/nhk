<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会確認</title>
</head>
<body>
<form action="/nhk/MemberDeleteServlet" method="post">
<input type="hidden" name="action" value="delete">
<input type="submit" value="退会">
</form>
<a href="/nhk/memberMenu.jsp">メニューに戻る</a>

</body>
</html>