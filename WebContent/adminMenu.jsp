<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>


<jsp:include page="_head.jsp" />


<body>
	<br>
	<br>




	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-offset-1">
				<h3>管理者メニュー</h3>
				<br>

					<div class="btn-group-vertical" role="group">
						<a href="/nhk/innInsert.jsp">
							<button type="button" class="m-1 btn btn-outline-primary"
								style="width: 180px">新規宿登録</button>
						</a> <a href="/nhk//HotelShowServlet?action=admin">
							<button type="button" class="m-1 btn btn-outline-primary"
								style="width: 180px">宿一覧</button>
						</a> <a href="/nhk/ReserveShowServlet">
							<button type="button" class="m-1 btn btn-outline-primary"
								style="width: 180px">予約一覧</button>
						</a>
						<form action="/nhk/MemberShowServlet" method="post">
							<input type="hidden" name="list" value="${list}">
							<button type="submit" class="m-1 btn btn-outline-primary"
								style="width: 180px">会員一覧</button>
						</form>

				</div>
			</div>
		</div>
	</div>



	<jsp:include page="_script.jsp" />
</body>
</html>


