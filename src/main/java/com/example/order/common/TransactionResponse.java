package com.example.order.common;

import com.example.order.Entity.Order;

public class TransactionResponse {
  
	private Order order;
	private double amount;
	private String transactionId;
	private String message;
	public TransactionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionResponse(Order order, int amount, String transactionId, String message) {
		super();
		this.order = order;
		this.amount = amount;
		this.transactionId = transactionId;
		this.message = message;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
