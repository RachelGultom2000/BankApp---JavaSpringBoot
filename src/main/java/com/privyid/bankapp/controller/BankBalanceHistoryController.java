package com.privyid.bankapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.privyid.bankapp.exception.ResourceNotFoundException;
import com.privyid.bankapp.model.BankBalanceHistory;
import com.privyid.bankapp.model.UserBalanceHistory;
import com.privyid.bankapp.repository.BankBalanceHistoryRepository;
import com.privyid.bankapp.repository.BankBalanceRepository;
import com.privyid.bankapp.repository.UserBalanceHistoryRepository;
import com.privyid.bankapp.repository.UserBalanceRepository;
import com.privyid.bankapp.repository.UserRepository;

public class BankBalanceHistoryController {
	@Autowired
	private BankBalanceHistoryRepository bankbalancehistoryRepository;
	
	
//	@Autowired
//	private BankBalanceRepository bankbalanceRepository;
//	
//	@GetMapping("/bank/{bankbalanceId}/balancehistories")
//	public Page<BankBalanceHistory> getAllBankBalanceHistoryByBankBalanceId(@PathVariable (value = "bankbalanceId") Long bankbalanceId, Pageable pageable){
//		return bankbalancehistoryRepository.findByBankBalanceId(bankbalanceId, pageable);
//	}
//	
//	@PostMapping("/bank/{bankbalanceId}/balancehistories")
//	  public BankBalanceHistory createbankbalancehistory(@PathVariable (value = "bankbalanceId") Long bankbalanceId,
//              @Valid @RequestBody BankBalanceHistory bankbalancehistory) {
//		return bankbalanceRepository.findById(bankbalanceId).map(bankbalance -> {
//			bankbalancehistory.setBankbalance(bankbalance);
//			return bankbalancehistoryRepository.save(bankbalancehistory);
//		}).orElseThrow(() -> new ResourceNotFoundException("Bank Balance Id " + bankbalanceId + " not found"));
//	}
}
