package car.coupon.service;

import java.util.ArrayList;

import car.coupon.dto.CouponDTO;

public interface CouponService {
	
	public ArrayList<CouponDTO> couponSelectAll();
	
	public CouponDTO couponSelect(int coupon_code);
	
	public CouponDTO couponInsert(CouponDTO couponDTO);
	
	public CouponDTO couponUpdate(CouponDTO couponDTO);
	
	public CouponDTO couponDelete(int coupon_code);
}