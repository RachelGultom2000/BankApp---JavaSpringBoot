package com.privyid.bankapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.privyid.bankapp.model.BankBalanceHistory;

public interface BankBalanceHistoryRepository  extends JpaRepository<BankBalanceHistory,Long>  {
//
//	List<BankBalanceHistory> findByAuthorContaining(String author);
//	List<BankBalanceHistory> findByAuthor(String author);
//	
//	Page<BankBalanceHistory> findByBankBalanceId(Long bankbalanceId, Pageable pageable);
//	Optional<BankBalanceHistory> findByIdAndBankBalanceId(Long id, Long bankbalanceId);
//	
}
