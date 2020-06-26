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




<div class="container">
<div class="row">
        <div class="center-block">


<div class="card-columns">

<c:forEach items="${plans}" var="list">
<div class="card m-4" style="width: 18rem;">



<div class="card-header">
<h5>${list.name}</h5>
</div>
  <div class="card-body">
      <p class="card-text">${list.detail}</p>

    <p class="card-text">金額：${list.price}<br>部屋数：${list.maxrooms}</p>

  </div>

  <div class="card-body">
  <a href="/nhk/PlanUpdateServlet?nowid=${list.id}">
<button type="button" class="btn btn-outline-primary">プラン変更</button></a>
<a href="/nhk/PlanDeleteServlet?nowid=${list.id}">
<button type="button" class="btn btn-outline-primary">プラン削除</button></a>

</div>


</div>
</c:forEach>
</div>

</div></div>

<div class="row">
<div class="pull-left">
<a href="/nhk/HotelShowServlet">
<button type="button" class="btn btn-link">宿一覧に戻る</button></a>

<a href="/nhk/adminMenu.jsp">
<button type="button" class="btn btn-link">メニューに戻る</button></a><br>

</div></div>

</div>

<!--
ーーーーーーーーーーー

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
-->