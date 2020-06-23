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

入力に間違いがないか確認してください。<br>

プラン内容:<%=request.getParameter("detail") %><br>
金額:<%=request.getParameter("price") %><br>
部屋数:<%=request.getParameter("maxrooms") %><br>

<form action="/nhk/PlanInsertServlet" method="post">
<input type="submit" value="登録"><br>
<input type="hidden" name="action" value="confirm">
</form>
<a href="/nhk/planInsert.jsp">入力画面に戻る</a>
<a href="/nhk/adminMenu.jsp">管理者メニューに戻る</a>


</body>
</html>