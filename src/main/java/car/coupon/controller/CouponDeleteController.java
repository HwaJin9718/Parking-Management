package car.coupon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import car.common.control.Controller;
import car.coupon.dao.CouponDAO;
import car.coupon.dto.CouponDTO;
import car.common.handler.HandlerAdapter;

public class CouponDeleteController implements Controller{
	private static Log log = LogFactory.getLog(CouponDeleteController.class);
	@Override
	public HandlerAdapter execute(HttpServletRequest request, HttpServletResponse response) {
		int coupon_code = Integer.parseInt(request.getParameter("coupon_code"));
		log.info(coupon_code);
		CouponDAO couponDao = new CouponDAO( );
		CouponDTO couponDTO = new CouponDTO( );
		
		couponDTO.setCoupon_code(coupon_code);
		
		request.setAttribute("couponDTO", couponDTO);
		
		couponDTO = couponDao.couponDelete(coupon_code);
		log.info(couponDTO);
		HandlerAdapter couponHandlerAdapter = new HandlerAdapter();
		
		couponHandlerAdapter.setPath("/WEB-INF/view/coupon/coupon_delete_view.jsp");
		return couponHandlerAdapter;
	}
}