<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<jsp:include page="_head.jsp" />

<body>


<h3>管理者ログイン</h3>
<div class ="row">
  <div class ="col-md-4">
<form class="p-4" action="/nhk/MemberLoginServletBootstrapTest" method="post">
  <div class="form-group">


    <label for="exampleDropdownFormEmail2">User name</label>
    <input class="form-control" type="text" name="username">
  </div>
  <div class="form-group">
    <label for="exampleDropdownFormPassword2">Password</label>
    <input class="form-control" type="text" name="password">
  </div>
  <input type="hidden" name="usertype" value="admin">
  <button type="submit" value="login" class="btn btn-primary">Login</button>
</form>
</div></div>

<c:if test="${isLogin eq 1}">
ユーザ名もしくはパスワードが間違っています。
</c:if>


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

  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="dropdownCheck2">
    <label class="form-check-label" for="dropdownCheck2">
      Remember me
    </label>
  </div>



 -->



<jsp:include page="_script.jsp" />

</body>
</html>