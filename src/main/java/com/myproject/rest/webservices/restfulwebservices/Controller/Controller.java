package com.myproject.rest.webservices.restfulwebservices.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.rest.webservices.restfulwebservices.customer.RewardsCalculationService;

@RestController
public class Controller {

	//Get Request to check connection with app 
	@GetMapping(path = "/connect")
	public String GetRequest() {
		return "Connected";
	}
	
	//Method which calculates rewards.
    private RewardsCalculationService rewardsCalculationService;

    // autowire bean RewardsCalculationService
    @Autowired
    public void RewardsController(RewardsCalculationService rewardsCalculationService) {
        this.rewardsCalculationService = rewardsCalculationService;
    }
    
    
    //Post method to calculate rewards 
    @PostMapping("/rewards")
    public ResponseEntity<Map<Integer, Integer>> calculateRewards(@RequestBody RewardsRequestDTO requestDTO) {
    	
    	//  calculateRewardsPerCustomerPerMonth this method calculates rewards between given dates for given customer
    	// User has ability to select flexible dates whether it is for a month or 3 months
        Map<Integer, Integer> rewards = rewardsCalculationService.calculateRewardsPerCustomerPerMonth(requestDTO);
        return ResponseEntity.ok(rewards);
    }


}
