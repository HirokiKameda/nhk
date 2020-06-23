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


予約情報を入力してください。<br>
<form action="/nhk/ReserveInsertServlet" method="post">
予約日時：<input type = number name = "reservedate" ><br>
部屋数：<input type = number name = "rooms" ><br>
<input type=submit value="確認画面へ"><br>
<input type="hidden" name="action" value="input">
</form>


<a href="/nhk/memberMenu.jsp">メニューに戻る</a>



</body>
</html>