package com.privyid.bankapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_balance")
public class UserBalance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@NonNull
	@Column(length = 100)
	private String balance;
	
	@NonNull
	private int balance_achieve;
	
	// Relation with User
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public int getBalance_achieve() {
		return balance_achieve;
	}

	public void setBalance_achieve(int balance_achieve) {
		this.balance_achieve = balance_achieve;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
//	// Relation with UserBalanceHistory
//	@OneToMany(mappedBy = "userbalance", fetch = FetchType.LAZY,
//	            cascade = CascadeType.ALL)
//	private Set<UserBalanceHistory> userbalancehistorys;
	
	
}
