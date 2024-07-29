<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메뉴 페이지</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min_4.5.0.css">
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
    text-align: center; /* 가운데 정렬 */
    margin-top: 20px; /* 위 여백 설정 */
}
</style>
</head>
<body>
<header id="main-header" class="py-2 bg-secondary text-white">
    <div class="container">
        <div class="row align-items-center justify-content-between">
            <div class="col-md-4" align="center">
                <h1>
                    <i class="fas fa-lock-open"></i>메뉴
                </h1>
            </div>
            <div class="col-md-4 d-flex align-items-center">
                <div>
                    ${sessionScope.member_name} (${sessionScope.member_id}) 님
                </div>
            </div>
        </div>
    </div>
</header>

<div class="button-container">
    <button onclick="location.href = './Mainpage.jh'">메인 페이지로 이동</button>
    <button onclick="location.href = './RecordsSelectUser.hw'">주차 기록 확인(사용자)</button>
    <button onclick="location.href='./TicketListDays.hk'">정기권 검색(고객)</button>
    <button onclick="location.href = './PaymentSelect.jn'">결제</button>
    <button onclick="location.href = './FaqSelect.so'">질문 게시판</button>
    <button onclick="location.href = './CommentSelect.so'">댓글</button>
    <c:if test="${sessionScope.member_rating eq 'admin'}">
        <button onclick="location.href='./MemberSelect.jh'">회원정보 조회</button>
    </c:if>
    <c:if test="${sessionScope.member_rating eq 'manager'}">
    <button onclick="location.href = './ParkingSelectAll.hj'">주차장 관리</button>
    </c:if>
    <c:if test="${sessionScope.member_rating eq 'admin'}">
        <button onclick="location.href = './ParkingSelectAdmin.hj'">주차장 및 주차기록 관리(admin)</button>
    </c:if>
    <c:if test="${sessionScope.member_rating eq 'manager' or sessionScope.member_rating eq 'admin'}">
        <c:if test="${sessionScope.member_rating eq 'manager'}">
            <button onclick="location.href = './RecordsSelectParkingCode.hw'">주차 기록 확인(관리자)</button>
        </c:if>
        <button onclick="location.href='./TicketSearch.hk'">정기권 관리(관리자)</button>
        <button onclick="location.href = './CouponSelect.jo'">할인쿠폰</button>
        <button onclick="location.href = './CalculateSearchId.ca'">정산 관리</button>
    </c:if>
    <button onclick="location.href = './NoticeSelect.so'">공지사항</button>
    <button onclick="location.href='./MemberDeleteView.jh'">회원탈퇴</button>
</div>
</body>
</html>
