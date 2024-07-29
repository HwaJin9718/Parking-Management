<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

request.setCharacterEncoding("UTF-8");

application.log(request.getParameter("coupon_use"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 입력</title>
<c:forEach var="arrayList" items="${arrayList}">

	<c:if test="${arrayList.coupon_code==param.coupon_code}">
		<script type="text/javascript">
			alert("입력하신 ${param.coupon_code}번의 쿠폰 코드 번호가 존재합니다. 다시 입력하세요");
			location.href = "./CouponInsertView.jo";
		</script>
	</c:if>
</c:forEach>
</head>
<body>
사용여부 :
	<% if(request.getParameter("coupon_use").equals("사용가능")) { %>
	사용가능
	<% } else { %>
	이미사용된쿠폰
	<% } %>

	<script type="text/javascript">
		alert("입력하신 ${couponDTO.coupon_code}번의 쿠폰 코드 번호를 등록하였습니다.");
		location.href = "./CouponSelect.jo"
	</script>

</body>
</html>