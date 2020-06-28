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
				登録内容<br>
				<br>
				<form action="/nhk/MemberInsertServlet" method="post">
					<div class="form-group">
						名前:<input type="text" name="name" class="form-control"
							placeholder="名前">
					</div>

					<div class="form-group">
						生年月日:<input type="text" name="birthday" class="form-control"
							placeholder="生年月日">
					</div>


					<div class="form-group">
						電話番号:<input type="text" name="tel" class="form-control"
							placeholder="電話番号">
					</div>

					<div class="form-group">
						住所:<input type="text" name="address" class="form-control"
							placeholder="住所">
					</div>

					<div class="form-group">
						メールアドレス:<input type="text" name="email" class="form-control"
							placeholder="メールアドレス">
					</div>

					<div class="form-group">
						パスワード:<input type="text" name="password" class="form-control"
							placeholder="パスワード">
					</div>




					<input type="hidden" name="action" value="confirm">
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