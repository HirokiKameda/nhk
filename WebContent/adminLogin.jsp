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
  <div class ="col-md-offset-1">

<h3>管理者ログイン</h3>
<div class ="row">
  <div class ="col-md-10">
<form class="p-4" action="/nhk/MemberLoginServlet" method="post">
  <div class="form-group">


    <label for="exampleDropdownFormUserName">User name</label>
    <input class="form-control" type="text" name="username" id="exampleDropdownFormUserName" placeholder="User name">
  </div>
  <div class="form-group">
    <label for="exampleDropdownFormPassword2">Password</label>
    <input class="form-control" type="password" name="password" id="exampleDropdownFormPassword" placeholder="Password">
  </div>
  <input type="hidden" name="usertype" value="admin">
  <button type="submit" value="login" class="btn btn-primary">Login</button>
</form>
</div></div>

<c:if test="${isLogin eq 1}">
ユーザ名もしくはパスワードが間違っています。
</c:if>

</div></div></div>



<jsp:include page="_script.jsp" />

</body>
</html>


<!-- bootstrap追加前 -->
<!--
<h1>管理者ログイン</h1>

<form action="/nhk/MemberLoginServlet" method="post">
user:<input type="text" name="username"><br>
password:<input type="text" name="password"><br>
<input type="hidden" name="usertype" value="admin">
<input type="submit" value="login">
</form>


<c:if test="${isLogin eq 1}">
ユーザ名もしくはパスワードが間違っています。
</c:if>



 -->





