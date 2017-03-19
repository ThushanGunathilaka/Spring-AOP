package com.mtit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	@Column(name="transaction_type")
	private String transactionType;
	@Column(name="transaction_amount")
	private int transactionAmount;
	@Column(name="transaction_date")
	private Date transactionDate;
	@Column(name="customer_id")
	private int transactionAccountHolderId;
	@Column(name="account_no")
	private int transactionAccountId;
	
	public Transaction(){
	}

	public Transaction(int id, String transactionType, int transactionAmount,
			Date transactionDate, int accountHolderId, int accountId) {
		super();
		transactionId = id;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
		this.transactionAccountHolderId = accountHolderId;
		this.transactionAccountId = accountId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int id) {
		transactionId = id;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public int getTransactionAccountHolderId() {
		return transactionAccountHolderId;
	}

	public void setTransactionAccountHolderId(int accountHolderId) {
		this.transactionAccountHolderId = accountHolderId;
	}

	public int getTransactionAccountId() {
		return transactionAccountId;
	}

	public void setTransactionAccountId(int accountId) {
		this.transactionAccountId = accountId;
	}
	
	
}
