package com.example.order.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.order.Entity.Order;
import com.example.order.Service.OrderService;
import com.example.order.common.Payment;
import com.example.order.common.TransactionRequest;
import com.example.order.common.TransactionResponse;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/bookOrder")
	public TransactionResponse saveOrder(@RequestBody TransactionRequest transactionRequest) {
		
		return this.orderService.saveOrder(transactionRequest);
	}

}
