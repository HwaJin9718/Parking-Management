package car.coupon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.coupon.dao.CouponDAO;
import car.coupon.dto.CouponDTO;
import car.common.handler.HandlerAdapter;

public class CouponUpdateViewController implements Controller{
	private static Log log = LogFactory.getLog(CouponUpdateViewController.class);

	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int coupon_code = Integer.parseInt(request.getParameter("coupon_code"));
		log.info(coupon_code);
		String coupon_type = request.getParameter("coupon_type");
		log.info(coupon_type);
		String coupon_name = request.getParameter("coupon_name");
		log.info(coupon_name);
		int coupon_price = Integer.parseInt(request.getParameter("coupon_price"));
		log.info(coupon_price);
		String coupon_use = request.getParameter("coupon_use");
		log.info(coupon_use);
		CouponDAO couponDao = new CouponDAO();
		CouponDTO couponDTO = new CouponDTO();
		
		couponDTO.setCoupon_code(coupon_code);
		couponDTO.setCoupon_type(coupon_type);
		couponDTO.setCoupon_name(coupon_name);
		couponDTO.setCoupon_price(coupon_price);
		couponDTO.setCoupon_use(coupon_use);
		
		couponDTO = couponDao.couponUpdate(couponDTO);
		log.info("업데이트뷰 디티오 -" + couponDTO);
		request.setAttribute("couponDTO", couponDTO);
		HandlerAdapter HandlerAdapter = new HandlerAdapter();
		
		HandlerAdapter.setPath("/WEB-INF/view/coupon/coupon_update_view.jsp");
		return HandlerAdapter;
	}
}