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
			<div class="row">


					<div class="card-columns m-6">

						<!-- "card-deck"だと、横に並ぶ columns-->

						<c:forEach items="${inns}" var="list">


							<div class="card" style="{width: '16rem'; height: '24rem'}">
								<img class="card-img-top" width="100%" height="200"
									src="/nhk/upload/${list.url}" alt="Card image cap">
								<title>Placeholder</title>
								<rect width="100%" height="100%" fill="#868e96" />

								<div class="card-body">

									<h5 class="card-title">
										ID: ${list.id}<br> 名前：${list.name}<br>
									</h5>
									<p class="card-text">
										紹介：${list.intro}<br>
									</p>
									<p class="card-text">
										チェックイン時間：${list.checkin}<br>チェックアウト時間：${list.checkout}<br>電話番号：${list.tel}
									</p>
									<a href="/nhk/PlanShowServlet?nowid=${list.id}"
										class="btn btn-outline-primary m-1">プランを見る</a>
								</div>


							</div>

						</c:forEach>
					</div>

			</div>


		</div>




		<div class="row">
			<div class="pull-left">
				<a href="/nhk/memberMenu.jsp">
					<button type="submit" class="btn btn-link">メニューに戻る</button>
				</a>
			</div>
		</div>
	</div>





	<br>
	<br>
	<br>


	<jsp:include page="_script.jsp" />

</body>
</html>