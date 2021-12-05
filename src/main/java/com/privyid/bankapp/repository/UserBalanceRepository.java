package com.privyid.bankapp.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.privyid.bankapp.model.UserBalance;

import java.util.*;
public interface UserBalanceRepository extends JpaRepository<UserBalance, Long> {

	List<UserBalance> findByBalance(boolean balance);
	List<UserBalance> findByBalanceContaining(String balance);
//	
	Page<UserBalance> findByUserId(Long userId,Pageable pageable);
	Optional<UserBalance> findByIdAndUserId(Long id, Long userId);
	
}
