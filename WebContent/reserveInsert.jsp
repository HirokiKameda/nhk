<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<%@ include file="_head.jsp"%>

<body>

	<br>
	<br>
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-offset-1">

				予約情報を入力してください。<br><br>

				<form action="/nhk/ReserveInsertServlet" method="post">
					<div class="form-group">
						チェックイン日：<input type="date" name="checkindate" class="form-control"><br>
					</div>

					<div class="form-group">
						チェックアウト日：<input type="date" name="checkoutdate"
							class="form-control"><br>
					</div>

					<div class="form-group">
						人数：<input type="number" name="people" class="form-control"><br>
					</div>

					<input type="hidden" name="action" value="input"> <input
						type="hidden" name="PlanId" value="${PlanId}"> <input
						type="hidden" name="HotelId" value="${HotelId}">
					<button type="submit" class="btn btn-primary mt-4 ml-2">確認画面へ</button>
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