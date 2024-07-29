<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>할인권 정보 관리</title>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark text-white">
		<div class="container">
			<div class="col-md-6">
				<h1>
					<i class="fas fa-users"></i> 할인권 정보 관리
				</h1>
			</div>
			<div id="toggle" class="navbar-collapse collapse">
				<ul class="navbar-nav">
				</ul>
				<ul class="navbar-nav py-2 mb-2 pl-3 pr-3">
					<li><a href="./Mainpage.jh" class="navbar-brand"> <i
							class="fa fa-home"></i>홈
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<section class="py-4 mb-4 bg-light"></section>
	<section id="coupon">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h5>할인권 정보 목록</h5>
						</div>
						<div class="card-body">
							<table class="table table-hover">
								<thead class="thead-light">
									<tr class="text-center">
											<thead>
												<tr>
													<th>쿠폰 코드 번호</th>
													<th>쿠폰 종류</th>
													<th>쿠폰 이름</th>
													<th>유효 기간 (시작일)</th>
													<th>유효 기간 (종료일)</th>
													<th>가격</th>
													<th>사용여부</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="arrayList" items="${arrayList}">
												<tr class="text-center">
													<td>${arrayList.coupon_code}</td>
													<td>${arrayList.coupon_type}</td>
													<td>${arrayList.coupon_name}</td>
													<td>${arrayList.coupon_start}</td>
													<td>${arrayList.coupon_end}</td>
													<td>${arrayList.coupon_price}</td>
													<td>${arrayList.coupon_use}</td>
													<td><a
														href="./CouponSelectDetail.jo?coupon_code=${arrayList.coupon_code}" class="btn btn-outline-info">
															쿠폰 상세 보기 </a></td>
												</tr>
											</c:forEach>
											<c:if test="${empty arrayList}">
												<tr>
													<td>등록된 쿠폰이 없습니다.</td>
												</tr>
											</c:if>
										</table>
										<a href="./CouponInsertView.jo" class="btn btn-success btn-block"> 쿠폰 정보 입력 </a>
						</div>
					</div>
				</div>
				</div>
			</div>
	</section>
</body>
</html>