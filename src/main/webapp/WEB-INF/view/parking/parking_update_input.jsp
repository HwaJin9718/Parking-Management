<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차장 정보 수정(input)</title>
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
		
		if(!$("input[name='parking_name']").val()) {
			alert("주차장 이름을 입력하세요.");
			$("input[name='parking_name']").focus();
			return false;
		}
		
		var regexp_pk_name = /^[\s\S]{1,100}$/;
		var pk_name_check = $("input[name='parking_name']").val()
		
		if(!regexp_pk_name.test(pk_name_check)) {
			alert("주차장 이름은 공백을 포함한 한글, 영어, 숫자 100byte만 입력할 수 있습니다.");
			$("input[name='parking_name']").focus();
			return false;
		}
		
		if(!$("input[name='parking_address']").val()) {
			alert("주차장 주소을 입력하세요.");
			$("input[name='parking_address']").focus();
			return false;
		}
		
		var regexp_pk_address = /^[\s\S]{1,200}$/;
		var pk_address_check = $("input[name='parking_address']").val()
		
		if(!regexp_pk_address.test(pk_address_check)) {
			alert("주차장 주소는 공백을 포함한 한글, 영어, 숫자 200byte만 입력할 수 있습니다.");
			$("input[name='parking_address']").focus();
			return false;
		}
		
		if(!$("input[name='parking_latitude']").val()) {
			alert("주차장 주소의 위도를 입력하세요.");
			$("input[name='parking_latitude']").focus();
			return false;
		}
		
		var regexp_pk_latitude = /^-?([0-9]|[1-8][0-9]|90)(\.[0-9]{1,15})?$/;
		var pk_latitude_check = parseFloat($("input[name='parking_latitude']").val());
		
		if(!regexp_pk_latitude.test(pk_latitude_check) || pk_latitude_check < -90 || pk_latitude_check > 90) {
			alert("유효하지 않은 위도 입니다.");
			$("input[name='parking_latitudes']").focus();
			return false;
		}
		
		if(!$("input[name='parking_longitude']").val()) {
			alert("주차장 주소의 경도를 입력하세요.");
			$("input[name='parking_longitude']").focus();
			return false;
		}
		
		var regexp_pk_longitude = /^-?([0-9]|[1-9][0-9]|1[0-7][0-9]|180)(\.[0-9]{1,15})?$/;
		var pk_longitude_check = parseFloat($("input[name='parking_longitude']").val());
		
		if(!regexp_pk_longitude.test(pk_longitude_check) || pk_longitude_check < -180 || pk_longitude_check > 180) {
			alert("유효하지 않은 경도 입니다.");
			$("input[name='parking_longitude']").focus();
			return false;
		}
		
		if(!$("input[name='parking_operation']").val()) {
			alert("주차장 운영 시간을 입력하세요.");
			$("input[name='parking_operation']").focus();
			return false;
		}
		
		var regexp_pk_operation = /^\d{2}:\d{2}~\d{2}:\d{2}$/;
		var pk_operation_check = $("input[name='parking_operation']").val()
		
		if(!regexp_pk_operation.test(pk_operation_check)) {
			alert("주차장 운영 시간은 09:00~18:00와 동일한 형식만 입력할 수 있습니다.");
			$("input[name='parking_operation']").focus();
			return false;
		}
		
		var [startTime, endTime] = pk_operation_check.split('~');
		var [startHour, startMinute] = startTime.split(':').map(Number);
	    var [endHour, endMinute] = endTime.split(':').map(Number);
	    
	    if (isNaN(startHour) || isNaN(startMinute) || isNaN(endHour) || isNaN(endMinute) ||
	            startHour < 0 || startHour > 23 || startMinute < 0 || startMinute > 59 ||
	            endHour < 0 || endHour > 24 || endMinute < 0 || endMinute > 59) {
	    	alert("주차장 운영 시간이 유효하지 않습니다.");
			$("input[name='parking_operation']").focus();
	            return false;
	        }
	    
	    var startTotalMinutes = startHour * 60 + startMinute;
	    var endTotalMinutes = endHour * 60 + endMinute;
	    
	    if (startTotalMinutes >= endTotalMinutes) {
	    	alert("주차장 운영 시작 시간은 종료 시간보다 이전 이여야 합니다.");
			$("input[name='parking_operation']").focus();
	        return false;
	    }
	    
	    if(!$("input[name='parking_type']").is(":checked")) {
			alert("주차장 종류를 선택하세요.");
			$("input[name='parking_type']:eq(0)").focus( );
			return false;
		}
	    
	    if(!$("input[name='parking_total_spaces']").val()) {
			alert("주차 공간을 입력하세요.");
			$("input[name='parking_total_spaces']").focus();
			return false;
		}
		
		var regexp_pk_total_spaces = /^[0-9]{1,5}$/;
		var pk_total_spaces_check = $("input[name='parking_total_spaces']").val()
		
		if(!regexp_pk_total_spaces.test(pk_total_spaces_check)) {
			alert("주차 공간은 최대 5자리 숫자만 입력할 수 있습니다.");
			$("input[name='parking_total_spaces']").focus();
			return false;
		}
	    
	    if(!$("input[name='parking_electriccar_check']").is(":checked")) {
			alert("전기차 충전 가능 여부를 선택하세요.");
			$("input[name='parking_electriccar_check']:eq(0)").focus( );
			return false;
		}
	    
	    if(!$("input[name='parking_electriccar_spaces']").val()) {
			alert("전기차 주차 가능 공간을 입력하세요.");
			$("input[name='parking_electriccar_spaces']").focus();
			return false;
		}
		
		var regexp_pk_electriccar_spaces = /^[0-9]{1,5}$/;
		var pk_electriccar_spaces_check = $("input[name='parking_electriccar_spaces']").val()
		
		if(!regexp_pk_electriccar_spaces.test(pk_electriccar_spaces_check)) {
			alert("전기차 주차 공간은 최대 5자리 숫자만 입력할 수 있습니다.");
			$("input[name='parking_electriccar_spaces']").focus();
			return false;
		}
		
		if(!$("input[name='parking_pay_type']").is(":checked")) {
			alert("적용 가능 할인권을 선택하세요.");
			$("input[name='parking_pay_type']:eq(0)").focus( );
			return false;
		}
		
		if(!$("input[name='parking_base_fee']").val()) {
			alert("1시간 당 기본 요금을 입력하세요.");
			$("input[name='parking_base_fee']").focus();
			return false;
		}
		
		var regexp_pk_base_fee = /^\d+(\,\d+)?$/;
		var pk_base_fee_check = $("input[name='parking_base_fee']").val()
		
		if(!regexp_pk_base_fee.test(pk_base_fee_check)) {
			alert("기본 요금이 유효하지 않습니다.\n숫자 및 ,(쉼표)로 구분하여 기재 (ex. 10,000 or 15,000 등)");
			$("input[name='parking_base_fee']").focus();
			return false;
		}
		
		if(pk_base_fee_check.length > 10) {
			alert("기본 요금은 최대 10자리까지 가능합니다.");
			$("input[name='parking_base_fee']").focus();
			return false;
		}
		
		if(!$("input[name='parking_hourly_rate']").val()) {
			alert("10분 경과 시 추가 요금을 입력하세요.");
			$("input[name='parking_hourly_rate']").focus();
			return false;
		}
		
		var regexp_pk_hourly_rate = /^\d+(\,\d+)?$/;
		var pk_hourly_rate_check = $("input[name='parking_hourly_rate']").val()
		
		if(!regexp_pk_hourly_rate.test(pk_hourly_rate_check)) {
			alert("추가 요금이 유효하지 않습니다.\n숫자 및 ,(쉼표)로 구분하여 기재 (ex. 10,000 or 15,000 등)");
			$("input[name='parking_hourly_rate']").focus();
			return false;
		}
		
		if(pk_hourly_rate_check.length > 10) {
			alert("추가 요금은 최대 10자리까지 가능합니다.");
			$("input[name='parking_hourly_rate']").focus();
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
					<h1>주차장 관리</h1>
				</div>
			</div>
		</div>
	</header>
	
<div class="button-container">
<button onclick="location.href ='./ParkingSelectAll.hj'">주차장 목록으로 이동하기</button>
</div>

<section id="member">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h3 class="text-muted">
								<i class="fas fa-user-edit mr-sm-1"></i> 주차장 정보 수정
							</h3>
						</div>
						<div class="card-body">

<form action="./ParkingUpdateInput.hj" method="post" name="parking_update" id="update">
<fieldset>

<div class="form-group row">
<label for="parking_code" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 코드 : </label>
<div class="col-8 pl-0">
<input type="text" name="parking_code" id="parking_code" class="form-control" value="${parkingDTO.parking_code}" readonly>
</div>
</div>

<div class="form-group row">
<label for="parking_name" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 이름 : </label>
<div class="col-8 pl-0">
<input type="text" name="parking_name" id="parking_name" class="form-control" value="${parkingDTO.parking_name}">
</div>
</div>

<div class="form-group row">
<label for="parking_address" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 주소 : </label>
<div class="col-8 pl-0">
<input type="text" name="parking_address" id="parking_address" class="form-control" value="${parkingDTO.parking_address}">
</div>
<div class="col-4"></div>
<div class="col-8 pl-0">
[참고] 도로명 주소로 기재해주세요.
</div>
</div>

<div class="form-group row">
<label for="parking_latitude" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 위도 : </label>
<div class="col-8 pl-0">
<input type="text" name="parking_latitude" id="parking_latitude" class="form-control" value="${parkingDTO.parking_latitude}">
</div>
</div>

<div class="form-group row">
<label for="parking_longitude" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 경도 : </label>
<div class="col-8 pl-0">
<input type="text" name="parking_longitude" id="parking_longitude" class="form-control" value="${parkingDTO.parking_longitude}">
</div>
</div>

<div class="form-group row">
<label for="parking_operation" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>운영시간 : </label>
<div class="col-8 pl-0">
<input type="text" name="parking_operation" id="parking_operation" class="form-control" value="${parkingDTO.parking_operation}">
</div>
<div class="col-4"></div>
<div class="col-8 pl-0">
[참고] ex. 09:00~18:00
</div>
</div>

<div class="form-group row">
<label for="parking_type" class="col-4 col-form-check-label pr-0">
<i class="fas fa-restroom mr-sm-1"></i>주차장 종류 : </label>
<div class="col-md-7 form-check form-check-inline text-left">
<input type="radio" name="parking_type" id="parking_type" value="public" class="form-check-input" <c:if test="${parkingDTO.parking_type eq 'public'}">checked</c:if>>공영
<input type="radio" name="parking_type" id="parking_type" value="private" class="ml-sm-3 form-check-input" <c:if test="${parkingDTO.parking_type eq 'private'}">checked</c:if>>민영
</div>
</div>

<div class="form-group row">
<label for="parking_total_spaces" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차 공간 :</label>
<div class="col-8 pl-0 input-group">
<input type="text" name="parking_total_spaces" id="parking_total_spaces" class="form-control" value="${parkingDTO.parking_total_spaces}">
<div class="input-group-append">
<span class="input-group-text">석</span>
</div>
</div>
</div>

<div class="form-group row">
<label for="parking_electriccar_check" class="col-4 col-form-check-label pr-0">
<i class="fas fa-restroom mr-sm-1"></i>전기차 충전 가능 여부 : </label>
<div class="col-md-7 form-check form-check-inline text-left">
<input type="radio" name="parking_electriccar_check" id="parking_electriccar_check" value="Y" class="form-check-input" <c:if test="${parkingDTO.parking_electriccar_check eq 'Y'}">checked</c:if>>가능
<input type="radio" name="parking_electriccar_check" id="parking_electriccar_check" value="N" class="ml-sm-3 form-check-input" <c:if test="${parkingDTO.parking_electriccar_check eq 'N'}">checked</c:if>>불가능
</div>
</div>

<div class="form-group row">
<label for="parking_electriccar_spaces" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>전기차 충전 가능 공간 : </label>
<div class="col-8 pl-0 input-group">
<input type="text" name="parking_electriccar_spaces" id="parking_electriccar_spaces" class="form-control" value="${parkingDTO.parking_electriccar_spaces}">
<div class="input-group-append">
<span class="input-group-text">석</span>
</div>
</div>
</div>

<div class="form-group row">
<label for="parking_pay_type"  class="col-4 col-form-check-label pr-0">
<i class="fas fa-restroom mr-sm-1"></i>적용 가능 할인권 : </label>
<div class="col-md-7 form-check form-check-inline text-left">
<input type="radio" name="parking_pay_type" id="parking_pay_type" value="R" class="form-check-input" <c:if test="${parkingDTO.parking_pay_type eq 'R'}">checked</c:if>>정기권
<input type="radio" name="parking_pay_type" id="parking_pay_type" value="T" class="ml-sm-3 form-check-input" <c:if test="${parkingDTO.parking_pay_type eq 'T'}">checked</c:if>>시간권
<input type="radio" name="parking_pay_type" id="parking_pay_type" value="RT" class="ml-sm-3 form-check-input" <c:if test="${parkingDTO.parking_pay_type eq 'RT'}">checked</c:if>>모두(정기권, 시간권)
</div>
</div>


<div class="form-group row">
<label for="parking_base_fee" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>1시간 당 기본요금 : </label>
<div class="col-8 pl-0 input-group">
<input type="text" name="parking_base_fee" id="parking_base_fee" class="form-control" value="${parkingDTO.parking_base_fee}">
<div class="input-group-append">
<span class="input-group-text">원</span>
</div>
</div>
<div class="col-4"></div>
<div class="col-8 pl-0">
[참고] 금액은 숫자 및 콤마로 구분하여 기재해주세요. (ex. 10,000 or 15,000 등)
</div>
</div>

<div class="form-group row">
<label for="parking_hourly_rate" class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>10분 over time 시 추가 요금 : </label>
<div class="col-8 pl-0 input-group">
<input type="text" name="parking_hourly_rate" id="parking_hourly_rate" class="form-control" value="${parkingDTO.parking_hourly_rate}">
<div class="input-group-append">
<span class="input-group-text">원</span>
</div>
</div>
<div class="col-4"></div>
<div class="col-8 pl-0">
[참고] 금액은 숫자 및 콤마로 구분하여 기재해주세요. (ex. 10,000 or 15,000 등)
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