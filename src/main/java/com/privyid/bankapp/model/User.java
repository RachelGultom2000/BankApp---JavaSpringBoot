package com.privyid.bankapp.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "users", 
uniqueConstraints = {@UniqueConstraint(columnNames = {"username" , "email"})})

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String password;
	
	
	 @OneToMany(mappedBy = "user", fetch = FetchType.LAZY,
	            cascade = CascadeType.ALL)
	 private Set<UserBalance> userbalances;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<UserBalance> getUserbalances() {
		return userbalances;
	}


	public void setUserbalances(Set<UserBalance> userbalances) {
		this.userbalances = userbalances;
	}

	 
	
}
