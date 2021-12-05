package com.privyid.bankapp.repository;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.privyid.bankapp.model.UserBalanceHistory;


public interface UserBalanceHistoryRepository  extends JpaRepository<UserBalanceRepository,Long> {

//	Optional<UserBalanceHistoryRepository> findByAuthor(String author);
	List<UserBalanceHistory> findByAuthor(String author);
	List<UserBalanceHistory> findByAuthorContaining(String author);
	

	Page<UserBalanceHistory> findByUserBalanceId(Long userbalanceId, Pageable pageable);
	Optional<UserBalanceHistory> findByIdAndUserBalanceId(Long id, Long userbalanceId);
	Object save(@Valid UserBalanceHistory userbalancehistory);
	
}
