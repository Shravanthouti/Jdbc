package com.dnb.Jdbc.service;

import java.util.List;
import java.util.Optional;

import com.dnb.Jdbc.dto.Account;

public interface AccountService {
	public Account createAccount(Account account);
	
	public Optional<Account> getAccountById(String account);
	
	public List<Account> getAllAccounts();
}
