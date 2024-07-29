package car.payment.dto;

import java.sql.Date;

public class PaymentDTO {
	
	private int payment_code;
	
	private String payment_card_num;
	
	private String payment_card_company;
	
	private int payment_total;

	private Date payment_date;

	public int getPayment_code() {
		return payment_code;
	}

	public void setPayment_code(int payment_code) {
		this.payment_code = payment_code;
	}

	public String getPayment_card_num() {
		return payment_card_num;
	}

	public void setPayment_card_num(String payment_card_num) {
		this.payment_card_num = payment_card_num;
	}

	public String getPayment_card_company() {
		return payment_card_company;
	}

	public void setPayment_card_company(String payment_card_company) {
		this.payment_card_company = payment_card_company;
	}

	public int getPayment_total() {
		return payment_total;
	}

	public void setPayment_total(int payment_total) {
		this.payment_total = payment_total;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}	
}