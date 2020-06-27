<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>

<jsp:include page="_head.jsp" />

<body>
<br><br>


<div class="container">

<div class ="row justify-content-center">
  <div class="col-7">
<h3>管理者メニュー</h3><br>
<div class="btn-group-vertical" role="group">

<br>
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

</div></div></div></div>



<jsp:include page="_script.jsp" />


</body>
</html>


