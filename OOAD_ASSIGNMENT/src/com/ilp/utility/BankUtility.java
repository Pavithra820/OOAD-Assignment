package com.ilp.utility;

import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Services;
import com.ilp.service.BankService;

public class BankUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scanner =new Scanner(System.in);
        ArrayList<Services> serviceList = new ArrayList<Services>();
        ArrayList<Product> productList=new ArrayList<Product>();
        Customer customer= null;
        char again = 0;
        int mainMenuChoice;
        String display;
        do {
        	System.out.println(
					"1)Create Service \n2)Create Product\n3)Create Customer\n4)Manage Accounts\n 5)Display Customer\n6)Exit : ");
        	System.out.println("Enter any one of the options:");
        	mainMenuChoice = scanner.nextInt();
			switch (mainMenuChoice) {
			case 1:
			serviceList.add(BankService.createService());
			break;
			case 2:
				productList.addAll(BankService.createProduct(serviceList));
				break;
			case 3:
				customer=BankService.createCustomer(productList);
				break;
			case 4:
				customer=BankService. manageAccount(customer);
				break;
			case 5:
				BankService.displayDetails(customer);
				break;
			case 6:
				System.exit(0);
				break;
						    
			}
			System.out.println("Do You Want to Continue(y/n):");
			scanner.nextLine();
			again=scanner.nextLine().charAt(0);
       
	}
        while(again=='y');
	}

}
