package car.coupon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.coupon.dao.CouponDAO;
import car.coupon.dto.CouponDTO;
import car.common.handler.HandlerAdapter;

public class CouponSelectDetailController implements Controller{
	private static Log log = LogFactory.getLog(CouponSelectDetailController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int coupon_code = Integer.parseInt(request.getParameter("coupon_code"));
		log.info(coupon_code);
		CouponDAO couponDao = new CouponDAO();
		CouponDTO couponDTO = new CouponDTO();
		
		couponDTO = couponDao.couponSelect(coupon_code);
		log.info(couponDTO);
		
		request.setAttribute("couponDTO", couponDTO);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		log.info("상세 쿠폰 조회");
		
		HandlerAdapter.setPath("/WEB-INF/view/coupon/coupon_select_detail_view.jsp");
		log.info("detail_view 값 넘어가는지");
		return HandlerAdapter;
	}
}