package com.ilp.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class SavingsMaxAccount extends Product {
	private double minimumBalanace;
	public SavingsMaxAccount(String productCode, String productName, ArrayList<Services> serviceList,
			double minimumBalanace) {
		super(productCode, productName, serviceList);
		this.minimumBalanace = minimumBalanace;
	}
	

	public double getMinimumBalanace() {
		return minimumBalanace;
	}

	public void setMinimumBalanace(double minimumBalanace) {
		this.minimumBalanace = minimumBalanace;
	}

	

	@Override
	public Account withdrawMoney(Account account) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to withraw");
		double amount=scanner.nextDouble();
		if(amount>account.getBalance()) {
			System.out.println("No enough balance");
			
		}
		else if(account.getBalance()-amount<1000)
			System.out.println("Balance Cannot Go Below Minimum");
		else 
			account.setBalance(account.getBalance()-amount);
		return account;
	}

	@Override
	public Account depositMoney(Account account) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the amount to deposit");
		double amount=scanner.nextDouble();
		account.setBalance(amount+account.getBalance());
		return account;
	}

}
