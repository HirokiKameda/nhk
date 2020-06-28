<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="_head.jsp"%>
<head>
<meta charset="UTF-8">
<title>Confirm Input</title>
</head>
<body>

	<br>
	<br>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-offset-1">

				入力に間違いがないか確認してください。 <br> 名前:${bean.name} <br>
				紹介文:${bean.intro} <br> 住所:${bean.address} <br>
				チェックイン時間:${bean.checkin} <Br> チェックアウト時間:${bean.checkout} <br>
				電話:${bean.tel} <br> <img width="200px"
					src="/nhk/upload/${bean.url}">

				<form action="/nhk/HotelInsertServlet" enctype="multipart/form-data"
					method="post">
					<button type="submit" value="登録" class="btn btn-primary mt-4 ml-2">登録</button>
					<br> <input type="hidden" name="action" value="confirm">
					<input type="hidden" name="name" value=${bean.name}> <input
						type="hidden" name="intro" value=${bean.intro}> <input
						type="hidden" name="address" value=${bean.address}> <input
						type="hidden" name="checkin" value=${bean.checkin}> <input
						type="hidden" name="checkout" value=${bean.checkout}> <input
						type="hidden" name="tel" value=${bean.tel}> <input
						type="hidden" name="url" value=${bean.url}> <input
						type="hidden" name="action" value="input">

				</form>

				<br><a href="/nhk/innInsert.jsp">入力画面に戻る<br></a>
				<a href="/nhk/adminMenu.jsp">メニューに戻る</a> <br> <br> <br>

			</div>
		</div>
	</div>

	<%@ include file="_script.jsp"%>
</body>
</html>