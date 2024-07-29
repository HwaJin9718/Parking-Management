package car.parkingsearch.dto;

public class ParkingSearchDTO {
	private int parking_code;
	private String parking_name;
	private String parking_address;
	private double parking_latitude;
	private double parking_longitude;
	private String parking_base_fee;
	private String parking_hourly_rate;
	private String parking_type;
	
	public int getParking_code() {
		return parking_code;
	}
	public void setParking_code(int parking_code) {
		this.parking_code = parking_code;
	}
	public String getParking_name() {
		return parking_name;
	}
	public void setParking_name(String parking_name) {
		this.parking_name = parking_name;
	}
	public String getParking_address() {
		return parking_address;
	}
	public void setParking_address(String parking_address) {
		this.parking_address = parking_address;
	}
	public double getParking_latitude() {
		return parking_latitude;
	}
	public void setParking_latitude(double parking_latitude) {
		this.parking_latitude = parking_latitude;
	}
	public double getParking_longitude() {
		return parking_longitude;
	}
	public void setParking_longitude(double parking_longitude) {
		this.parking_longitude = parking_longitude;
	}
	public String getParking_base_fee() {
		return parking_base_fee;
	}
	public void setParking_base_fee(String parking_base_fee) {
		this.parking_base_fee = parking_base_fee;
	}
	public String getParking_hourly_rate() {
		return parking_hourly_rate;
	}
	public void setParking_hourly_rate(String parking_hourly_rate) {
		this.parking_hourly_rate = parking_hourly_rate;
	}
	public String getParking_type() {
		return parking_type;
	}
	public void setParking_type(String parking_type) {
		this.parking_type = parking_type;
	}
	
	@Override
	public String toString() {
		return "ParkingSearchDTO [parking_code=" + parking_code + ", parking_name=" + parking_name
				+ ", parking_address=" + parking_address + ", parking_latitude=" + parking_latitude
				+ ", parking_longitude=" + parking_longitude + ", parking_base_fee=" + parking_base_fee
				+ ", parking_hourly_rate=" + parking_hourly_rate + ", parking_type=" + parking_type + "]";
	}
	
}
