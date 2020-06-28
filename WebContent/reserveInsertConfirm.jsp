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

	<br>
	<br>
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-offset-1">


				予約情報に間違いがないか確認してください。<br>
				<br> 予約日時:${reservedate}<br> 予約時間:${reservetime}<br>
				チェックイン日:<%=request.getParameter("checkindate")%><br> チェックアウト日:<%=request.getParameter("checkoutdate")%><br>
				人数:<%=request.getParameter("people")%><br>


				<form action="/nhk/ReserveInsertServlet" method="post">
					<input type="hidden" name="action" value="confirm"> <input
						type="hidden" name="reservedate" value="${reservedate}"> <input
						type="hidden" name="reservetime" value="${reservetime}"> <input
						type="hidden" name="checkindate" value="${checkindate}"> <input
						type="hidden" name="checkoutdate" value="${checkoutdate}">
					<input type="hidden" name="people" value="${people}"> <input
						type="hidden" name="PlanId" value="${PlanId}"> <input
						type="hidden" name="HotelId" value="${HotelId}">
					<button type="submit" class="btn btn-primary mt-4 ml-2">予約</button>
				</form>





				<br>
				<br> <a href="/nhk/reserveInsert.jsp">予約画面に戻る</a><br> <a
					href="/nhk/memberMenu.jsp">メニューに戻る</a> <br>
				<br>
				<br>
			</div>
		</div>
	</div>


	<%@ include file="_script.jsp"%>












</body>
</html>