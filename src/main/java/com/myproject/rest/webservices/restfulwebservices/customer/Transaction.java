package com.myproject.rest.webservices.restfulwebservices.customer;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


//Transaction entity
@Entity
public class Transaction {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 10)
	private double amount;
		
	@Past
	private LocalDateTime  transactionDate;
	
	private int customerId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public  LocalDateTime getTransDate() {
		return transactionDate;
	}

	public void setTransDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", amount=" + amount + ", transactionDate=" + transactionDate + ", customerId="
				+ customerId + "]";
	}

	
	

}
