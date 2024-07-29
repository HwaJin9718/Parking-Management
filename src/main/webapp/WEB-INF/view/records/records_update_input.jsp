<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차 기록 수정(input)</title>
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<style>
/* 버튼 스타일 */
button {
    background-color: #6c757d; /* 헤더의 배경색과 같은색으로 설정 */
    color: white; /* 글자색 흰색으로 설정 */
    border: none; /* 테두리 제거 */
    padding: 10px 20px; /* 버튼 내부 여백 설정 */
    cursor: pointer; /* 커서 모양 변경 */
    margin-bottom: 10px; /* 버튼 아래 여백 설정 */
}

button:hover {
    background-color: #5a6268; /* 호버 상태일 때 배경색 약간 어둡게 변경 */
}

/* 버튼 컨테이너 */
.button-container {
    text-align: left; /* 가운데 정렬 */
    margin-top: 20px; /* 위 여백 설정 */
}
</style>
<script type="text/javascript">

$(function() {
	$("#update").submit(function() {
		
		if(!$("input[name='payment_total']").val()) {
			alert("총 결제 금액을 입력하세요.");
			$("input[name='payment_total']").focus();
			return false;
		}
		
		var regexp_records_payment_total = /^\d+(\,\d+)?$/;
		var records_payment_total_check = $("input[name='payment_total']").val()
		
		if(!regexp_records_payment_total.test(records_payment_total_check)) {
			alert("총 결제 금액이 유효하지 않습니다.\n숫자 및 ,(쉼표)로 구분하여 기재 (ex. 10,000 or 15,000 등)");
			$("input[name='payment_total']").focus();
			return false;
		}
		
		if(records_payment_total_check.length > 10) {
			alert("총 결제 금액은 최대 10자리까지 가능합니다.");
			$("input[name='payment_total']").focus();
			return false;
		}
		
	});
});

</script>

</head>
<body>

<header id="main-header" class="py-2 btn-dark text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>주차 기록 관리</h1>
				</div>
			</div>
		</div>
	</header>
	
<div class="button-container">
<button onclick="location.href ='./Menu.hj'">메뉴로 이동하기</button>
</div>

<section id="member">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h3 class="text-muted">
								<i class="fas fa-user-edit mr-sm-1"></i> 주차 기록 수정
							</h3>
						</div>
						<div class="card-body">

<form action="./RecordsUpdateInput.hw" method="post" name="records_update" id="update">
<fieldset>

<div class="form-group row">
<label for="records_code" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차 기록 코드 번호 : </label>
<div class="col-8 pl-0">
<input type="text" name="records_code" id="records_code" class="form-control" value="${recordsDTO.records_code}" readonly>
</div>
</div>

<div class="form-group row">
<label for="parking_code" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 코드 : </label>
<div class="col-8 pl-0">
<input type="text" name="parking_code" id="parking_code" class="form-control" value="${recordsDTO.parking_code}" readonly>
</div>
</div>

<div class="form-group row">
<label for="parking_name" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 이름 : </label>
<div class="col-8 pl-0">
<input type="text" name="parking_name" id="parking_name" class="form-control" value="${recordsDTO.parking_name}" readonly>
</div>
</div>

<div class="form-group row">
<label for="member_code" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>사용자 코드 : </label>
<div class="col-8 pl-0">
<input type="text" name="member_code" id="member_code" class="form-control" value="${recordsDTO.member_code}" readonly>
</div>
</div>

<div class="form-group row">
<label for="member_car_num" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>차량번호 : </label>
<div class="col-8 pl-0">
<input type="text" name="member_car_num" id="member_car_num" class="form-control" value="${recordsDTO.member_car_num}" readonly>
</div>
</div>

<div class="form-group row">
<label for="records_start" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>입차시간 : </label>
<div class="col-8 pl-0">
<input type="text" name="records_start" id="records_start" class="form-control" value="${recordsDTO.records_start}" readonly>
</div>
</div>

<div class="form-group row">
<label for="records_end" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>출차 시간 : </label>
<div class="col-8 pl-0 form-control">
수정시간으로 자동 입력됩니다.
</div>
</div>

<div class="form-group row">
<label for="payment_total" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>결제 금액 : </label>
<div class="col-8 pl-0 input-group">
<input type="text" name="payment_total" id="payment_total" class="form-control">
<div class="input-group-append">
<span class="input-group-text">원</span>
</div>
</div>
</div>

<nav class="navbar justify-content-end">
<button type="submit" class="btn btn-outline-primary mr-sm-1">
<i class="fas fa-save mr-sm-1"></i> 등록
</button>
<button type="reset" id="clear" class="btn btn-outline-warning mr-sm-1">
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