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

入力に間違いがないか確認してください。<br>
プラン名：${bean.name}<br>
プラン内容:${bean.detail}<br>
金額:${bean.price}<br>
部屋数:${bean.maxrooms}<br>

<form action="/nhk/PlanInsertServlet" method="post">
<input type="submit" value="登録"><br>
<input type="hidden" name="action" value="confirm">
<input type="hidden" name="nowid" value="${nowid}">

<input type="hidden" name="name" value=${bean.name}>
<input type="hidden" name="detail" value=${bean.detail}>
<input type="hidden" name="price" value=${bean.price}>
<input type="hidden" name="maxrooms" value=${bean.maxrooms}>

</form>
<a href="/nhk/planInsert.jsp">入力画面に戻る</a>
<a href="/nhk/adminMenu.jsp">メニューに戻る</a>


</body>
</html>