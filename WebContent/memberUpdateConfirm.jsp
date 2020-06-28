<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容確認</title>
</head>



<%@ include file="_head.jsp"%>
<body>

	<br>
	<br>
	<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-offset-1">


				<h2>変更するメンバー情報</h2>
				<table border="1" class="table">

					<thead>
						<tr>
							<td>NO.</td>
							<td>名前</td>
							<td>生年月日</td>
							<td>電話番号</td>
							<td>住所</td>
							<td>メールアドレス</td>
							<td>パスワード</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${member.id}</td>
							<td>${member.name}</td>
							<td>${member.birthday}</td>
							<td>${member.address}</td>
							<td>${member.tel}</td>
							<td>${member.email}</td>
							<td>${member.password}</td>
						</tr>
					</tbody>
				</table>

				<h2>変更後のメンバー情報</h2>
				<table border="1" class="table">

					<thead>
						<tr>
							<td>NO.</td>
							<td>名前</td>
							<td>生年月日</td>
							<td>電話番号</td>
							<td>住所</td>
							<td>メールアドレス</td>
							<td>パスワード</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${newmember.id}</td>
							<td>${newmember.name}</td>
							<td>${newmember.birthday}</td>
							<td>${newmember.address}</td>
							<td>${newmember.tel}</td>
							<td>${newmember.email}</td>
							<td>${newmember.password}</td>
						</tr>
					</tbody>
				</table>


				<form action="/nhk/MemberUpdateServlet" method="post">
					<input type="hidden" name="action" value="update">

					<!-- <input type="hidden" name="member" value="${member}">
<input type="hidden" name="newmember" value="${newmember}"> -->

					<input type="hidden" name="name" value="${name}"> <input
						type="hidden" name="birthday" value="${birthday}"> <input
						type="hidden" name="tel" value="${tel}"> <input
						type="hidden" name="address" value="${address}"> <input
						type="hidden" name="email" value="${email}"> <input
						type="hidden" name="password" value="${password}">

					<button type="submit" class="btn btn-primary mt-4 ml-2">更新</button>

				</form>



				<br> <br> <a href="/nhk/memberMenu.jsp">メニューに戻る</a> <br>
				<br> <br>
			</div>
		</div>
	</div>


	<%@ include file="_script.jsp"%>












</body>
</html>