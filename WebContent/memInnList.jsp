<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<jsp:include page="_head.jsp" />
<body>

<div class="card-columns">
<!-- "card-deck"だと、横に並ぶ -->

<c:forEach items="${inns}" var="list">


<div class="card" style="width: 18rem;">
  <svg class="bd-placeholder-img card-img-top" width="100%" height="180" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Image cap">
  <title>Placeholder</title><rect width="100%" height="100%" fill="#868e96"/>
  <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text>
  </svg>

<div class="card-body">

    <h5 class="card-title">ID: ${list.id}<br>
名前：${list.name}<br></h5>
    <p class="card-text">紹介：${list.intro}<br></p>
    <p class="card-text">チェックイン時間：${list.checkin}<br>チェックアウト時間：${list.checkout}<br>電話番号：${list.tel}</p>
    <a href="/nhk/PlanShowServlet?nowid=${list.id}" class="btn btn-primary">プランを見る</a>
  </div>


</div>

</c:forEach>

</div>


<a href="/nhk/memberMenu.jsp">メニューに戻る</a>
<br><br><br>


<jsp:include page="_script.jsp" />

</body>
</html>