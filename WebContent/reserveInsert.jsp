<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% request.getParameter("PlanId");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


予約情報を入力してください。<br>
<form action="/nhk/ReserveInsertServlet" method="post">
チェックイン日：<input type = "time" name = "checkindate" ><br>
チェックアウト日：<input type = "time" name = "checkoutdate" ><br>
人数：<input type = "number" name = "people" ><br>
<input type="hidden" name="action" value="input">
<input type="hidden" name="PlanId" value="${PlanId}">
<input type=submit value="確認画面へ"><br>
</form>


<a href="/nhk/memberMenu.jsp">メニューに戻る</a>



</body>
</html>