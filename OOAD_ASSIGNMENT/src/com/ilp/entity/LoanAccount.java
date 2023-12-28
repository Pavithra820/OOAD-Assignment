package com.ilp.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class LoanAccount extends Product{

	final double chequeDepositCharge=0.3;

	public LoanAccount(String productCode, String productName, ArrayList<Services> serviceList) {
		super(productCode, productName, serviceList);

	}

	@Override
	public Account withdrawMoney(Account account) {
		System.out.println("No amount can be withrawn for loan account");
		return account;
	}

	@Override
	public Account depositMoney(Account account) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("1)Cash\n2)Cheque\nWhat Kind Of Deposit (Enter Number) : ");
		int choice = scanner.nextInt();
		System.out.print("Enter Amount To Deposit : ");
		double money = scanner.nextDouble();
		if(choice==2)
			money=money*0.97;
		account.setBalance(money+account.getBalance());
		return account;
	}

}
