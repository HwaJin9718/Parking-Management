<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 체크</title>
</head>
<body>

<c:choose>
<c:when test="${memberDTO.member_code == 0}">
<script type="text/javascript">
alert("가입되지 않은 아이디 입니다.");
location.href = "./MemberLoginView.jh";
</script>
</c:when>

<c:when test="${memberDTO.member_code != 0 and memberDTO.member_password != param.member_password}">
<script type="text/javascript">
alert("비밀번호가 맞지 않습니다.");
location.href = "./MemberLoginView.jh";
</script>
</c:when>

<c:otherwise>
<script type="text/javascript">
alert("로그인이 완료되었습니다.");
location.href = "./Mainpage.jh";
</script>
</c:otherwise>
</c:choose>

</body>
</html>