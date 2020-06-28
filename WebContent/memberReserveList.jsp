<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="_head.jsp"%>
<body>

	<table border="1" class="table">
		<thead>



			<tr>
				<td>ID</td>
				<td>ホテルID</td>
				<td>ホテル名</td>
				<td>プランID</td>
				<td>メンバーID</td>
				<td>予約日</td>
				<td>予約時間</td>
				<td>チェックイン日</td>
				<td>チェックアウト日</td>
				<td>部屋数</td>
				<td>人数</td>
			</tr>

		</thead>

		<c:forEach items="${list}" var="reslist">
			<tbody>
				<tr>
					<td>${reslist.id}</td>
					<td>${reslist.hotelId}</td>
					<td>${reslist.hotelname}</td>
					<td>${reslist.planId}</td>
					<td>${reslist.memberId}</td>
					<td>${reslist.reservedate}</td>
					<td>${reslist.reservetime}</td>
					<td>${reslist.checkindate}</td>
					<td>${reslist.checkoutdate}</td>
					<td>${reslist.rooms}</td>
					<td>${reslist.people}</td>
				</tr>
			</tbody>


			<form action="/nhk/ReserveDeleteServlet" method="post">
				<input type="hidden" name="HotelId" value="${nowid}"> <input
					type="hidden" name="PlanId" value="${reslist.id}"> <input
					type="hidden" name="action" value="delete">
				<button type="submit" class="btn btn-primary mt-4 ml-2">削除</button>

			</form>
		</c:forEach>
	</table>

	<br>
	<br>


	<a href="/nhk/memberMenu.jsp">メニューに戻る</a>
	<br>
	<br>
	<br>

	<%@ include file="_script.jsp"%>
</body>
</html>