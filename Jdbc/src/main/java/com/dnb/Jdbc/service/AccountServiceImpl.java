package com.dnb.Jdbc.service;

import java.util.List;
import java.util.Optional;

import com.dnb.Jdbc.dto.Account;
import com.dnb.Jdbc.repo.AccountRepositoryImpl;

public class AccountServiceImpl implements AccountService {

	private static AccountService accountservice;
	private AccountServiceImpl() {
	    // TODO Auto-generated constructor stub
	}
	
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return AccountRepositoryImpl.getInstance().createAccount(account);
	}

	@Override
	public Optional<Account> getAccountById(String accountId) {
		// TODO Auto-generated method stub
		return AccountRepositoryImpl.getInstance().getAccountById(accountId);
	}
	
	public static AccountService getInstance() {
        synchronized(AccountServiceImpl.class) {
            if(accountservice==null) {
                accountservice=new  AccountServiceImpl();
            }
        }
        return accountservice;
    }


	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return AccountRepositoryImpl.getInstance().getAllAccounts();
	}
}
