package car.coupon.dto;

import java.sql.Date;

public class CouponDTO {
	
	private int coupon_code;
	private String coupon_type;
	private String coupon_name;
	private Date coupon_start;
	private Date coupon_end;
	private int coupon_price;   
	private String coupon_use;
	public int getCoupon_code() {
		return coupon_code;
	}
	public void setCoupon_code(int coupon_code) {
		this.coupon_code = coupon_code;
	}
	public String getCoupon_type() {
		return coupon_type;
	}
	public void setCoupon_type(String coupon_type) {
		this.coupon_type = coupon_type;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public Date getCoupon_start() {
		return coupon_start;
	}
	public void setCoupon_start(Date coupon_start) {
		this.coupon_start = coupon_start;
	}
	public Date getCoupon_end() {
		return coupon_end;
	}
	public void setCoupon_end(Date coupon_end) {
		this.coupon_end = coupon_end;
	}
	public int getCoupon_price() {
		return coupon_price;
	}
	public void setCoupon_price(int coupon_price) {
		this.coupon_price = coupon_price;
	}
	public String getCoupon_use() {
		return coupon_use;
	}
	public void setCoupon_use(String coupon_use) {
		this.coupon_use = coupon_use;
	}
	@Override
	public String toString() {
		return "CouponDTO [coupon_code=" + coupon_code + ", coupon_type=" + coupon_type + ", coupon_name=" + coupon_name
				+ ", coupon_start=" + coupon_start + ", coupon_end=" + coupon_end + ", coupon_price=" + coupon_price
				+ ", coupon_use=" + coupon_use + "]";
	}	
}