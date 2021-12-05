package com.privyid.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.privyid.bankapp.exception.ResourceNotFoundException;
import com.privyid.bankapp.model.UserBalance;
import com.privyid.bankapp.repository.UserBalanceRepository;
import com.privyid.bankapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;


@RestController
public class UserBalanceController {

	@Autowired
	private UserBalanceRepository userbalanceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users/{userId}/balances")
	public Page<UserBalance> getAllUsersBalanceByUserId(@PathVariable (value = "userId") Long userId, Pageable pageable){
		return userbalanceRepository.findByUserId(userId, pageable);
	}
	
	@PostMapping("/users/{userId}/balances")
	  public UserBalance createuserbalance(@PathVariable (value = "userId") Long userId,
              @Valid @RequestBody UserBalance userbalance) {
		return userRepository.findById(userId).map(user -> {
			userbalance.setUser(user);
			return userbalanceRepository.save(userbalance);
		}).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found"));
	}
	
	@PutMapping("/users/{userId}/balances/{balancesId}")
	public UserBalance updateuserbalance(@PathVariable (value = "userId") Long userId,
            @PathVariable (value = "userbalanceId") Long userbalanceId,
            @Valid @RequestBody UserBalance userbalanceRequest) {
		if(!userRepository.existsById(userId)) {
			throw new ResourceNotFoundException("UserId " + userId + " not found");
		}

		return userbalanceRepository.findById(userId).map(userbalance -> 
		{
			userbalance.setBalance(userbalanceRequest.getBalance());
			return userbalanceRepository.save(userbalance);
		}).orElseThrow(() -> new ResourceNotFoundException("UserBalanceId " + userbalanceId + "not found"));
	}
	
		@DeleteMapping("/users/{userId}/balances/{balancesId}")
		public ResponseEntity<?> deleteUserBalance(@PathVariable (value = "userId") Long userId,
				@PathVariable(value = "userbalanceId") Long userbalanceId){
				return userbalanceRepository.findByIdAndUserId(userbalanceId, userId).map(userbalance -> {
					userbalanceRepository.delete(userbalance);
					return ResponseEntity.ok().build();
				}).orElseThrow(() -> new ResourceNotFoundException("User Balance not found with id " + userbalanceId + " and movieId" + userId));
		}		
	}

