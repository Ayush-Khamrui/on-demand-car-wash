package com.carwash.order.models;

import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class Order {
	@Id
	@Field
	private String washerId;
	@Field
	private String emailId;
	@Field
	private String Success;
	
	public String getWasherId() {
		return washerId;
	}
	public void setWasherId(String washerId) {
		this.washerId = washerId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getSuccess() {
		return Success;
	}
	public void setSuccess(String success) {
		this.Success = success;
	}
	public Order(String washerId, String emailId, String success) {
		super();
		this.washerId = washerId;
		this.emailId = emailId;
		this.Success = success;
	}
	

	
}