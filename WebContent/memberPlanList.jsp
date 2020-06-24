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
<tr><td>プラン名</td><td>内容</td><td>金額</td><td>部屋数</td></tr>

<%-- JSPのコメント
<c:forEach items="${emp}" var="emp">
<tr><td>${emp.code}</td><td>${emp.name}</td><td>${emp.age}</td><td>${emp.tel}</td></tr>
</c:forEach>

--%>
<c:forEach items="${plans}" var="list">
<%-- 「plans」は、受け取るリクエストスコープの名前 --%>
<tr>

<td>${list.name}</td>
<td>${list.detail}</td>
<td>${list.price}</td>
<td>${list.maxrooms}</td>
<td><a href="/nhk/reserveInsert.jsp?PlanId="${list.id}>予約</a><br></td>

<br><br>

</tr>

</c:forEach>

</table>


<a href="/nhk/HotelShowServlet">宿一覧に戻る</a><br>
<a href="/nhk/memberMenu.jsp">メニューへに戻る</a><br>



</body>
</html>