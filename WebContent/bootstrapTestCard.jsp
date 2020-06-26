<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<jsp:include page="_head.jsp" />
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="card" style="width: 18rem;">
  <svg class="bd-placeholder-img card-img-top" width="100%" height="180" xmlns="http://www.w3.org/2000/svg" preserveAspectRatio="xMidYMid slice" focusable="false" role="img" aria-label="Placeholder: Image cap"><title>Placeholder</title><rect width="100%" height="100%" fill="#868e96"/><text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text></svg>
  <div class="card-body">
    <h5 class="card-title">ホテル湯の里</h5>
    <p class="card-text">おいしい和食と天然温泉</p>
    <a href="#" class="btn btn-primary">プランを見る</a>
  </div>
</div>


<table class="table">
<%-- プラン一覧表の列名 --%>
<thead>
    <tr>
      <th scope="col">プラン名</th>
      <th scope="col">内容</th>
      <th scope="col">金額</th>
      <th scope="col">部屋数</th>
    </tr>
 </thead>
<tbody>
    <tr>

      <td>Aプラン</td>
      <td>おいしい和食</td>
      <td>10000</td>
      <td>10</td>

    </tr>
</tbody>
</table>

<jsp:include page="_script.jsp"></jsp:include>
</body>
</html>