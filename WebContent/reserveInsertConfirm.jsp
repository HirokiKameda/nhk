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

予約情報に間違いがないか確認してください。<br>

予約日時:<%=request.getParameter("reservedate") %><br>
部屋数:<%=request.getParameter("rooms") %><br>

<form action="/nhk/ReserveInsertServlet" method="post">
<input type="submit" value="予約"><br>
<input type="hidden" name="action" value="confirm">
</form>
<a href="/nhk/ReserveInsert.jsp">予約画面に戻る</a>
<a href="/nhk/memberMenu.jsp">メニューに戻る</a>




</body>
</html>