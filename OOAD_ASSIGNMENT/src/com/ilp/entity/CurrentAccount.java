package com.ilp.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class CurrentAccount extends Product {

	public CurrentAccount(String productCode, String productName, ArrayList<Services> serviceList) {
		super(productCode, productName, serviceList);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Account withdrawMoney(Account account) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to withraw");
		double amount=scanner.nextDouble();
		if(amount>account.getBalance()) {
			System.out.println("No enough balance");
			
		}
		else {
			account.setBalance(account.getBalance()-amount);
		}
		return account;
	}

	@Override
	public Account depositMoney(Account account) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to be deposit");
		double amount=scanner.nextDouble();
	    account.setBalance(amount+account.getBalance());
		return account;
	}

}
