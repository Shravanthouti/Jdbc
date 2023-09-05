package com.dnb.Jdbc;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.dnb.Jdbc.dto.Account;
import com.dnb.Jdbc.service.AccountServiceImpl;

public class JDBCApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 
		String a = null;
		String b = null;
		
		Optional<String> optional = Optional.ofNullable(a);
		System.out.println(optional.isPresent());
		*/
		
		//Converting Local Date to java.sql.Date
		
		java.sql.Date date = Date.valueOf(LocalDate.now());
		System.out.println(date);
		
		Account account = new Account();
        account.setAccountId("121");
        account.setAccountHolderName("Shravan");
        account.setAccountType("Savings");
        account.setAccountStatus(true);
        account.setAddress("Hyderabad");
        account.setBalance(102.4f);
        account.setContactNumber("6281487805");
        account.setAccountCreatedDate(LocalDate.now());
        account.setDob(LocalDate.of(2001, 02, 21));



        //System.out.println(AccountServiceImpl.getInstance().createAccount(account));
        //System.out.println(AccountServiceImpl.getInstance().getAccountById(account.getAccountId()));
        
        Scanner sc = new Scanner(System.in);
        while(true)
        {
        	System.out.println("1.accountDetails 2.accountDetailsthroughId");
        	System.out.println("Enter the choice of your operation");
        	
        	int choice = sc.nextInt();
        	if(choice>2)
        	{
        		break;
        	}
        	switch(choice)
        	{
        	case 1: 
        		System.out.println("Enter your accountId: ");
        		String accountId = sc.next();
        		System.out.println("Enter your accountHolderName: ");
        		String accountHolderName = sc.next();
        		System.out.println("Enter your accountType: ");
        		String accountType = sc.next();
        		System.out.println("Enter your accountStatus: ");
        		account.setAccountStatus(true);
        		System.out.println("Enter your address: ");
        		String address = sc.next();
        		System.out.println("Enter your balance: ");
        		float balance = sc.nextFloat();
        		System.out.println("Enter your mobile number: ");
        		String contactNumber = sc.next();
        		System.out.println("Enter your dob: ");
        		String dob = sc.next();
        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        		LocalDate formattedString = LocalDate.parse(dob,formatter);
        		System.out.println("Enter your account created date: ");
        		String accountCreatedDate = sc.next();
        		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yy-MM-dd");
        		LocalDate formattedString1 = LocalDate.parse(accountCreatedDate,formatter);
        		
                account.setAccountId(accountId);
                account.setAccountHolderName(accountHolderName);
                account.setAccountType(accountType);
                account.setAccountStatus(true);
                account.setAddress(address);
                account.setBalance(balance);
                account.setContactNumber(contactNumber);
                account.setAccountCreatedDate(formattedString);
                account.setDob(formattedString1);
                AccountServiceImpl.getInstance().createAccount(account);
        		
        	case 2:	
        		System.out.println("---------------------------------------------------------");
                String accountNumber = sc.next();
                Optional<Account> accountDetails = AccountServiceImpl.getInstance().getAccountById(accountNumber);
                System.out.println(accountDetails);
                break;
                
        	case 3:
        		System.out.println("----------------------------------------------------------");
        		List<Account> accounts = AccountServiceImpl.getInstance().getAllAccounts();
        		System.out.println(accounts);
        		break;

            default:
                System.out.println("Please choice a proper option");
        	}
        }
        
	}
	
	private static Account getInput() {
        // Taking input from the user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Account ID: ");
        String accountId = sc.next();
        System.out.println("Enter your AccountHolder Name: ");
        String accountHolderName = sc.next();
        System.out.println("Enter your AccountType: ");
        String accountType = sc.next();
        System.out.println("Enter your Account Balance: ");
        float balance = sc.nextFloat();
        System.out.println("Enter your AccountHolder Address: ");
        String address = sc.next();
        System.out.println("Enter your AccountHolder ContactNumber: ");
        String contactNumber = sc.next();
        System.out.println("Enter your AccountHolder DOB(yyyy-MM-dd): ");
        String dob = sc.next();
        DateTimeFormatter dateFormatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //Date date = dateFormatter.format(dob);
        LocalDate date = LocalDate.parse(dob, dateFormatter);

        //setting those values
        Account account = new Account();
        account.setAccountId(accountId);
        account.setAccountHolderName(accountHolderName);
        account.setAccountType(accountType);
        account.setAccountStatus(true);
        account.setAddress(address);
        account.setBalance(balance);
        account.setContactNumber(contactNumber);
        account.setAccountCreatedDate(LocalDate.now());
        account.setDob(date);

        sc.close();

        return account;

    }

}
