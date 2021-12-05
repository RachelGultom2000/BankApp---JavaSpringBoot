package com.privyid.bankapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.privyid.bankapp.model.BankBalance;

public interface BankBalanceRepository extends JpaRepository<BankBalance,Long> {
	
	List<BankBalance> findByCodeContaining(String code);
	List<BankBalance> findByCode(String code);
}
