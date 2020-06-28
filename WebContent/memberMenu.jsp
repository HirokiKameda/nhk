<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<jsp:include page="_head.jsp" />



<body>

	<br>
	<br>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-offset-1">

				<h3>会員様メニュー</h3>
				<br>

<br>
<h3>会員様メニュー</h3>

				<div class="btn-group-vertical" role="group">

					<a href="/nhk/memberUpdate.jsp">
						<button type="button" class="m-1 btn btn-outline-primary"
							style="width: 180px">会員情報変更</button>
					</a> <a href="/nhk/HotelShowServlet">
						<button type="button" class="m-1 btn btn-outline-primary"
							style="width: 180px">予約</button>
					</a>


					<form action="/nhk/MemberDeleteServlet" method="post">
						<input type="hidden" name="action" value="confirm">
						<button type="submit" class="m-1 btn btn-outline-secondary"
							style="width: 180px">会員退会</button>
					</form>

				</div>
			</div>
		</div>
	</div>


	<jsp:include page="_script.jsp" />





</body>
</html>






