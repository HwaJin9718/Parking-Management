<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" href="./css/bootstrap-datepicker.css">
<script type="text/javascript" src="./js/jquery-3.5.1.min.js"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/bootstrap-datepicker.js"></script>
<script src="./js/bootstrap-datepicker.ko.js"></script>
<script type="text/javascript">
	$(function() {

		$("#dbidCheck").click(function() {
			var id = $('#member_id').val();
			$.ajax({
				url : './IdCheck.jh',
				type : 'get',
				data : {
					'member_id' : id
				},
				success : function(result) {
					console.log("아이디 값 - " + result);
					if ($.trim(result) == 1) {
						alert("이미 등록된 아이디입니다.");
						$("#member_id").focus();
					} else {
						alert("등록되지 않은 아이디입니다.");
						$('#idCheck').val("1");
						$("#member_name").focus();
					}
				}
			});
		});
		$("input[id='member_id']").on("change", function() {
			$("#idCheck").val(0);
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#join")
				.submit(
						function() {
							if (!$("input[name='member_id']").val()) {
								alert("아이디를 입력하세요.");
								$("input[name='member_id']").focus();
								return false;
							}
							var regexp_member_id = /^[a-zA-Z0-9]{8,20}$/;
							var member_id_check = $("input[name='member_id']")
									.val();
							if (!regexp_member_id.test(member_id_check)) {
								alert("아이디에 공백을 제외한 8~20자만 입력할 수 있습니다.");
								$("input[name='member_id']").focus();
								return false;
							}

							if (!$("input[name='member_password']").val()) {
								alert("비밀번호를 입력하세요.");
								$("input[name='member_password']").focus();
								return false;
							}
							var regexp_member_password = /^[a-zA-Z0-9]{6,20}$/;
							var member_password_check = $(
									"input[name='member_password']").val();
							if (!regexp_member_password
									.test(member_password_check)) {
								alert("비밀번호는 공백을 제외한 6~20자만 입력할 수 있습니다.");
								$("input[name='member_passowrd']").focus();
								return false;
							}

							if (!$("input[name='member_name']").val()) {
								alert("이름을 입력하세요.");
								$("input[name='name']").focus();
								return false;
							}
							var regexp_name = /^[가-힣]{2,4}$/;
							var name_check = $("input[name='member_name']")
									.val();
							if (!regexp_name.test(name_check)) {
								alert("이름은 공백을 제외한 한글 2~4자만 입력할 수 있습니다.");
								$("input[name='member_name']").focus();
								return false;
							}

							if (!$("input[name='member_email']").val()) {
								alert("이메일을 입력하세요.");
								$("input[name='member_email']").focus();
								return false;
							}
							var regexp_member_email = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;
							var member_email_check = $(
									"input[name='member_email']").val();
							if (!regexp_member_email.test(member_email_check)) {
								alert("올바른 이메일 형식이 아닙니다.");
								$("input[name='member_email']").focus();
								return false;
							}

							if (!$("input[name='member_callnumber']").val()) {
								alert("전화번호를을 입력하세요.");
								$("input[name='member_callnumber']").focus();
								return false;
							}
							var regexp_member_callnumber = /^\d{3}-\d{3,4}-\d{4}$/i;
							var member_callnumber_check = $(
									"input[name='member_callnumber']").val();
							if (!regexp_member_callnumber
									.test(member_callnumber_check)) {
								alert("올바른 전화번호 형식이 아닙니다. 예)000-0000-0000");
								$("input[name='member_callnumber']").focus();
								return false;
							}

							if (!$("input[name='member_birthday']").val()) {
								alert("생년월일을 입력하세요.");
								$("input[name='member_birthday']").focus();
								return false;
							}
							var regexp_member_birthday = /^[0-9]{8,8}$/;
							var member_birthday_check = $(
									"input[name='member_birthday']").val();
							if (!regexp_member_birthday
									.test(member_birthday_check)) {
								alert("올바른 생년월일 형식이 아닙니다. 예)19990205");
								$("input[name='member_birthday']").focus();
								return false;
							}

							if (!$("input[name='member_gender']")
									.is(":checked")) {
								alert("성별을 선택해 주세요.");
								$("input[name='member_gender']:eq(0)").focus();
								return false;
							}

							if (!$("input[name='member_car_num1']").val()) {
								alert("차량번호를 입력하세요.");
								$("input[name='member_car_num1']").focus();
								return false;
							}
							var regexp_member_car_num1 = /^[0-9]{2,3}[ㄱ-ㅎ가-힣][0-9]{4}$/;
							var member_car_num1_check = $(
									"input[name='member_car_num1']").val();
							if (!regexp_member_car_num1
									.test(member_car_num1_check)) {
								alert("올바른 차량번호 형식이 아닙니다.");
								$("input[name='member_car_num1']").focus();
								return false;
							}
						});
	});
</script>
</head>
<body>
	<nav class="navbar navbar-expand-md bg-dark navbar-dark text-white">
		<div class="container">
			<div class="col-md-6">
				<h1>
					<i class="fas fa-users"></i> 
					회원 정보 입력
				</h1>
				</div>
					<div id="toggle" class="navbar-collapse collapse">
						<ul class="navbar-nav">
						</ul>
						<ul class="navbar-nav ml-auto">
							<li class="nav-item dropdown mr-3">
							<li class="nav-item">
							<a href="MemberLogin.jh" class="nav-link">
							<i class="fas fa-user-circle mr-sm-1"></i>
									로그인
							</a>
							</li>
						</ul>
						<ul class="navbar-nav py-2 mb-2 pl-3 pr-3">
							<li><a href="./index.jsp" class="navbar-brand">
							<i class="fa fa-home"></i>홈
							</a>
							</li>
						</ul>
					</div>
				</div>
	</nav>
	<header id="main-header" class="py-2 bg-secondary"> </header>
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
								<i class="fas fa-user-edit mr-sm-1"></i> 회원 등록
							</h3>
						</div>
						<div class="card-body">
							<form action="MemberInsert.jh" method="post" id="join" class=""
								enctype="application/x-www-form-urlencoded">
								<fieldset>
									<div class="row pl-1 pr-1">
										<div class="col col-md-5">
											<div class="form-group row">
												<label for="id" class="col-4 col-form-label pr-0"> <i
													class="fas fa-user-check mr-sm-1"></i> 아이디
												</label>
												<div class="col-8 pl-0">
													<div class="row">
														<div class="col-7">
															<input type="text" name="member_id" id="member_id"
																class="form-control">
														</div>
														<div class="pl-0">
															<button type="button" class="btn btn-outline-secondary"
																id="dbidCheck">아이디 체크</button>
															<input type="hidden" name="idCheck" id="idCheck">
														</div>
													</div>
												</div>
											</div>

											<div class="form-group row">
												<label for="password" class="col-4 col-form-label pr-0">
													<i class="fas fa-unlock-alt mr-sm-1"></i> 비밀번호
												</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_password"
														id="member_password" class="form-control">
												</div>
											</div>

											<div class="form-group row">
												<label for="name" class="col-4 col-form-label pr-0">
													<i class="fas fa-user-plus mr-sm-1"></i> 이름
												</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_name" id="member_name"
														class="form-control">
												</div>
											</div>

											<div class="form-group row">
												<label for="email" class="col-4 col-form-label pr-0">
													<i class="fas fa-envelope-open mr-sm-1"></i> 이메일
												</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_email" id="member_email"
														class="form-control">
												</div>
											</div>

											<div class="form-group row">
												<label for="callnumber" class="col-4 col-form-label pr-0">
													<i class="fas fa-envelope-open mr-sm-1"></i> 전화번호
												</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_callnumber"
														id="member_callnumber" class="form-control">
												</div>
											</div>

											<div class="form-group row">
												<label for="birthday" class="col-4 col-form-label pr-0">
													<i class="fas fa-birthday-cake mr-sm-2"></i> 생년월일
												</label>
												<div class="col-8 pl-0">
													<input type="text" name="member_birthday"
														id="member_birthday" class="form-control">
												</div>
											</div>

											<div class="form-group row">
												<label for="gender" class="col-4 col-form-check-label pr-0">
													<i class="fas fa-restroom mr-sm-1"></i> 성별
												</label>
												<div class="col-md-7 form-check form-check-inline text-left">
													남자<input type="radio" name="member_gender"
														id="member_gender" value="m" class="form-check-input">
													여자<input type="radio" name="member_gender"
														id="member_gender" value="f"
														class="ml-sm-3 form-check-input">
												</div>
											</div>

											<div class="form-group row">
												<label for="age" class="col-4 col-form-label pr-0">
													<i class="fas fa-user-clock mr-sm-1"></i> 차량번호
												</label>
												<div class="col-8 pl-0">

													<input type="text" name="member_car_num1"
														id="member_car_num1" class="form-control"> <input
														type="text" name="member_car_num2" id="member_car_num2"
														class="form-control"> <input type="text"
														name="member_car_num3" id="member_car_num3"
														class="form-control">
												</div>
											</div>
										</div>
									</div>
									<nav class="navbar justify-content-end">
										<button type="submit" class="btn btn-outline-primary mr-sm-1">
											<i class="fas fa-save mr-sm-1"></i> 등록
										</button>
										<button type="reset" id="clear"
											class="btn btn-outline-warning mr-sm-1"
											onclick="location.href='./MemberLoginView.jh'">
											<i class="fas fa-share-square mr-sm-1"></i>취소
										</button>
									</nav>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>