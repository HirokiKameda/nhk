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

	<%@ include file="_head.jsp"%>
<body>

	<br>
	<br>
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-offset-1">

				変更するプラン情報を入力してください。<br><br>
				<form action="/nhk/PlanUpdateServlet" method="post">

					<div class="form-group">
						プラン名：<input type=text name="name" class="form-control"
							placeholder="名前">
					</div>

					<div class="form-group">
						プラン内容：<input type=text name="detail" class="form-control"
							placeholder="プラン内容">
					</div>


					<div class="form-group">
						金額：<input type=number name="price" class="form-control"
							placeholder="金額">
					</div>

					<div class="form-group">
						部屋数：<input type=number name="maxrooms" class="form-control"
							placeholder="部屋数">
					</div>


					<button type="submit" class="btn btn-primary mt-4 ml-2">
						確認画面へ</button>
					<br> <input type="hidden" name="action" value="input">
					<input type="hidden" name="nowid" value="${nowid}">
				</form>


				<br> <br> <a href="/nhk/adminMenu.jsp">メニューに戻る</a> <br>
				<br> <br>
			</div>
		</div>
	</div>











	<%@ include file="_script.jsp"%>






</body>
</html>