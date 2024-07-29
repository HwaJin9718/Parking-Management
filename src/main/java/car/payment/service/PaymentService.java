package car.payment.service;

import java.util.ArrayList;

import car.payment.dto.PaymentDTO;

public interface PaymentService {
	
	public ArrayList<PaymentDTO> paymentSelectAll();
	
	public PaymentDTO paymentSelect(int payment_code);
	
	public PaymentDTO paymentInsert(PaymentDTO paymentDTO);
	
	public PaymentDTO paymentUpdate(PaymentDTO paymentDTO);
	
	public PaymentDTO paymentDelete(int payment_total);

}
