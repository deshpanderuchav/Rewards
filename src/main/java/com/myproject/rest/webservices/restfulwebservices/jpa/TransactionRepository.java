package com.myproject.rest.webservices.restfulwebservices.jpa;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myproject.rest.webservices.restfulwebservices.customer.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction, Long> {
//Interface will query database to return transactions for give customer for dates provided
		List<Transaction> findByCustomerIdAndTransactionDateBetween(Long customerId, LocalDateTime startDate,
				LocalDateTime endDate);
	}


