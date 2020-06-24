<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
変更内容

<form action="/nhk/MemberUpdateServlet" method="post">
名前:<input type="text" name="name"><br>
生年月日:<input type="text" name="birthday"><br>
電話番号:<input type="text" name="tel"><br>
住所:<input type="text" name="address"><br>
メールアドレス:<input type="text" name="email"><br>
パスワード:<input type="text" name="password"><br>
<input type="hidden" name="action" value="confirm">
<input type="hidden" name="id" value="${id}">
<input type="submit" value="確認">
</form>

<a href="/nhk/memberMenu.jsp">メニューに戻る</a>

</body>
</html>