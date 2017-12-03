package com.javaRainbow.jdbc_demo;

public class BankAccount {

	private int id;
	private String accountName;
	private int balance;
	
	
	public BankAccount(int id, String accountName, int balance) {
		super();
		this.id = id;
		this.accountName = accountName;
		this.balance = balance;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
