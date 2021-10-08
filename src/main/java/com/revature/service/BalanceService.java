package com.revature.service;

import java.util.List;

import com.revature.dao.BalanceDAO;
import com.revature.dao.BalanceDAOImpl;
import com.revature.models.AccBalance;

public class BalanceService {
	
private BalanceDAO balDAO= new BalanceDAOImpl();

	public List<AccBalance> findAllHome(){
		
		return balDAO.findAll();
	}
	
	
	

}
