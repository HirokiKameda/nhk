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