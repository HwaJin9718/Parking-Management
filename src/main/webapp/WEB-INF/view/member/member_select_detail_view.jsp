<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 회원 정보</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/all.min.css">
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/bootstrap-datepicker.js"></script>
<script src="./js/bootstrap-datepicker.ko.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark text-white">
		<div class="container">
			<div class="col-md-6">
				<h1>
					<i class="fas fa-users"></i> 회원 수정
				</h1>
			</div>
			<div id="toggle" class="navbar-collapse collapse">
				<ul class="navbar-nav">
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item dropdown mr-3"><c:if
							test="${!empty sessionScope.member_id}">
							<p class="nav-link dropdown-toggle" data-toggle="dropdown">
								<i class="fas fa-user mr-sm-1"></i> ${sessionScope.member_id} 님
							</p>
						</c:if>
						<div class="dropdown-menu"></div>
				</ul>
				<ul class="navbar-nav py-3 mb-3 pl-3 pr-3">
					<li><a href="./Mainpage.jh" class="navbar-brand"> <i
							class="fa fa-home"></i>홈
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<header id="main-header" class="py-2 bg-secondary"></header>
	<section class="py-3 mb-3 bg-light">
		<div class="container">
			<div class="row col-md-12"></div>
		</div>
	</section>
	<section id="member">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h3 class="text-muted">
								<i class="fas fa-user-shield mr-sm-1"></i> 상세 회원 정보
							</h3>
						</div>

						<div class="card-body">
							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fa fa-plus-square mr-sm-1"></i> 회원 코드</li>
										<li class="list-group-item col-md-5">${memberDTO.member_code}</li>
									</ul>
								</div>
							</div>

							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fas fa-user-check mr-sm-1"></i> 아이디</li>
										<li class="list-group-item col-md-5">${memberDTO.member_id}</li>
									</ul>
								</div>
							</div>

							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fas fa-user-plus mr-sm-1"></i> 이름</li>
										<li class="list-group-item col-md-5">${memberDTO.member_name}</li>
									</ul>
								</div>
							</div>

							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fas fa-unlock-alt mr-sm-1"></i> 비밀번호</li>
										<li class="list-group-item col-md-5">${memberDTO.member_password}</li>
									</ul>
								</div>
							</div>

							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fas fa-envelope-open mr-sm-1"></i> 이메일</li>
										<li class="list-group-item col-md-5">${memberDTO.member_email}</li>
									</ul>
								</div>
							</div>

							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fas fa-unlock-alt mr-sm-1"></i> 전화번호</li>
										<li class="list-group-item col-md-5">${memberDTO.member_callnumber}</li>
									</ul>
								</div>
							</div>

							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fas fa-birthday-cake mr-sm-1"></i> 생일</li>
										<li class="list-group-item col-md-5">${memberDTO.member_birthday}</li>
									</ul>
								</div>
							</div>

							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fas fa-restroom mr-sm-1"></i> 성별</li>
										<c:choose>
											<c:when test="${memberDTO.member_gender == 'm'}">
												<li class="list-group-item col-md-5">남자</li>
											</c:when>
											<c:otherwise>
												<li class="list-group-item col-md-5">여성</li>
											</c:otherwise>
										</c:choose>
									</ul>
								</div>
							</div>

							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fa fa-calendar mr-sm-1"></i> 가입일</li>
										<li class="list-group-item col-md-5">${memberDTO.member_joinday}</li>
									</ul>
								</div>
							</div>

							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fas fa-unlock-alt mr-sm-1"></i> 차량번호1</li>
										<li class="list-group-item col-md-5">${memberDTO.member_car_num1}</li>
									</ul>
								</div>
							</div>
							<c:if test="${!empty memberDTO.member_car_num2}">
								<div class="row">
									<div class="col-11">
										<ul class="list-group list-group-horizontal">
											<li class="list-group-item col-md-2"><i
												class="fas fa-unlock-alt mr-sm-1"></i> 차량번호2</li>
											<li class="list-group-item col-md-5">${memberDTO.member_car_num2}</li>
										</ul>
									</div>
								</div>
							</c:if>
							<c:if test="${!empty memberDTO.member_car_num3}">
								<div class="row">
									<div class="col-11">
										<ul class="list-group list-group-horizontal">
											<li class="list-group-item col-md-2"><i
												class="fas fa-unlock-alt mr-sm-1"></i> 차량번호3</li>
											<li class="list-group-item col-md-5">${memberDTO.member_car_num3}</li>
										</ul>
									</div>
								</div>
							</c:if>
							<div class="row">
								<div class="col-11">
									<ul class="list-group list-group-horizontal">
										<li class="list-group-item col-md-2"><i
											class="fas fa-unlock-alt mr-sm-1"></i> 등급</li>
										<li class="list-group-item col-md-5">${memberDTO.member_rating}</li>
									</ul>
								</div>
							</div>
							<nav class="navbar justify-content-end">
								<button type="button" class="btn btn-outline-secondary mr-sm-1"
									onclick="location.href='./AdminUpdateView.jh?member_code=${memberDTO.member_code}'">
									<i class="fas fa-user-tag mr-sm-1"></i> 회원 수정
								</button>
								<c:if test="${sessionScope.member_id == 'admin'}">
									<button type="button" class="btn btn-outline-success mr-sm-1"
										onclick="location.href='./MemberSelect.jh'">
										<i class="fas fa-users-cog mr-sm-1"></i> 회원 목록
									</button>
								</c:if>
							</nav>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>