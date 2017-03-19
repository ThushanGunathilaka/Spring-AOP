package com.mtit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class Account {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	@Column(name="account_type")
	private String accountType;
	@Column(name="balance")
	private int balance;
	@Column(name="date_started")
	private Date dateStarted;
	
	public Account(){
	}
	
	public Account(int id, String accountType, int balance, Date dateStarted) {
		super();
		accountId = id;
		this.accountType = accountType;
		this.balance = balance;
		this.dateStarted = dateStarted;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int id) {
		accountId = id;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getDateStarted() {
		return dateStarted;
	}

	public void setDateStarted(Date dateStarted) {
		this.dateStarted = dateStarted;
	}
	
	
}
