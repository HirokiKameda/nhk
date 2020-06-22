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


</table>


<a href="/nhk/innList.jsp">宿一覧に戻る</a><br>
<a href="/nhk/adminMenu.jsp">メニューへに戻る</a><br>



</body>
</html>