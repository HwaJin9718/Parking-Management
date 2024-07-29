package car.parking.dto;

public class ParkingDTO {
	
	private int parking_code; // 주차장 코드 > 기본키 (시퀀스)
	private String parking_name; // 주차장 이름
	private String parking_address; // 주차장 주소
	private double parking_latitude; // 주차장 위도
	private double parking_longitude; // 주차장 경도
	private String parking_operation; // 주차장 운영일정 및 시간
	private String parking_type; // 주차장 종류(실내, 실외, 공용 등)
	private String parking_total_spaces; // 총 주차 가능 공간
	private String parking_electriccar_check; // 전기차 충전 가능 여부
	private String parking_electriccar_spaces; // 전기차 충전 가능 공간
	private String parking_pay_type; // 정기권, 시간권 결제 유형
	private String parking_base_fee; // 기본 요금
	private String parking_hourly_rate; // 시간 당 추가요금
	
	private String parking_photo1_name; // 사진 
	private String parking_photo1_path;
	private String parking_photo2_name;
	private String parking_photo2_path;
	private String parking_photo3_name;
	private String parking_photo3_path;
	private String parking_photo4_name;
	private String parking_photo4_path;
	private String parking_photo5_name;
	private String parking_photo5_path;
	
	private String parking_document_name; // 서류
	private String parking_document_path;
	
	private String parking_approval; // 주차장 등록 승인 상태
	
	private String parking_registration; // 등록일시
	private String parking_edit; // 수정일시
	
	private int member_code; // 등록한 고객 코드 > 외래키

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

	public String getParking_operation() {
		return parking_operation;
	}

	public void setParking_operation(String parking_operation) {
		this.parking_operation = parking_operation;
	}

	public String getParking_type() {
		return parking_type;
	}

	public void setParking_type(String parking_type) {
		this.parking_type = parking_type;
	}

	public String getParking_total_spaces() {
		return parking_total_spaces;
	}

	public void setParking_total_spaces(String parking_total_spaces) {
		this.parking_total_spaces = parking_total_spaces;
	}

	public String getParking_electriccar_check() {
		return parking_electriccar_check;
	}

	public void setParking_electriccar_check(String parking_electriccar_check) {
		this.parking_electriccar_check = parking_electriccar_check;
	}

	public String getParking_electriccar_spaces() {
		return parking_electriccar_spaces;
	}

	public void setParking_electriccar_spaces(String parking_electriccar_spaces) {
		this.parking_electriccar_spaces = parking_electriccar_spaces;
	}

	public String getParking_pay_type() {
		return parking_pay_type;
	}

	public void setParking_pay_type(String parking_pay_type) {
		this.parking_pay_type = parking_pay_type;
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

	public String getParking_photo1_name() {
		return parking_photo1_name;
	}

	public void setParking_photo1_name(String parking_photo1_name) {
		this.parking_photo1_name = parking_photo1_name;
	}

	public String getParking_photo1_path() {
		return parking_photo1_path;
	}

	public void setParking_photo1_path(String parking_photo1_path) {
		this.parking_photo1_path = parking_photo1_path;
	}

	public String getParking_photo2_name() {
		return parking_photo2_name;
	}

	public void setParking_photo2_name(String parking_photo2_name) {
		this.parking_photo2_name = parking_photo2_name;
	}

	public String getParking_photo2_path() {
		return parking_photo2_path;
	}

	public void setParking_photo2_path(String parking_photo2_path) {
		this.parking_photo2_path = parking_photo2_path;
	}

	public String getParking_photo3_name() {
		return parking_photo3_name;
	}

	public void setParking_photo3_name(String parking_photo3_name) {
		this.parking_photo3_name = parking_photo3_name;
	}

	public String getParking_photo3_path() {
		return parking_photo3_path;
	}

	public void setParking_photo3_path(String parking_photo3_path) {
		this.parking_photo3_path = parking_photo3_path;
	}

	public String getParking_photo4_name() {
		return parking_photo4_name;
	}

	public void setParking_photo4_name(String parking_photo4_name) {
		this.parking_photo4_name = parking_photo4_name;
	}

	public String getParking_photo4_path() {
		return parking_photo4_path;
	}

	public void setParking_photo4_path(String parking_photo4_path) {
		this.parking_photo4_path = parking_photo4_path;
	}

	public String getParking_photo5_name() {
		return parking_photo5_name;
	}

	public void setParking_photo5_name(String parking_photo5_name) {
		this.parking_photo5_name = parking_photo5_name;
	}

	public String getParking_photo5_path() {
		return parking_photo5_path;
	}

	public void setParking_photo5_path(String parking_photo5_path) {
		this.parking_photo5_path = parking_photo5_path;
	}

	public String getParking_document_name() {
		return parking_document_name;
	}

	public void setParking_document_name(String parking_document_name) {
		this.parking_document_name = parking_document_name;
	}

	public String getParking_document_path() {
		return parking_document_path;
	}

	public void setParking_document_path(String parking_document_path) {
		this.parking_document_path = parking_document_path;
	}

	public String getParking_approval() {
		return parking_approval;
	}

	public void setParking_approval(String parking_approval) {
		this.parking_approval = parking_approval;
	}

	public String getParking_registration() {
		return parking_registration;
	}

	public void setParking_registration(String parking_registration) {
		this.parking_registration = parking_registration;
	}

	public String getParking_edit() {
		return parking_edit;
	}

	public void setParking_edit(String parking_edit) {
		this.parking_edit = parking_edit;
	}

	public int getMember_code() {
		return member_code;
	}

	public void setMember_code(int member_code) {
		this.member_code = member_code;
	}

}
