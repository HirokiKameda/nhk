<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register New Hotel</title>
</head>
<body>
登録する宿の情報を入力してください。<br>

<form action="/nhk/HotelInsertServlet" method="post">
名前:<input type="text" name="name"><br>
紹介文:<input type="text" name="intro"><br>
住所:<input type="text" name="address"><br>
チェックイン時間:<input type="text" name="checkin"><br>
チェックアウト時間:<input type="text" name="checkout"><br>
電話:<input type="text" name="tel"><br>
<input type="submit" value="確認画面へ"><br>
<input type="hidden" name="action" value="input">
</form>
<br>
<a href="/nhk/adminMenu.jsp">メニューへに戻る</a>
</body>
</html>
