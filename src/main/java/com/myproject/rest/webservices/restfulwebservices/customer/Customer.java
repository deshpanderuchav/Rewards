package com.myproject.rest.webservices.restfulwebservices.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size; 


// entity model for customer 
@Entity(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue
	private Integer customerId;
	
	
	@Size(min=2, message = "Name should have at least 2 characters")
	@JsonProperty("customer_name")
	private String customer_name;
	
	
	
	public Customer(Integer customerId, String customer_name) {
		super();
		this.customerId = customerId;
		this.customer_name = customer_name;
	}
	
	
	@Override
	public String toString() {
		return "User [customer_id=" + customerId + ", customer_name=" + customer_name + "]";
	}


	public Integer getCustomer_id() {
		return customerId;
	}


	public void setCustomer_id(Integer customerId) {
		this.customerId = customerId;
	}


	public String getCustomer_name() {
		return customer_name;
	}


	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

}
