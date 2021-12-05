package com.privyid.bankapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.privyid.bankapp.exception.ResourceNotFoundException;
import com.privyid.bankapp.model.BankBalanceHistory;
import com.privyid.bankapp.model.UserBalance;
import com.privyid.bankapp.model.UserBalanceHistory;
import com.privyid.bankapp.repository.UserBalanceHistoryRepository;
import com.privyid.bankapp.repository.UserBalanceRepository;
import com.privyid.bankapp.repository.UserRepository;

@RestController
public class UserBalanceHistoryController {
	@Autowired
	private UserBalanceHistoryRepository userbalancehistoryRepository;
	
	
	@Autowired
	private UserBalanceRepository userbalanceRepository;
	
	@GetMapping("/users/{userbalanceId}/balancehistories")
	public Page<UserBalanceHistory> getAllUsersBalanceHistoryByUserBalanceId(@PathVariable (value = "userbalanceId") Long userbalanceId, Pageable pageable){
		return userbalancehistoryRepository.findByUserBalanceId(userbalanceId, pageable);
	}
	
	@PostMapping("/users/{userbalanceId}/balancehistories")
	  public UserBalanceHistory createuserbalancehistory(@PathVariable (value = "userbalanceId") Long userbalanceId,
            @Valid @RequestBody UserBalanceHistory userbalancehistory) {
		return (UserBalanceHistory) userbalanceRepository.findById(userbalanceId).map(userbalance -> {
			userbalancehistory.setUserbalance(userbalance);
			return userbalancehistoryRepository.save(userbalancehistory);
		}).orElseThrow(() -> new ResourceNotFoundException("User Balance Id " + userbalanceId + " not found"));
	}
	
}
