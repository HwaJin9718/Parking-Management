package car.payment.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.payment.dao.PaymentDAO;
import car.payment.dto.PaymentDTO;
import car.common.handler.HandlerAdapter;

public class PaymentInsertController implements Controller {
	private static Log log = LogFactory.getLog(PaymentInsertController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		String payment_card_num = request.getParameter("payment_card_num");
		String payment_card_company = request.getParameter("payment_card_company");
		int payment_total = Integer.parseInt(request.getParameter("payment_total"));
		
		PaymentDAO paymentDao = new PaymentDAO();
		PaymentDTO	paymentDTO = new PaymentDTO();
		ArrayList<PaymentDTO> arrayList = new ArrayList<PaymentDTO>();
		
		arrayList = paymentDao.paymentSelectAll();
		log.info("얼레이리스트 - " + arrayList);
		request.setAttribute("arrayList", arrayList);
		
		paymentDTO.setPayment_card_num(payment_card_num);
		paymentDTO.setPayment_card_company(payment_card_company);
		paymentDTO.setPayment_total(payment_total);
		
		paymentDTO = paymentDao.paymentInsert(paymentDTO);
		log.info("디티오 - " + paymentDTO);
		request.setAttribute("paymentDTO", paymentDTO);
		log.info("결제 정보 등록");
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		
		HandlerAdapter.setPath("/WEB-INF/view/payment/payment_insert_view.jsp");
		
		return HandlerAdapter;
	}
}