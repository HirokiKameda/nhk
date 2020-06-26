<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="_head.jsp" />

<body>
<h4>会員一覧</h4>





<table border="1" class="table">

<thead>
    <tr>
      <th scope="col">NO.</th>
      <th scope="col">名前</th>
      <th scope="col">生年月日</th>
      <th scope="col">電話番号</th>
      <th scope="col">住所</th>
      <th scope="col">メールアドレス</th>
      <th scope="col">パスワード</th>
      <th scope="col"></th>
    </tr>
 </thead>

<c:forEach items="${list}" var="memlist">

<tbody>
<tr>
<td>${memlist.id}</td><td>${memlist.name}</td><td>${memlist.birthday}</td><td>${memlist.address}</td><td>${memlist.tel}</td><td>${memlist.email}</td><td>${memlist.password}</td>

<td>
<form action="/nhk/MemberUpdateServlet" method="post">
<input type="hidden" name="action" value="nyuryoku">
<input type="hidden" name="id" value="${memlist.id}">
<button type="submit" class="btn btn-outline-secondary">変更</button>
</form>

<form action="/nhk/MemberDeleteServlet" method="post">
<input type="hidden" name="action" value="confirm">
<input type="hidden" name="id" value="${memlist.id}">
<button type="submit" class="btn btn-outline-secondary">退会</button>
</form>
</td>

</tr>
</tbody>
</c:forEach>

</table>

<br>



<a href="/nhk/memberMenu.jsp">メニューに戻る</a>


<jsp:include page="_script.jsp" />

</body>
</html>


<!-- bootstrap追加前 -->

<!--

<h1>会員一覧</h1>


<c:forEach items="${list}" var="memlist">

<table border="1">
<tr><td>NO.</td><td>名前</td><td>生年月日</td><td>電話番号</td><td>住所</td><td>メールアドレス</td><td>パスワード</td></tr>

<tr><td>${memlist.id}</td><td>${memlist.name}</td><td>${memlist.birthday}</td><td>${memlist.address}</td><td>${memlist.tel}</td><td>${memlist.email}</td><td>${memlist.password}</td></tr>

</table>

<form action="/nhk/MemberUpdateServlet" method="post">
<input type="hidden" name="action" value="nyuryoku">
<input type="hidden" name="id" value="${memlist.id}">
<input type="submit" value="変更">
</form>
<form action="/nhk/MemberDeleteServlet" method="post">
<input type="hidden" name="action" value="confirm">
<input type="hidden" name="id" value="${memlist.id}">
<input type="submit" value="退会">
</form>

<br>

</c:forEach>

<a href="/nhk/memberMenu.jsp">メニューに戻る</a>


 -->
