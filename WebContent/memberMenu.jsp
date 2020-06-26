<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<jsp:include page="_head.jsp" />


<body>



<br>
<h3>会員様メニュー</h3>


<a href ="/nhk/memberUpdate.jsp">
<button type="button" class="btn btn-outline-primary">会員情報変更</button>
</a>

<a href ="/nhk/HotelShowServlet">
<button type="button" class="btn btn-outline-primary">予約</button>
</a>


<form action="/nhk/MemberDeleteServlet" method="post">
<input type="hidden" name="action" value="confirm">
<button type="submit" class="btn btn-outline-secondary">会員退会</button>
</form>




<jsp:include page="_script.jsp" />





</body>
</html>




<!-- bootstrap追加前 -->

<!--
<h1>会員メニュー</h1>
<a href ="/nhk/memberUpdate.jsp">会員情報変更</a>
<a href ="/nhk/HotelShowServlet">予約</a>
<a href ="/nhk/ReserveShowServlet">予約履歴</a>
<form action="/nhk/MemberDeleteServlet" method="post">
<input type="hidden" name="action" value="confirm">
<input type="submit" value="会員退会">
</form>

 -->

