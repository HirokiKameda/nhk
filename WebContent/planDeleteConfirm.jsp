<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>



<%@ include file="_head.jsp"%>

<body>

	<br>
	<br>
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-offset-1">


				プラン「${name}」 を削除してもよろしいでしょうか？<br>

				<form action="/nhk/PlanDeleteServlet" method="post">
					<button type="submit" class="btn btn-primary mt-4 ml-2">
						削除</button>
					<br> <input type="hidden" name="action" value="confirm">
					<input type="hidden" name="nowid" value="${nowid}">
				</form>
				<br> <br> <a href="/nhk/adminMenu.jsp">メニューに戻る</a><br>
				<br> <br> <br> <br> <br>
			</div>
		</div>
	</div>


	<%@ include file="_script.jsp"%>


</body>
</html>