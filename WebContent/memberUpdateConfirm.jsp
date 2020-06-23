<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容確認</title>
</head>
<body>
<h2>変更するメンバー情報</h2>
<table border="1">
<tr><td>NO.</td><td>名前</td><td>生年月日</td><td>電話番号</td><td>住所</td><td>メールアドレス</td><td>パスワード</td></tr>

<tr><td>${member.id}</td><td>${member.name}</td><td>${member.birthday}</td><td>${member.address}</td><td>${member.tel}</td><td>${member.email}</td><td>${member.password}</td></tr>
</table>

<h2>変更後のメンバー情報</h2>
<table border="1">
<tr><td>NO.</td><td>名前</td><td>生年月日</td><td>電話番号</td><td>住所</td><td>メールアドレス</td><td>パスワード</td></tr>

<tr><td>${newmember.id}</td><td>${newmember.name}</td><td>${newmember.birthday}</td><td>${newmember.address}</td><td>${newmember.tel}</td><td>${newmember.email}</td><td>${newmember.password}</td></tr>
</table>


<form action="/nhk/MemberUpdateServlet" method="post">
<input type="hidden" name="action" value="update">
<input type="hidden" name="member" value="${member}">
<input type="hidden" name="newmember" value="${newmember}">
<input type="submit" value="更新">
</form>

<a href="/nhk/memberMenu.jsp">メニューに戻る</a>


</body>
</html>