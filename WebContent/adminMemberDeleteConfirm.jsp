<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>退会確認</title>
</head>
<%@ include file="_head.jsp"%>
<body>

	<br>
	<br>
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-offset-1">

				<h2>退会される会員情報</h2>
				<table border="1">
					<tr>
						<td>名前</td>
						<td>生年月日</td>
						<td>電話番号</td>
						<td>住所</td>
						<td>メールアドレス</td>
						<td>パスワード</td>
					</tr>

					<tr>
						<td>${name}</td>
						<td>${birthday}</td>
						<td>${address}</td>
						<td>${tel}</td>
						<td>${email}</td>
						<td>${password}</td>
					</tr>
				</table>

				<form action="/nhk/MemberDeleteServlet" method="post">
					<input type="hidden" name="id" value="${id}"> <input
						type="hidden" name="action" value="delete">
					<button type="submit" class="btn btn-primary mt-4 ml-2">退会</button>
				</form>







				<br> <br> <a href="/nhk/adminMenu.jsp">メニューに戻る</a> <br>
				<br> <br>
			</div>
		</div>
	</div>


	<%@ include file="_script.jsp"%>








</body>
</html>