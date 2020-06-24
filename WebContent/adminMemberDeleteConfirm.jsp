<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会確認</title>
</head>
<body>

<h2>退会される会員情報</h2>
<table border="1">
<tr><td>名前</td><td>生年月日</td><td>電話番号</td><td>住所</td><td>メールアドレス</td><td>パスワード</td></tr>

<tr><td>${name}</td><td>${birthday}</td><td>${address}</td><td>${tel}</td><td>${email}</td><td>${password}</td></tr>
</table>

<form action="/nhk/MemberDeleteServlet" method="post">
<input type="hidden" name="id" value="${id}">
<input type="hidden" name="action" value="delete">
<input type="submit" value="退会">
</form>
<a href="/nhk/adminMenu.jsp">メニューに戻る</a>

</body>
</html>