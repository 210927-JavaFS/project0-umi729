package com.revature.dao;

import java.util.List;

import com.revature.models.AccBalance;

public interface BalanceDAO {
	
	public List<AccBalance> findAll();
	public AccBalance findByAccNumber(int acc);
	public boolean updateBalance(AccBalance ab);
	public boolean addBalance(AccBalance ab);
	

}
