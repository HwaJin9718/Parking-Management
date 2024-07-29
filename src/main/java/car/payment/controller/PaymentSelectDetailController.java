package car.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.payment.dao.PaymentDAO;
import car.payment.dto.PaymentDTO;
import car.common.handler.HandlerAdapter;

public class PaymentSelectDetailController implements Controller{
	private static Log log = LogFactory.getLog(PaymentSelectDetailController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int payment_code = Integer.parseInt(request.getParameter("payment_code"));
		log.info(payment_code);
		PaymentDAO paymentDao = new PaymentDAO();
		PaymentDTO paymentDTO = new PaymentDTO();
		
		paymentDTO = paymentDao.paymentSelect(payment_code);
		log.info(paymentDTO);
		
		request.setAttribute("paymentDTO", paymentDTO);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		log.info("상세 결제 조회");
		
		HandlerAdapter.setPath("/WEB-INF/view/payment/payment_select_detail_view.jsp");
		log.info("detail_view 값 넘어가는지");
		return HandlerAdapter;
	}
}