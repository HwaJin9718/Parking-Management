<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> 내 요금 </title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
<header id="main-header" class="py-2 btn-dark text-white">
<div class="container">
<div class="row">
<div class="col-md-6">
<h1> 요금 정산 </h1>
</div>
</div>
</div>
</header>
<section class="py-4 mb-4 bg-light">
</section>
<section id="department">
<div class="container">
<div class="row">
<div class="col-md-12">
<div class="card">
<div class="card-header">
<h5> 정산 목록 </h5>
</div>
<div class="card-body">
<form id="selectForm">
<table class="table table-hover">
<thead class="thead-light">
<tr class="text-center">
<th> 선택 </th>
<th> 사용자 id </th>
<th> 정산 날짜 </th>
<th> 정산 금액 </th>
<th> 정산 상태 </th>

</tr>
</thead>
<tbody>
<c:forEach var="arrayList" items="${arrayList}">
<tr class="text-center">
<td><input type="radio" name="selectedRow" value="${arrayList.calculate_code}"></td>
<td>${arrayList.member_code}</td>
<td>${arrayList.calculate_date}</td>
<td>${arrayList.calculate_amount}원</td>
<td>${arrayList.calculate_status}</td>
</tr>
</c:forEach>
<c:if test="${empty arrayList}">
<tr>
<td colspan="6"> 등록된 정기권이 없습니다. </td>
</tr>
</c:if>
</tbody>
</table>
<div class="text-right"> 
<button type="button" class="btn btn-primary">결제하기</button>
</div>
</form>
</div>
</div>
</div>
</div>
</div>
</section>
</body>
</html>
