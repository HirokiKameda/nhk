<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
</head>
<body>

<h2>登録する会員情報</h2>
<table border="1">
<tr><td>名前</td><td>生年月日</td><td>電話番号</td><td>住所</td><td>メールアドレス</td><td>パスワード</td></tr>

<tr><td>${name}</td><td>${birthday}</td><td>${address}</td><td>${tel}</td><td>${email}</td><td>${password}</td></tr>

</table>

<form action="/nhk/MemberInsertServlet" method="post">
<input type="hidden" name="action" value="insert">
<input type="hidden" name="name" value="${name}">
<input type="hidden" name="birthday" value="${birthday}">
<input type="hidden" name="tel" value="${tel}">
<input type="hidden" name="address" value="${address}">
<input type="hidden" name="email" value="${email}">
<input type="hidden" name="password" value="${password}">
<input type="submit" value="登録">
</form>
<a href="/nhk/memberMenu.jsp">メニューに戻る</a>
</body>
</html>