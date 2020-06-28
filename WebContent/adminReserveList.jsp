<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<jsp:include page="_head.jsp" />

<body>



	<table border="1" class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">ホテルID</th>
				<th scope="col">ホテル名</th>
				<th scope="col">プランID</th>
				<th scope="col">メンバーID</th>
				<th scope="col">予約日</th>
				<th scope="col">予約時間</th>
				<th scope="col">チェックイン日</th>
				<th scope="col">チェックアウト日</th>
				<th scope="col">部屋数</th>
				<th scope="col">人数</th>
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
		</c:forEach>
	</table>



	<a href="/nhk/adminMenu.jsp">メニューに戻る</a>
	<br>


	<jsp:include page="_script.jsp" />



</body>
</html>