<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/jquery.cookie.js" type="text/javascript"></script>
<script src="./js/cookie_login.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function MemberLogin() {
		$("#MemberLogin").submit(function() {
			if (!$("input[name='member_id']").val()) {
				alert("아이디를 입력하세요.");
				$("input[name='member_id']").focus();
				return false;
			}

			if (!$("input[name='member_password']").val()) {
				alert("비밀번호를 입력하세요.");
				$("input[name='member_password']").focus();
				return false;
			}
		});
	});
</script>
</head>
<body>
	<header id="main-header" class="py-2 bg-secondary text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6" align="center">
					<h1>
						<i class="fas fa-lock-open"></i>로그인
					</h1>
				</div>
				<div class="col-md-6" align="center">
					<a href="./index.jsp"
						class="navbar-brand py-4 mb-4 pl-6 pr-6 text-white"> <i
						class="fa fa-home"></i>홈
					</a>
				</div>
			</div>
		</div>
	</header>
	<section id="actions" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row"></div>
		</div>
	</section>
	<section id="login">
		<div class="container">
			<div class="row">
				<div class="col-9 mx-auto">
					<div class="card">
						<div class="card-header">
							<h4>ID 로그인</h4>
						</div>
						<div class="card-body">
							<form action="./MemberLogin.jh" method="post" onsubmit="return MemberLogin();" id="MemberLogin" name="MemberLogin" enctype="application/x-www-form-urlencoded">
								<fieldset>
									<div class="form-group">
										<label for="id"><i class="fas fa-user-check mr-sm-1"></i>아이디</label>
										<input type="text" name="member_id" id="member_id" class="form-control" placeholder="아이디">
									</div>
									<div class="form-group">
										<label for="password"><i class="fas fa-user-lock mr-sm-1"></i>비밀번호</label> <input type="password" name="member_password" id="member_password" class="form-control" placeholder="비밀번호">
									</div>
									<div class="form-group">
										<div class="custom-control custom-checkbox">
											<input type="checkbox" name="save" class="custom-control-input" id="save"> <label class="custom-control-label" for="save">로그인 상태 유지</label>
										</div>
									</div>
									<button type="submit" id="register" class="btn btn-info btn-block">로그인</button>
								</fieldset>
							</form>
						</div>
					</div>
				</div>
				<div class="col-9 mx-auto py-3 mb-3">
					<div>
						<span>
							<button type="button" class="btn btn-outline-info" onclick="location.href = 'MemberInsertView.jh'">
								<i class="fas fa-user-plus mr-sm-1"></i>회원가입
							</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>

