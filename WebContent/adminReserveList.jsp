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




<c:forEach items="${list}" var="reslist">
<table border="1">
<tr><td>ID</td><td>ホテルID</td><td>ホテル名</td><td>プランID</td><td>メンバーID</td><td>予約日</td><td>予約時間</td><td>チェックイン日</td><td>チェックアウト日</td><td>部屋数</td><td>人数</td></tr>

<tr><td>${reslist.id}</td><td>${reslist.hotelId}</td><td>${reslist.hotelname}</td><td>${reslist.planId}</td><td>${reslist.memberId}</td><td>${reslist.reservedate}</td><td>${reslist.reservetime}</td><td>${reslist.checkindate}</td><td>${reslist.checkoutdate}</td><td>${reslist.rooms}</td><td>${reslist.people}</td></tr>

</table>

<br>

</c:forEach>




<a href="/nhk/adminMenu.jsp">メニューに戻る</a><br>




</body>
</html>