<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<jsp:include page="_head.jsp" />

<body>

<br><br>


<div class="container">



<div class ="row justify-content-center">
  <div class ="col-md-6 col-md-offset-1">

<h3>会員様ログイン</h3>
<div class ="row">
  <div class ="col-md-4">
<form class="p-4" action="/nhk/MemberLoginServlet" method="post">
  <div class="form-group">


    <label for="exampleDropdownFormUserName">Email address</label>
    <input class="form-control" type="text" name="email" id="exampleDropdownFormUserName" placeholder="email@example.com">
  </div>
  <div class="form-group">
    <label for="exampleDropdownFormPassword2">Password</label>
    <input class="form-control" type="text" name="password" id="exampleDropdownFormPassword" placeholder="Password">
  </div>
  <input type="hidden" name="usertype" value="member">
  <button type="submit" value="login" class="btn btn-primary">Login</button>
</form>
</div></div>

<c:if test="${isLogin eq 1}">
メールアドレスもしくはパスワードが間違っています。
</c:if>
<br>



<a href="/nhk/memberInsert.jsp">新規会員登録</a>
<br><br><br>


</div></div></div>

<jsp:include page="_script.jsp" />

</body>
</html>



<!-- bootstrap追加前 -->

<!--
<h1>会員様ログイン</h1>

<form action="/nhk/MemberLoginServlet" method="post">
Email:<input type="text" name="email"><br>
password:<input type="text" name="password"><br>
<input type="hidden" name="usertype" value="member">
<input type="submit" value="login">
</form>


<c:if test="${isLogin eq 1}">
メールアドレスもしくはパスワードが間違っています。
</c:if>

<a href="/nhk/memberInsert.jsp">新規会員登録</a>



 -->
