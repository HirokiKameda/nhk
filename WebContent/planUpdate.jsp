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

変更するプラン情報を入力してください。<br>
<form action="/nhk/PlanUpdateServlet" method="post">
プラン内容：<input type = text name = "detail"><br>
金額：<input type = number name = "price" ><br>
部屋数：<input type = number name = "maxrooms" ><br>
<input type=submit value="確認画面へ"><br>
<input type="hidden" name="action" value="input">
</form>


<a href="/nhk/adminMenu.jsp">管理者メニューに戻る</a>




</body>
</html>