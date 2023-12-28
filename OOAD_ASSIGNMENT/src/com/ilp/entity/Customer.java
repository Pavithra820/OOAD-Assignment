package com.ilp.entity;

import java.util.ArrayList;

public class Customer {
     private String customerCode;
     private String customerName;
     private ArrayList<Account>AccountList = new ArrayList<Account>();
	public Customer(String customerCode, String customerName, ArrayList<Account> accountList) {
		super();
		this.customerCode = customerCode;
		this.customerName = customerName;
		AccountList = accountList;
	}
	public String getCustomerCode() {
		return customerCode;
	}
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public ArrayList<Account> getAccountList() {
		return AccountList;
	}
	public void setAccountList(ArrayList<Account> accountList) {
		AccountList = accountList;
	}
}
