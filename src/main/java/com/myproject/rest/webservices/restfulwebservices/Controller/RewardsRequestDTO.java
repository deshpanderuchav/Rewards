package com.myproject.rest.webservices.restfulwebservices.Controller;

import java.time.LocalDateTime;


// class for DTO, which provides encapsulates input / output
// Getters and Setter for given data 
public class RewardsRequestDTO {
    private Long customerId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	
	

   
}