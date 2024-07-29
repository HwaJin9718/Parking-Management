<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>결제 정보 입력</title>
<link rel="stylesheet" type="text/css"
	href="./css/bootstrap.min_4.5.0.css">
<link rel="stylesheet" type="text/css" href="./css/global.css">
<script src="./js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script src="./js/bootstrap.min_4.5.0.js" type="text/javascript"></script>
<script src="./js/jquery.validate.min.js" type="text/javascript"></script>
<script src="./js/dept_validity.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#sign_payment").submit(function() {

			// PAYMENT_CARD_NUM 유효성 검사
			var cardNum = $("input[name='payment_card_num']").val();
			if (!cardNum) {
				alert("카드번호를 입력하세요.");
				$("input[name='payment_card_num']").focus();
				return false;
			} else if (!/^\d{4}-\d{4}-\d{4}-\d{4}$/.test(cardNum)) {
				alert("카드번호는 '-'가 포함된 숫자 16자리를 입력해주세요.");
				$("input[name='payment_card_num']").focus();
				return false;
			}

			// PAYMENT_CARD_COMPANY 유효성 검사
			var cardCompany = $("input[name='payment_card_company']").val();
			if (!cardCompany) {
				alert("카드사를 입력하세요.");
				$("input[name='payment_card_company']").focus();
				return false;
			}

			// PAYMENT_TOTAL 유효성 검사
			var paymentTotal = $("input[name='payment_total']").val();
			if (!paymentTotal) {
				alert("결제 금액을 입력하세요.");
				$("input[name='payment_total']").focus();
				return false;
			} else if (!/^\d+(\.\d{1,2})?$/.test(paymentTotal)) {
				alert("결제 금액은 숫자만 입력 가능합니다.");
				$("input[name='payment_total']").focus();
				return false;
			}

			return true; // 모든 유효성 검사를 통과하면 제출을 허용합니다.
		});
	});
</script>
</head>
<body>
	<header id="main-header" class="py-2 btn-dark text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>결제 정보 입력</h1>
				</div>
			</div>
		</div>
	</header>
	<section class="py-4 mb-4 bg-light"></section>
	<section id="payment">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<div class="card">
						<div class="card-header">
							<h5>결제 입력</h5>
						</div>
						<div class="card-body">
							<form action="./PaymentInsert.jn" method="post" id="sign_payment">
								<fieldset>
									<div class="form-group row">
										<label for="payment_card_num"> 카드번호 </label>
										<div class="ml-sm-3">
											<input type="text" name="payment_card_num"
												id="payment_card_num" placeholder="예) 1234-1234-1234-1234"
												class="form-control form-control-sm">
										</div>
									</div>
									<div class="form-group row">
										<label for="payment_card_company"> 카드사 </label>
										<div class="ml-sm-3">
											<input type="text" name="payment_card_company"
												id="payment_card_company" placeholder="예) 국민"
												class="form-control form-control-sm">
										</div>
									</div>
									<div class="form-group row">
										<label for="payment_total"> 결제 금액 </label>
										<div class="ml-sm-3">
											<input type="text" name="payment_total" id="payment_total"
												placeholder="예) 5000" class="form-control form-control-sm">
										</div>
									</div>
									<div class="form-group">
										<button type="submit" class="btn btn-secondary">등록</button>
										<button type="reset" class="btn btn-secondary">취소</button>
									</div>
								</fieldset>
							</form>
							<a href="./PaymentSelect.jn" class="btn btn-primary btn-block">
								결제 목록 </a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>