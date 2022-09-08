package com.example.order.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.order.Entity.Order;
import com.example.order.Repository.OrderRepository;
import com.example.order.common.Payment;
import com.example.order.common.TransactionRequest;
import com.example.order.common.TransactionResponse;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public TransactionResponse saveOrder(TransactionRequest request) {

		Order order=request.getOrder();
		Payment payment=request.getPayment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getPrice());
		// logic to do call request.
		Payment paymentResponse=this.restTemplate.postForObject("http://PAYMENT-SERVICE/payment/doPayment",payment,Payment.class);
		this.repository.save(order);
		String response=paymentResponse.getPaymentStatus().equals("success") ? "Payment processing successful and order placed":"There ia failure in payment ,Order added to the cart";
			
		
		TransactionResponse tresponse=new TransactionResponse();
		tresponse.setAmount(payment.getAmount());
		tresponse.setMessage(response);
		tresponse.setOrder(order);
		tresponse.setTransactionId(paymentResponse.getTransactionId());
		
	
		return tresponse;
	}

}
