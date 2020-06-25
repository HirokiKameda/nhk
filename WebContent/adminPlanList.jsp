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


<table border="1">
<%-- プラン一覧表の列名 --%>
<tr>
<td>プラン名</td>
<td>内容</td>
<td>金額</td>
<td>部屋数</td>
</tr>


<c:forEach items="${plans}" var="list">
<%-- 「plans」は、受け取るリクエストスコープの名前 --%>
<tr>

<td>${list.name}</td>
<td>${list.detail}</td>
<td>${list.price}</td>
<td>${list.maxrooms}</td>
<td><a href="/nhk/PlanUpdateServlet?nowid=${list.id}">プラン変更</a></td>
<td><a href="/nhk/PlanDeleteServlet?nowid=${list.id}">プラン削除</a></td>

<br><br>

</tr>
</c:forEach>
</table>


<a href="/nhk/HotelShowServlet">宿一覧に戻る</a><br>
<a href="/nhk/adminMenu.jsp">メニューに戻る</a><br>


</body>
</html>