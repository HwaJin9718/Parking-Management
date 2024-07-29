<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차기록 상세 조회(parking)</title>
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
	
<section id="member">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h3 class="text-muted">
								<i class="fas fa-user-edit mr-sm-1"></i> 주차 상세 기록 조회
							</h3>
						</div>
						<div class="card-body">

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차 기록 코드 : </div>
<span class="col-8 pl-0 form-control">${recordsDTO.records_code}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>차량 번호 : </div>
<span class="col-8 pl-0 form-control">${recordsDTO.member_car_num}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 이름 : </div>
<span class="col-8 pl-0 form-control">${recordsDTO.parking_name}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>입차 시간 : </div>
<span class="col-8 pl-0 form-control">${recordsDTO.records_start}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>출차 시간 : </div>
<span class="col-8 pl-0 form-control">${recordsDTO.records_end}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>결제 요금 : </div>
<div class="col-8 pl-0 input-group">
<div class="form-control">${recordsDTO.payment_total}</div>
<div class="input-group-append">
<span class="input-group-text">원</span></div>
</div>
</div>

<div class="button-container">

<button onclick="location.href = './RecordsSelectParking.hw?parking_code=${recordsDTO.parking_code}&parking_name=${recordsDTO.parking_name}'">주차 기록 목록</button>
<button onclick="location.href = './RecordsUpdate.hw?records_code=${recordsDTO.records_code}'">수정</button>
<button onclick="location.href = './RecordsDelete.hw?records_code=${recordsDTO.records_code}&parking_code=${recordsDTO.parking_code}&parking_name=${recordsDTO.parking_name}'">삭제</button>

</div>
</div>
					</div>
				</div>
			</div>
		</div>
	</section>

<div>

</div>

</body>
</html>