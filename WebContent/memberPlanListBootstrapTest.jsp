<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>

<jsp:include page="_head.jsp" />

<body>



<div class="card-columns">
<c:forEach var="i" begin="1" end="6" step="1">
<div class="card" style="width: 18rem;">



<div class="card-header">
<h5>Aプラン</h5>
</div>
  <div class="card-body">
      <p class="card-text">おいしい和食</p>

    <p class="card-text">金額：10000<br>部屋数：10</p>

  </div>
<ul class="list-group list-group-flush">
    <li class="list-group-item">
        <a href="/nhk/reserveInsert.jsp?PlanId="${list.id}" class="card-link">予約する</a>
    </li>
  </ul>


</div>
</c:forEach>

</div>



<table class="table">
<%-- プラン一覧表の列名 --%>
<thead>
    <tr>
      <th scope="col">プラン名</th>
      <th scope="col">内容</th>
      <th scope="col">金額</th>
      <th scope="col">部屋数</th>
    </tr>
 </thead>
<tbody>
    <tr>

      <td>Aプラン</td>
      <td>おいしい和食</td>
      <td>10000</td>
      <td>10</td>

    </tr>
</tbody>
</table>










<table border="1">
<tr><td>プラン名</td><td>内容</td><td>金額</td><td>部屋数</td></tr>




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


<a href="/nhk/HotelShowServlet">
<button type="button" class="btn btn-outline-primary">宿一覧に戻る</button></a>

<a href="/nhk/memberMenu.jsp">
<button type="button" class="btn btn-outline-primary">メニューへに戻る</button></a><br>


<jsp:include page="_script.jsp" />

</body>
</html>