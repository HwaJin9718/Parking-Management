<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#update").submit(function() {
							if (!$("input[name='member_rating']").val()) {
								alert("등급을 입력하세요.");
								$("input[name='member_rating']").focus();
								return false;
							}
							var regexp_member_rating = /^(user|meneger|admin)$/;
							var member_rating_check = $("input[name='member_rating']").val();
							if (!regexp_member_rating.test(member_rating_check)) {
								alert("올바른 등급 형식이 아닙니다. 예) user, meneger, admin");
								$("input[name='member_rating']").focus();
								return false;
							}
						});
	});
</script>
</head>
<body>
	<section>
		<nav class="navbar navbar-expand-md bg-dark navbar-dark text-white">
			<div class="container">
				<div class="col-md-6">
					<h1>
						<i class="fas fa-users"></i> 회원 정보 수정
					</h1>
				</div>
				<div id="toggle" class="navbar-collapse collapse">
					<ul class="navbar-nav">
					</ul>
					<ul class="navbar-nav py-2 mb-2 pl-3 pr-3">
						<li><a href="./Mainpage.jh" class="navbar-brand"> <i class="fa fa-home"></i>홈
						</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</section>
	<section id="member">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h3 class="text-muted">
								<i class="fas fa-user-edit mr-sm-1"></i> 회원 수정
							</h3>
						</div>
						<div class="card-body">
							<form action="AdminUpdate.jh" method="post" id="update" class=""
								enctype="application/x-www-form-urlencoded">
								<fieldset>
									<div class="row pl-1 pr-1">
										<div class="col col-md-5">
											<div class="form-group row">
												<label for="code" class="col-4 col-form-label pr-0">
													<i class="fas fa-user-check mr-sm-1"></i> 회원코드
												</label>
												<div class="col-8 pl-0">
													<div class="row">
														<div class="col-7">
															<input type="text" name="member_code" id="member_code"
																class="form-control" value="${param.member_code}"
																readonly>
														</div>
													</div>
												</div>
											</div>
											<div class="form-group row">
												<label for="member_rating" class="col-4 col-form-label pr-0">
													<i class="fas fa-envelope-open mr-sm-1"></i> 등급
												</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_rating" id="member_rating"
														class="form-control">
												</div>
											</div>
										</div>
									</div>
									<nav class="navbar justify-content-end">
										<button type="submit" class="btn btn-outline-primary mr-sm-1">
											<i class="fas fa-save mr-sm-1"></i> 수정
										</button>
										<button type="reset" id="clear"
											class="btn btn-outline-warning mr-sm-1"
											onclick="location.href='./Mainpage.jh'">
											<i class="fas fa-share-square mr-sm-1"></i>취소
										</button>
									</nav>
								</fieldset>
							</form>
							<button onclick="location.href='./Mainpage.jh'">메인페이지로
								돌아가기</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>