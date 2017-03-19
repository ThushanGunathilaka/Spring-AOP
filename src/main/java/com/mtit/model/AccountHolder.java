package com.mtit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT_HOLDER")
public class AccountHolder {
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountHolderId;
	@Column(name = "firstname")
	private String firstName;
	@Column(name = "lastname")
	private String lastName;
	@Column(name = "phone")
	private int phone;
	@Column(name = "account_no")
	private int accountNo;
	@Column(name = "address")
	private String address;

	public AccountHolder() {
	}

	public AccountHolder(int id, String firstName, String lastName, int phone,
			int accountNo, String address) {
		super();
		accountHolderId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.accountNo = accountNo;
		this.address = address;
	}

	public int getAccountHolderId() {
		return accountHolderId;
	}

	public void setAccountHolderId(int id) {
		accountHolderId = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
