<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차관리</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<style>
form {
	text-align: center;
	margin-top: 10px;
}

.button-container {
	text-align: left;
	margin-top: 10px;
}

.button-container button {
	margin-right: 10px;
	background-color: black; /* 배경색 검정색으로 설정 */
	color: white; /* 글자색 흰색으로 설정 */
	border: none; /* 테두리 제거 */
	padding: 5px 10px; /* 버튼 내부 여백 설정 */
	cursor: pointer; /* 커서 모양 변경 */
}

.button-container button:hover {
	background-color: #333; /* 호버 상태일 때 배경색 약간 어둡게 변경 */
}
</style>
</head>
<body>
<header id="main-header" class="py-2 bg-secondary text-white">
    <div class="container">
        <div class="row align-items-center justify-content-between">
            <div class="col-md-4" align="center">
                <h1>
                    <i class="fas fa-lock-open"></i>메인화면
                </h1>
            </div>
            <div class="col-md-4 d-flex align-items-center">
                <div>
                    ${sessionScope.member_name} (${sessionScope.member_id}) 님
                </div>
                <div>
                    <button onclick="location.href='./MemberUpdateView.jh'"
                            style="padding: 5px 10px; font-size: 14px; background-color: transparent; border: none; color: white;">
                        <i class="fa fa-user"></i> 내정보 수정
                    </button>
                </div>
            </div>
            <div class="col-md-4 d-flex justify-content-end align-items-center">
                <div>
                    <button onclick="location.href='./MemberLogout.jh'"
                            style="padding: 5px 10px; font-size: 14px; background-color: transparent; border: none; color: white;">
                        <i class="fa fa-sign-out-alt"></i> 로그아웃
                    </button>
                </div>
            </div>
        </div>
    </div>
</header>
	<div class="button-container">
		<button onclick="location.href='./Menu.hj'">메뉴</button>
	</div>

	<div>
		<form id="searchForm" action="./ParkingSearch.yh" method="get">
			<input type="text" name="keyword" id="keyword" placeholder="장소 검색">
			<button type="submit" id="submitBtn">검색</button>
		</form>
	</div>

	<div style="position: fixed; bottom: 10px; left: 10px;">
		<button onclick="location.href='./TermSelect.so'">이용약관</button>
	</div>

</body>
</html>
