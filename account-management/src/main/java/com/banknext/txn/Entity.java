package com.banknext.txn;

public class Entity {	
	
	private Customer customer;
	private Account account;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "Entity [customer=" + customer + ", account=" + account + "]";
	}
}
