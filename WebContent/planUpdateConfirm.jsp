<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm chenge data</title>
</head>
<body>

変更に間違いがないか確認してください。<br>
プラン名:${bean.name}<br>
プラン内容:${bean.detail}<br>
金額:${bean.price}<br>
部屋数:${bean.maxrooms}<br>

<form action="/nhk/PlanUpdateServlet" method="post">
<input type="submit" value="変更"><br>
<input type="hidden" name="action" value="confirm">
<input type="hidden" name="name" value=${bean.name}>
<input type="hidden" name="derail" value=${bean.detail}>
<input type="hidden" name="price" value=${bean.price}>
<input type="hidden" name="maxrooms" value=${bean.maxrooms}>

<input type="hidden" name="nowid" value="${nowid}">
</form>
<a href="/nhk/planUpdate.jsp">入力画面に戻る</a>
<a href="/nhk/adminMenu.jsp">管理者メニューに戻る</a>


</body>
</html>