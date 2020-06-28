<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@ include file="_head.jsp"%>
<body>

	<br>
	<br>
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-offset-1">

				<h2>削除する予約</h2>
				<table border="1">
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

				</table>

				<form action="/nhk/ReserveDeleteServlet" method="post">
					<input type="hidden" name="PlanId" value="${PlanId}"> <input
						type="hidden" name="action" value="ok">
					<button type="submit" class="btn btn-primary mt-4 ml-2">削除</button>

				</form>





				<br>
				<br> <a href="/nhk/memberMenu.jsp">メニューに戻る</a> <br>
				<br>
				<br>
			</div>
		</div>
	</div>


	<%@ include file="_script.jsp"%>








</body>
</html>