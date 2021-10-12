package com.revature.dao;

import java.math.BigDecimal;
import java.util.List;

import com.revature.models.AccBalance;

public interface BalanceDAO {
	
	public List<AccBalance> findAll();
	public AccBalance findByAccNumber(int acc);
	public boolean deposit(BigDecimal amount, int uid);
	public boolean addBalance(AccBalance ab);
	public boolean withdraw( BigDecimal i, int uid);
	public boolean transfer(BigDecimal amount, int oa, int acc);
	public AccBalance findByAcc(int acc);
	public boolean deposit(int acc_no, BigDecimal amount);
	public boolean withdraw(int acc_no, BigDecimal amount);
	public AccBalance findByUserName(String user);
	

}
