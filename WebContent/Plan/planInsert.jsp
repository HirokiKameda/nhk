<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

プラン情報（変更前）<br><br>

プラン情報（変更前）<br>
<form action="/nhk/PlanInsertServlet" method="post">
変更内容を入力してください<br>
内容：<input type = text name = "detail"><br>
金額：<input type = number name = "price" ><br>
部屋数：<input type = number name = "rooms" ><br>
<input type=submit value="変更する"><br>
</form>

<%-- JSPのコメント

<a href="/jmaster-gradle/ItemServlet">キャンセル</a>

--%>



</body>
</html>