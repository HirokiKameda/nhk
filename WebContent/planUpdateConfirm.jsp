<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm chenge data</title>
</head>
<body>


	<%@ include file="_head.jsp"%>
<body>

	<br>
	<br>
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-offset-1">

				変更に間違いがないか確認してください。<br><br> プラン名:${bean.name}<br>
				プラン内容:${bean.detail}<br> 金額:
				<c:if test="${bean.price >= 0}">${bean.price}</c:if>
				<br> 部屋数:
				<c:if test="${bean.maxrooms >= 0}">${bean.maxrooms}</c:if>
				<br>


				<form action="/nhk/PlanUpdateServlet" method="post">
					<button type="submit" class="btn btn-primary mt-4 ml-2">
						変更</button><br> <input
						type="hidden" name="action" value="confirm"> <input
						type="hidden" name="name" value=${bean.name}> <input
						type="hidden" name="detail" value=${bean.detail}> <input
						type="hidden" name="price" value=${bean.price}> <input
						type="hidden" name="maxrooms" value=${bean.maxrooms}> <input
						type="hidden" name="nowid" value="${nowid}">
				</form>


				<br> <br> <a href="/nhk/planUpdate.jsp">入力画面に戻る<br></a> <a
					href="/nhk/adminMenu.jsp">メニューに戻る</a> <br> <br> <br>
			</div>
		</div>
	</div>











	<%@ include file="_script.jsp"%>






</body>
</html>