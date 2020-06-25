<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>会員メニュー</h1>
<a href ="/nhk/memberUpdate.jsp">会員情報変更</a>
<a href ="/nhk/HotelShowServlet">予約</a>
<a href ="/nhk/ReserveShowServlet">予約履歴</a>
<form action="/nhk/MemberDeleteServlet" method="post">
<input type="hidden" name="action" value="confirm">
<input type="submit" value="会員退会">
</form>
</body>
</html>