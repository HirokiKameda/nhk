<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

「プラン名」の情報を削除してもよろしいでしょうか？<br>

<form action="/nhk/PlanDeleteServlet" method="post">
<input type="submit" value="削除"><br>
<input type="hidden" name="action" value="confirm">
</form>

<a href="/nhk/adminMenu.jsp">メニューへに戻る</a><br>


</body>
</html>