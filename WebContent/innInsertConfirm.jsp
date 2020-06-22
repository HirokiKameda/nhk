<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm Input</title>
</head>
<body>

入力に間違いがないか確認してください。<br>

名前:<%=request.getParameter("name") %><br>
紹介文:<%=request.getParameter("intro") %><br>
住所:<%=request.getParameter("address") %><br>
チェックイン時間:<%=request.getParameter("checkin") %><Br>
チェックアウト時間:<%=request.getParameter("checkout") %><br>
電話:<%=request.getParameter("tel") %><br>

<form action="/nhk/HotelInsertServlet" method="post">
<input type="submit" value="登録"><br>
<input type="hidden" name="action" value="confirm">
</form>
<a href="/nhk/innInsert.jsp">戻る</a>
<a href="/nhk/adminMenu.jsp">メニューに戻る</a>
</body>
</html>