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
import javax.validation.constraints.NotNull;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "user_balance_history")
public class UserBalanceHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@NotNull
	private int balanceBefore;
	
	@NotNull
	private int balanceAfter;
	
	@NotNull
	@Column(length = 100)
	private String activity;
	
	@NotNull
	public enum type{
		debit,kredit;
	}
	
	@NotNull
	@Column(length = 50)
	private String ip;
	
	@NotNull
	@Column(length = 100)
	private String location;
	
	@NotNull
	@Column(length = 100)
	private String userAgent;
	
	@NotNull
	@Column(length = 60)
	private String author;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userBalanceId", nullable = false)
    private UserBalance userbalance;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBalanceBefore() {
		return balanceBefore;
	}

	public void setBalanceBefore(int balanceBefore) {
		this.balanceBefore = balanceBefore;
	}

	public int getBalanceAfter() {
		return balanceAfter;
	}

	public void setBalanceAfter(int balanceAfter) {
		this.balanceAfter = balanceAfter;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public UserBalance getUserbalance() {
		return userbalance;
	}

	public void setUserbalance(UserBalance userbalance) {
		this.userbalance = userbalance;
	}


}
