<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更新内容確認</title>
</head>
<body>
<form action="/nhk/MemberUpdateServlet" method="post">
<input type="hidden" name="action" value="update">
<input type="hidden" name="member" value="${member}">
<input type="submit" value="更新">
</form>


</body>
</html>