<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차기록 전체 조회(parking)</title>
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
	
<div class="button-container">
<button onclick="location.href ='./Menu.hj'">메뉴</button>
<button onclick="location.href ='./RecordsInsertInput.hw?parking_code=${parking_code}&parking_name=${parking_name}'">주차 기록 등록</button>
</div>

<section class="py-4 mb-4 bg-light"></section>
	<section id="department">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h5>주차 기록 조회</h5>
						</div>
						<div class="card-body">

<table class="table table-hover">

<thead class="thead-light">
<tr class="text-center">
<th>주차장 코드 번호</th>
<th>주차 기록 코드 번호</th>
<th>차량 번호</th>
<th>입차 시간</th>
<th>출차 시간</th>
<th></th>
</tr>
</thead>

<tbody>

<c:forEach var="arrayList" items="${arrayList}">
<tr class="text-center">
<td>${parking_code}</td>
<td>${arrayList.records_code}</td>
<td>${arrayList.member_car_num}</td>
<td>${arrayList.records_start}</td>
<td>${arrayList.records_end}</td>
<td><a href="./RecordsSelectDetailParking.hw?records_code=${arrayList.records_code}">상세 정보 보기</a></td>
</tr>
</c:forEach>

<c:if test="${empty arrayList}">
<tr>
<td colspan="4">등록된 주차장이 없습니다.</td>
</tr>
</c:if>

</tbody>

</table>
<div></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>