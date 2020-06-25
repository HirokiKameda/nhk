<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List INN data</title>
</head>
<body>

<c:forEach items="${inns}" var="list">


ID: ${list.id}<br>
名前：${list.name}<br>
紹介：${list.intro}<br>
住所：${list.address}<br>
 チェックイン時間：${list.checkin} チェックアウト時間：${list.checkout} 電話番号：${list.tel}
<br>

<a href="/nhk/PlanShowServlet?nowid=${list.id}">プランを見る</a>

<br>
</c:forEach>
<br>
<a href="/nhk/memberMenu.jsp">メニューへに戻る</a>
</body>
</html>