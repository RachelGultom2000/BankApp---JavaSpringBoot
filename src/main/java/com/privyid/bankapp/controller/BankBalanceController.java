package com.privyid.bankapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.privyid.bankapp.model.BankBalance;
import com.privyid.bankapp.repository.BankBalanceRepository;


@RestController
public class BankBalanceController {

	@Autowired
	private BankBalanceRepository bankbalanceRepository;
	
	public BankBalanceController(BankBalanceRepository bankbalanceRepository) {
		this.bankbalanceRepository = bankbalanceRepository;
	}
	
	@GetMapping("/bank/balances")
	public ResponseEntity<List<BankBalance>> getAllBankBalances(@RequestParam(required = false) String code){
		try {
			List<BankBalance> bankbalances = new ArrayList<BankBalance>();
			
			if(code == null)
				bankbalanceRepository.findAll().forEach(bankbalances::add);
			else
				bankbalanceRepository.findByCodeContaining(code).forEach(bankbalances::add);
			
			if(bankbalances.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(bankbalances,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/bank/balances/{id}")
	public ResponseEntity<BankBalance> getBankBalanceById(@PathVariable (value = "id") Long id)
		throws ResourceNotFoundException{
			BankBalance bankbalance = bankbalanceRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Bank Balance not found on : " + id));
			return ResponseEntity.ok().body(bankbalance);
	}
	
	
	@PostMapping("/bank/balances")
	public BankBalance createBankBalance(@Valid @RequestBody BankBalance bankbalance) {
		return bankbalanceRepository.save(bankbalance);
	}
	
	@PutMapping("/bank/balances{bankbalanceId}")
	public BankBalance updateBankBalance(@PathVariable Long bankbalanceId, @Valid @RequestBody BankBalance bankbalanceRequest) {
		return bankbalanceRepository.findById(bankbalanceId).map(bankbalance -> {
			bankbalance.setBalance(bankbalanceRequest.getBalance());
			bankbalance.setBalance_achieve(bankbalanceRequest.getBalance_achieve());
			bankbalance.setCode(bankbalanceRequest.getCode());
			bankbalance.setEnable(bankbalanceRequest.isEnable());
			return bankbalanceRepository.save(bankbalance);
		}).orElseThrow(() -> new ResourceNotFoundException("BankBalanceId " + bankbalanceId + " not found"));
	}
	
	@DeleteMapping("/bank/balances{bankbalanceId}")
	public ResponseEntity<?> deleteBankBalance(@PathVariable Long bankbalanceId){
		return bankbalanceRepository.findById(bankbalanceId).map(bankbalance ->{
			bankbalanceRepository.delete(bankbalance);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("BankBalanceId " + bankbalanceId + " not found"));
	}
	
	
}

