<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차 기록 삭제 요청</title>
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
								<i class="fas fa-user-edit mr-sm-1"></i> 주차 기록 삭제 요청
							</h3>
						</div>
						<div class="card-body">
						
<div class="form-group row">
<div class="col-form-label pr-0">
<i class="fas fa-user-plus mr-sm-1"></i>${param.records_code}번의 주차 기록을 삭제하시겠습니까?</div>
</div>

<nav class="navbar justify-content-end">
<button class="btn btn-outline-primary mr-sm-1" 
onclick="location.href = './RecordsDeleteProcess.hw?records_code=${param.records_code}&parking_code=${param.parking_code}&parking_name=${param.parking_name}'">
<i class="fas fa-save mr-sm-1"></i> 삭제
</button>
<button id="clear" class="btn btn-outline-warning mr-sm-1"
onclick="location.href = './RecordsSelectParking.hw?parking_code=${param.parking_code}&parking_name=${param.parking_name}'">
<i class="fas fa-share-square mr-sm-1"></i>취소
</button>
</nav>

</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>