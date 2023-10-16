package com.myproject.rest.webservices.restfulwebservices.customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.rest.webservices.restfulwebservices.Controller.RewardsRequestDTO;
import com.myproject.rest.webservices.restfulwebservices.jpa.TransactionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


// Method to calculate rewards 
@Service
public class RewardsCalculationService {

	private final TransactionRepository transactionRepository;

    @Autowired
    public RewardsCalculationService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
 
    public Map<Integer, Integer> calculateRewardsPerCustomerPerMonth(RewardsRequestDTO requestDTO) {
        Long customerId = requestDTO.getCustomerId();
        LocalDateTime startDate = requestDTO.getStartDate();
        LocalDateTime endDate = requestDTO.getEndDate();
    
        System.out.println("customerId:" + customerId);
        List<Transaction> transactions = transactionRepository.findByCustomerIdAndTransactionDateBetween(customerId, startDate, endDate);

        return transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::getCustomerId,
                        Collectors.summingInt(this::calculateRewardsForTransaction)
                ));
    }

    private int calculateRewardsForTransaction(Transaction transaction) {
           	
    	int rewardsPerTransaction = 0;
    	double amount = transaction.getAmount();
    	if(amount >=50 && amount <=100) {
    		int points1 = (int) (amount - 50);
    		rewardsPerTransaction = points1;
    	}
    	else if(amount >100) {
    		int points2 = (int) ((amount - 100) * 2);
    		int points1 = 50;
    		rewardsPerTransaction = points2 + points1;
    	}
        return (int) rewardsPerTransaction;
    }

	
}