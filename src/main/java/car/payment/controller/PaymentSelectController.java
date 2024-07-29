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

public class PaymentSelectController implements Controller {
	private static Log log = LogFactory.getLog(PaymentSelectController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		PaymentDAO paymentDao = new PaymentDAO();
		PaymentDTO paymentDTO = new PaymentDTO();
		log.info(paymentDTO);
		ArrayList<PaymentDTO> arrayList = new ArrayList<PaymentDTO>();
		
		arrayList = paymentDao.paymentSelectAll();
		request.setAttribute("arrayList", arrayList);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		
		HandlerAdapter.setPath("WEB-INF/view/payment/payment_select_view.jsp");
		return HandlerAdapter;
	}
}