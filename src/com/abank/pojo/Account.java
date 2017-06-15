package com.abank.pojo;

import java.io.Serializable;

public class Account implements Serializable {
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj instanceof Account) 
		{
			Account other = (Account) obj;
			if (other.getAccountId() == this.getAccountId()
				&& other.getIbanNumber().equals(this.getIbanNumber())	
					)
				return true;
		}
		return false;
	}
	private Integer accountId;
	private String accountNumber;
	private String ibanNumber;
	private String currencyCode;
	private String accountName;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIbanNumber() {
		return ibanNumber;
	}
	public void setIbanNumber(String ibanNumber) {
		this.ibanNumber = ibanNumber;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	


}
