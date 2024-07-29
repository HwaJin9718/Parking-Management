<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>결제 정보 관리</title>
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
					<i class="fas fa-users"></i> 결제 정보 관리
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
	<section id="department">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h5>결제 정보 목록</h5>
							</div>
							<div class="card-body">
							<table class="table table-hover"> <thead class="thead-light"> <tr class="text-center">
									<tr>
										<th>결제 코드 번호</th>
										<th>카드번호</th>
										<th>카드사</th>
										<th>결제금액</th>
										<th>결제일</th>
										<th></th>
									</tr>
								</thead>
								<c:forEach var="arrayList" items="${arrayList}">
									<tr class="text-center">
										<td>${arrayList.payment_code}</td>
										<td>${arrayList.payment_card_num}</td>
										<td>${arrayList.payment_card_company}</td>
										<td>${arrayList.payment_total}</td>
										<td>${arrayList.payment_date}</td>
										<td><a
											href="./PaymentSelectDetail.jn?payment_code=${arrayList.payment_code}" class="btn btn-outline-info">
												결제 상세 보기 </a></td>
									</tr>
								</c:forEach>
								<c:if test="${empty arrayList}">
									<tr>
										<td colspan="4">등록된 결제가 없습니다.</td>
									</tr>
								</c:if>
							</table>
							<a href="./PaymentInsertView.jn" class="btn btn-success btn-block"> 결제 정보 입력 </a>
							</div> </div> </div> </div> </div></section>
</body>
</html>