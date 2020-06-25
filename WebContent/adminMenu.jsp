<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>

<jsp:include page="_head.jsp" />

<body>

<br>
<h3>管理者メニュー</h3>
<a href ="/nhk/innInsert.jsp">
<button type="button" class="btn btn-outline-primary">新規宿登録</button>
</a>

<a href ="/nhk//HotelShowServlet?action=admin">
<button type="button" class="btn btn-outline-primary">宿一覧</button>
</a>

<a href ="/nhk/ReserveShowServlet">
<button type="button" class="btn btn-outline-primary">予約一覧</button>
</a>


<form action="/nhk/MemberShowServlet" method="post">
<input type="hidden" name="list" value="${list}">
<button type="submit" class="btn btn-outline-primary">会員一覧</button>
</form>




<jsp:include page="_script.jsp" />


</body>
</html>



<!-- bootstrap追加前 -->

<!--
<h1>管理者メニュー</h1>
<a href ="/nhk/innInsert.jsp">新規宿登録</a>
<a href ="/nhk//HotelShowServlet?action=admin">宿一覧</a>
<a href ="/nhk/ReserveShowServlet">予約一覧</a>
<form action="/nhk/MemberShowServlet" method="post">
<input type="hidden" name="list" value="${list}">
<input type="submit" value="会員一覧">
</form>

 -->

