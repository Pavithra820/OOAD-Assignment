package com.ilp.service;

import java.security.Provider.Service;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp.entity.Account;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Services;

public class BankService {
	 
	public static Services createService() {
		Scanner scanner=new Scanner(System.in);
	     System.out.println("--------Create Services------");
		 System.out.println("Enter the service code");
		 String serviceCode=scanner.nextLine();
		 System.out.println("Enter the service name");
		 String serviceName=scanner.nextLine();
		 System.out.println("Enter the rate");
		 double rate=scanner.nextDouble();
		 Services service=new Services( serviceCode,serviceName,rate);
		return service;
		
	}
	
	public static ArrayList<Product> createProduct(ArrayList<Services> serviceList) {
		Scanner scanner=new Scanner(System.in);
		String  repeat = null;
		char repeatProduct='y';
		do {
		System.out.println("--------Create Products-------");
		System.out.println("Enter the product code:");
		String productCode=scanner.nextLine();
		System.out.println("Enter the product name:");
		String productName=scanner.nextLine();
		ArrayList<Services> selectedServices = new ArrayList<>();
		do {
			System.out.println("Enter a service to add to the product");
	            for (int i = 0; i < serviceList.size(); i++) {
	                System.out.println((i + 1) + ". " + serviceList.get(i).getServiceName());
	            }
	            int choice = scanner.nextInt();
	            selectedServices.add(serviceList.get(choice - 1));
                System.out.println("Do you wish to add more services");
                repeat=scanner.next();
		}while ("yes".equalsIgnoreCase(repeat));
		
	
	    System.out.println("What type of product is it : \n 1.Savings Max Account\n 2.Current Account\n 3.Loan Account");
	    ArrayList<Product> productList = new ArrayList<>();

	    int choice;
	    choice=scanner.nextInt();
	    
	    if(choice==1) {
	    	
	    SavingsMaxAccount savingmaxaccount=new SavingsMaxAccount(productCode,productName,selectedServices,1000);
	    productList.add(savingmaxaccount);
	    }
	    else if(choice==2) {
	    CurrentAccount currentaccount=new  CurrentAccount(productCode,productName,selectedServices);
	    productList.add(currentaccount);
	    }
	    else {
	    LoanAccount loanaccount=new LoanAccount(productCode,productName,selectedServices);
	    productList.add(loanaccount);
	    }
		//Product product=new Product(productCode, productName,selectedServices);
	    for(Product product : productList) {
			System.out.println("Services added to the product "+ product.getProductName());
			for(Services service:product.getServiceList()) {
				System.out.println(service.getServiceName());
			}
	    }return productList;

		
		}while(repeatProduct == 'y');
		
	}
     public static Customer createCustomer(ArrayList<Product>productList) {
    	 ArrayList<Account> accountList = new ArrayList<Account>();
    	 Scanner scanner=new Scanner(System.in);
    	 System.out.println("---------Create Customer---------");
    	 System.out.println("Enter the Customer Code");
    	 String  customerCode=scanner.nextLine();
    	 System.out.println("Enter the Customer name");
    	 String customerName=scanner.nextLine();
    	 accountList=createAccount(productList);
    	 Customer customer=new Customer(customerCode,customerName,accountList);
		 return customer;
		}
     @SuppressWarnings("resource")
	public static ArrayList<Account> createAccount(ArrayList<Product> productList) {
    	    ArrayList<Account> accountList = new ArrayList<Account>();
    	    Scanner scanner = new Scanner(System.in);
    	    
    	    char repeat = 'y';

    	    do {
    	    	Scanner scannerone=new Scanner(System.in);
    	    	System.out.println("------------Create Account--------------");
    	        System.out.println("Enter the Account number");
    	        String accountNo = scannerone.nextLine();
    	        System.out.println("Enter the Account type");
    	        String accountType = scannerone.nextLine();
    	        System.out.println("Enter the Balance");
    	        double balance = scannerone.nextDouble();
    	        scanner.nextLine();

    	       
    	        System.out.println("The Products Available are:");
    	        System.out.println("Product Code \t  Product Name\t  Services");
    	        for (Product product : productList) {
    	            System.out.print(product.getProductCode() + "        " + product.getProductName());
    	            for(Services service:product.getServiceList()) {
    	            	System.out.print(service.getServiceName()+   "  ");
    	            	
    	            }
    	            System.out.println();
    	        }

    	        
    	        System.out.println("Enter the product code:");
    	        String productCode = scanner.next();
                
    	        
    	        Product accountProduct = null;
    	        for (Product product : productList) {
    	            if (product.getProductCode().equalsIgnoreCase(productCode)) {
    	                accountProduct = product;
    	                break; 
    	            }
    	        }

    
//    	        if (accountProduct == null) {
//    	            System.out.println("Invalid product code. Please try again.");
//    	            continue;
//    	        }

    	       
    	        Account account = new Account(accountNo, accountType, balance, accountProduct);
    	        accountList.add(account);

    	        System.out.print("Do you wish to add more accounts? (yes/no)");
    	        repeat = scanner.next().charAt(0);
    	    } while (repeat=='y');

    	    return accountList;
    	}
     
     
     public static Customer manageAccount(Customer customer) {
 		Scanner scanner = new Scanner(System.in);	
 		int flag=0;
 		int manageChoice;
 		char repeatManage='y';
 		char repeatAccount='y';
 		System.out.print("Enter Customer Code : ");
 		String customerCode=scanner.nextLine();
 		if(customerCode.equalsIgnoreCase(customer.getCustomerCode())==false) {
 			System.out.println("No Such Customer");
 			return customer;
 		}
 		do {
 			System.out.print("Enter Account Number : ");
 			String accountNumber=scanner.nextLine();
 			for(Account account : customer.getAccountList()) {
 				if(accountNumber.equalsIgnoreCase(account.getAccountNo())) {
 					flag=1;
 					do {
 						System.out.println("-----------Manage Account--------------");
 						System.out.print("1)Deposit\n2)Withdraw\n3)Display Balance\nEnter Choice Number : ");
 						manageChoice=scanner.nextInt();
 						switch(manageChoice) {
 						case 1 : account.getProduct().depositMoney(account);
 							break;
 						case 2 : account.getProduct().withdrawMoney(account);
 							break;
 						case 3 : System.out.println("Account Number : "+account.getAccountNo());
 								 System.out.println("Account Balance : "+account.getBalance());
 							break;
 			
 						default : 
 						}
 						System.out.print("Do You Want To Change More (y/n) : ");
 						repeatManage=scanner.next().charAt(0);
 					}while(repeatManage=='y');
 				}
 			}
 			if(flag==0) {
 				System.out.println("Account Not Found");
 			}
 			System.out.print("Do you Want To Manage more account (y/n) : ");
 			repeatAccount = scanner.next().charAt(0);
 		}while(repeatAccount=='y');
 		return customer;
 	}
     
//     public static void displayCustomer(Customer customer) {
//    			System.out.println("---------------Customer Details-----------------");
//    			System.out.println("Customer Code : " + customer.getCustomerCode());
//    			System.out.println("Customer Name : " + customer.getCustomerName());
//    			for (Account account : customer.getAccountList()) {
//    				System.out.println("Account Number : " + account.getAccountNo());
//    				System.out.println("Account Name : " + account.getAccountType());
//    				System.out.println("Account Balance : " + account.getBalance());
//    				System.out.println("Product Code : "+account.getProduct().getProductCode());
//    				System.out.println("Product Name : "+account.getProduct().getProductName());
//    				System.out.print("Service : ");
//    				for(Services service : account.getProduct().getServiceList()) {
//    					System.out.print(service.getServiceName()+" ");
//    				}
//    				System.out.println("");
//    			}
//    		}
     
     //Function Overloading
      public static void displayDetails(Customer customer) {
    	  System.out.println("------------------Customer Details----------------");
    	  System.out.println("Customer Code:"+ customer.getCustomerCode());
    	  System.out.println("Customer Name:"+ customer.getCustomerName());
    	  for(Account account:customer.getAccountList()) {
    		  displayDetails(account);
    	  }
      }
      public static void displayDetails(Account account) {
			System.out.println("Account Name : " + account.getAccountType());
			System.out.println("Account Balance : " + account.getBalance());
		    displayDetails(account.getProduct());
      }
      public static void displayDetails(Product product) {
    	    System.out.println("Product Code: " + product.getProductCode());
    	    System.out.println("Product Name: " + product.getProductName());

    	    for (Services service : product.getServiceList()) {
    	        displayDetails(service);
    	    }
    	}

    	public static void displayDetails(Services service) {
    	    System.out.println("Service Code: " + service.getServiceCode());
    	    System.out.println("Service Name: " + service.getServiceName());
    	}

}