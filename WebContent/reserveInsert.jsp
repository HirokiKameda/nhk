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
予約日：<input type = time name = "reservedate" ><br>
予約時間：<input type = time name = "reservetime" ><br>
チェックイン日：<input type = time name = "checkindate" ><br>
チェックアウト日：<input type = time name = "checkoutdate" ><br>
人数：<input type = number name = "people" ><br>
<input type=submit value="確認画面へ"><br>
<input type="hidden" name="action" value="input">
</form>


<a href="/nhk/memberMenu.jsp">メニューに戻る</a>



</body>
</html>