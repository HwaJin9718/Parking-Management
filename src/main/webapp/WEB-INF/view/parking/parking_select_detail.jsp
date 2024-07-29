<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차장 상세 조회</title>
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
					<h1>주차장 관리</h1>
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
								<i class="fas fa-user-edit mr-sm-1"></i> 주차장 정보
							</h3>
						</div>
						<div class="card-body">

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 이름 : </div>
<span class="col-8 pl-0 form-control">${parkingDTO.parking_name}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주소 : </div>
<span class="col-8 pl-0 form-control">${parkingDTO.parking_address}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>위도 : </div>
<span class="col-8 pl-0 form-control">${parkingDTO.parking_latitude}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>경도 : </div>
<span class="col-8 pl-0 form-control">${parkingDTO.parking_longitude}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>운영시간 : </div>
<span class="col-8 pl-0 form-control">${parkingDTO.parking_operation}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차장 종류 : </div>
<span class="col-8 pl-0 form-control">
<c:choose>
<c:when test="${parkingDTO.parking_type} == 'public'">공영 주차장</c:when>
<c:otherwise>민영(민간) 주차장</c:otherwise>
</c:choose>
</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>주차 공간 : </div>
<div class="col-8 pl-0 input-group">
<div class="form-control">${parkingDTO.parking_total_spaces}</div>
<div class="input-group-append">
<span class="input-group-text">석</span></div>
</div>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>전기차 충전 가능 여부 : </div>
<span class="col-8 pl-0 form-control">
<c:choose>
<c:when test="${parkingDTO.parking_electriccar_check == 'Y'}">가능</c:when>
<c:otherwise>불가능</c:otherwise>
</c:choose>
</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>전기차 충전 가능 공간 : </div>
<div class="col-8 pl-0 input-group">
<div class="form-control">${parkingDTO.parking_electriccar_spaces}</div>
<div class="input-group-append">
<span class="input-group-text">석</span></div>
</div>
</div>


<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>적용 가능 할인권 : </div>
<span class="col-8 pl-0 form-control">
<c:choose>
<c:when test="${parkingDTO.parking_pay_type == 'R'}">정기권</c:when>
<c:when test="${parkingDTO.parking_pay_type == 'T'}">시간권</c:when>
<c:otherwise>정기권, 시간권</c:otherwise>
</c:choose>
</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>기본요금(1시간) : </div>
<div class="col-8 pl-0 input-group">
<div class="form-control">${parkingDTO.parking_base_fee}</div>
<div class="input-group-append">
<span class="input-group-text">원</span></div>
</div>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>추가 요금(10분 경과 시) : </div>
<div class="col-8 pl-0 input-group">
<div class="form-control">${parkingDTO.parking_hourly_rate}</div>
<div class="input-group-append">
<span class="input-group-text">원</span></div>
</div>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>승인 여부 : </div>
<span class="col-8 pl-0 form-control">
<c:choose>
<c:when test="${parkingDTO.parking_approval eq 'AP'}">승인</c:when>
<c:otherwise>미승인</c:otherwise>
</c:choose>
</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>등록일시 : </div>
<span class="col-8 pl-0 form-control">${parkingDTO.parking_registration}</span>
</div>

<div class="form-group row">
<div class="col-4 col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>수정일시 : </div>
<span class="col-8 pl-0 form-control">${parkingDTO.parking_edit}</span>
</div>


<div class="button-container">
<c:if test="${sessionScope.member_rating eq 'manager'}">
<button onclick="location.href = './ParkingSelectAll.hj'">주차장 목록</button>
</c:if>
<c:if test="${sessionScope.member_rating eq 'admin'}">
<button onclick="location.href = './ParkingSelectAdmin.hj'">주차장 목록</button>
</c:if>
<c:if test="${sessionScope.member_rating eq 'manager'}">
<button onclick="location.href = './ParkingUpdate.hj?parking_code=${parkingDTO.parking_code}'">수정</button>
 <button onclick="location.href = './ParkingDelete.hj?parking_code=${parkingDTO.parking_code}'">삭제</button>
</c:if>
<c:if test="${sessionScope.member_rating eq 'admin'}">
<button onclick="location.href = './ParkingApprove.hj?parking_code=${parkingDTO.parking_code}'">승인</button>
</c:if>
</div>
</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>