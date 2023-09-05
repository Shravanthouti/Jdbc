package com.dnb.Jdbc.repo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dnb.Jdbc.dto.Account;
import com.dnb.Jdbc.utils.DBUtils;


public class AccountRepositoryImpl implements AccountRepository {

	private AccountRepositoryImpl()
	{
		
	}
	
	private static AccountRepository accountRepository;
	
	@Override
	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		String createAccountStatement = "insert into account "+"(accountId, accountHolderName, accountType, balance, contactNumber, address, accountCreatedDate, dob)"+
		"values(?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;
		if(connection.isPresent())
		{
		try
		{
		preparedStatement = connection.get().prepareStatement(createAccountStatement);
		preparedStatement.setString(1,  account.getAccountId());
		preparedStatement.setString(2, account.getAccountHolderName());
		preparedStatement.setString(3,  account.getAccountType());
		preparedStatement.setFloat(4,  account.getBalance());
		preparedStatement.setString(5,  account.getContactNumber());
		preparedStatement.setString(6,  account.getAddress());
		preparedStatement.setDate(7,  Date.valueOf(account.getAccountCreatedDate()));
		preparedStatement.setDate(8,  Date.valueOf(account.getDob()));
		preparedStatement.setBoolean(1,  account.isAccountStatus());
		int result = preparedStatement.executeUpdate();
		if(result>0)
		{
			return account;
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection.isPresent())
			{
				DBUtils.closeConnection(connection.get());
			}
		}
		}
		else
		{
			return null;
		}
		return account;
	}
		
		@Override
	public Optional<Account> getAccountById(String accountId) {
			// TODO Auto-generated method stub
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		String query = "select * from account where accountId=?";
		if(connection.isPresent())
		{
		try
		{
		preparedStatement = connection.get().prepareStatement(query);
		preparedStatement.setString(1, accountId);
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next())
		{
			Account account = new Account();
			account.setAccountId(resultSet.getString("accountId"));
			account.setAccountHolderName(resultSet.getString("accountHolderName"));
			account.setAccountType(resultSet.getString("accountType"));
			account.setBalance(resultSet.getFloat("balance"));
			account.setContactNumber(resultSet.getString("contactNumber"));
			account.setAddress(resultSet.getString("address"));
			account.setAccountCreatedDate(resultSet.getDate("accountCreatedDate").toLocalDate());
			account.setDob(resultSet.getDate("dob").toLocalDate());
			account.setAccountStatus(resultSet.getBoolean("accountStatus"));
			return Optional.of(account);
		}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection.isPresent())
			{
				DBUtils.closeConnection(connection.get());
			}
		}
		return null;
		}
		return Optional.empty();
	}
	
	public static AccountRepository getInstance()
	{
		synchronized(AccountRepositoryImpl.class)
		{
			if(accountRepository == null)
			{
				accountRepository = new AccountRepositoryImpl();
			}
		}
		return accountRepository;
	}

	@Override
	public List<Account> getAllAccounts() {
		Optional<Connection> connection = DBUtils.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet = null;
		String query = "select * from account";
		List<Account> accounts = new ArrayList<>();
		if(connection.isPresent())
		{
		try
		{
		preparedStatement = connection.get().prepareStatement(query);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next())
		{
			Account account = new Account();
			account.setAccountId(resultSet.getString("accountId"));
			account.setAccountHolderName(resultSet.getString("accountHolderName"));
			account.setAccountType(resultSet.getString("accountType"));
			account.setBalance(resultSet.getFloat("balance"));
			account.setContactNumber(resultSet.getString("contactNumber"));
			account.setAddress(resultSet.getString("address"));
			account.setAccountCreatedDate(resultSet.getDate("accountCreatedDate").toLocalDate());
			account.setDob(resultSet.getDate("dob").toLocalDate());
			account.setAccountStatus(resultSet.getBoolean("accountStatus"));
			accounts.add(account);
		}
		return accounts;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection.isPresent())
			{
				DBUtils.closeConnection(connection.get());
			}
		}
		return null;
		}
		return accounts;
	}
	

}
