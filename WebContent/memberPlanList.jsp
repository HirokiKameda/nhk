<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>

<jsp:include page="_head.jsp" />

<body>



	<div class="container">
		<div class="row justify-content-center">

			<div class="row">



				<div class="card-columns">


					<c:forEach items="${plans}" var="list">
						<div class="card" style="{width: '16rem'; height: '20rem'}">



							<div class="card-header">
								<h5>${list.name}</h5>
							</div>
							<div class="card-body">
								<p class="card-text">${list.detail}</p>

								<p class="card-text">
									金額：${list.price}<br>部屋数：${list.maxrooms}
								</p>

							</div>

							<div class="card-body">
								<form action="/nhk/ReserveInsertServlet" method="post">
									<input type="hidden" name="HotelId" value="${nowid}"> <input
										type="hidden" name="PlanId" value="${list.id}">
									<button type="submit" class="btn btn-outline-secondary">予約</button>
								</form>


							</div>





						</div>
					</c:forEach>
				</div>

			</div>
		</div>


		<div class="row">
			<div class="pull-left">
				<a href="/nhk/HotelShowServlet">
					<button type="button" class="btn btn-link">宿一覧に戻る</button>
				</a> <a href="/nhk/memberMenu.jsp">
					<button type="button" class="btn btn-link">メニューに戻る</button>
				</a><br>

			</div>
		</div>
	</div>

	<jsp:include page="_script.jsp" />
</body>
</html>



<!--

<c:forEach items="${plans}" var="list">
<%-- 「plans」は、受け取るリクエストスコープの名前 --%>

<table border="1">
<tr><td>プラン名</td><td>内容</td><td>金額</td><td>部屋数</td></tr>

<tr>

<td>${list.name}</td>
<td>${list.detail}</td>
<td>${list.price}</td>
<td>${list.maxrooms}</td>



</tr>

<!-- <td> -->
<!--  <a href="/nhk/ReserveInsertServlet?PlanId=${list.id}">予約</a><br></td>-->


<!--
</table>

<form action="/nhk/ReserveInsertServlet" method="post">
<input type="hidden" name="HotelId" value="${nowid}">
<input type="hidden" name="PlanId" value="${list.id}">
<input type="submit" value="予約">
</form>


</c:forEach>


<a href="/nhk/HotelShowServlet">宿一覧に戻る</a><br>
<a href="/nhk/memberMenu.jsp">メニューに戻る</a><br>


-->

