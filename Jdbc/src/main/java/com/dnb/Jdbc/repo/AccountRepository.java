package com.dnb.Jdbc.repo;

import java.util.List;
import java.util.Optional;

import com.dnb.Jdbc.dto.Account;

public interface AccountRepository {
	
	public Account createAccount(Account account);
	
	public Optional<Account> getAccountById(String accountId);
	
	public List<Account> getAllAccounts();
}
