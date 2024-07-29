package car.coupon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.coupon.dao.CouponDAO;
import car.coupon.dto.CouponDTO;
import car.common.handler.HandlerAdapter;

public class CouponUpdateController implements Controller {
	private static Log log = LogFactory.getLog(CouponUpdateController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int coupon_code = Integer.parseInt(request.getParameter("coupon_code"));
		log.info("쿠폰코드 - " + coupon_code);
		CouponDAO couponDao = new CouponDAO();
		CouponDTO couponDTO = new CouponDTO();
		
		couponDTO = couponDao.couponSelect(coupon_code);
		
		request.setAttribute("couponDTO", couponDTO);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		log.info("특정 부서 조회");
		
		HandlerAdapter.setPath("/WEB-INF/view/coupon/coupon_update.jsp");
		return HandlerAdapter;
	}
}