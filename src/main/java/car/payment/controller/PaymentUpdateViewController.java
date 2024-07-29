package car.payment.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.payment.dao.PaymentDAO;
import car.payment.dto.PaymentDTO;
import car.common.handler.HandlerAdapter;

public class PaymentUpdateViewController implements Controller{
	private static Log log = LogFactory.getLog(PaymentUpdateViewController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int payment_code = Integer.parseInt(request.getParameter("payment_code"));
		log.info(payment_code);
		String payment_card_num = request.getParameter("payment_card_num");
		log.info(payment_card_num);
		String payment_card_company = request.getParameter("payment_card_company");
		log.info(payment_card_company);
		int payment_total = Integer.parseInt(request.getParameter("payment_total"));
		log.info(payment_total);
		
		PaymentDAO	paymentDao = new PaymentDAO();
		PaymentDTO paymentDTO = new PaymentDTO();
		
		paymentDTO.setPayment_code(payment_code);
		paymentDTO.setPayment_card_num(payment_card_num);
		paymentDTO.setPayment_card_company(payment_card_company);
		paymentDTO.setPayment_total(payment_total);
		
		paymentDTO = paymentDao.paymentUpdate(paymentDTO);
		log.info("디티오수정 - " + paymentDTO);
		
		request.setAttribute("paymentDTO", paymentDTO);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		
		HandlerAdapter.setPath("/WEB-INF/view/payment/payment_update_view.jsp");
		return HandlerAdapter;
	}
}