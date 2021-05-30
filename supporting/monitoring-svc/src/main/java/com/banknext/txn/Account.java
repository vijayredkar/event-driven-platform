package com.banknext.txn;

import java.math.BigDecimal;

public class Account 
{

	private String type; 
	private boolean hni ;
	private BigDecimal minbalance;
	private boolean overdraft;
	private BigDecimal dailyWithdrwalLimit;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isHni() {
		return hni;
	}
	public void setHni(boolean hni) {
		this.hni = hni;
	}
	public BigDecimal getMinbalance() {
		return minbalance;
	}
	public void setMinbalance(BigDecimal minbalance) {
		this.minbalance = minbalance;
	}
	public boolean isOverdraft() {
		return overdraft;
	}
	public void setOverdraft(boolean overdraft) {
		this.overdraft = overdraft;
	}
	public BigDecimal getDailyWithdrwalLimit() {
		return dailyWithdrwalLimit;
	}
	public void setDailyWithdrwalLimit(BigDecimal dailyWithdrwalLimit) {
		this.dailyWithdrwalLimit = dailyWithdrwalLimit;
	}
	
	@Override
	public String toString() {
		return "Account [type=" + type + ", hni=" + hni + ", minbalance=" + minbalance + ", overdraft=" + overdraft
				+ ", dailyWithdrwalLimit=" + dailyWithdrwalLimit + "]";
	}	
	
}

	
