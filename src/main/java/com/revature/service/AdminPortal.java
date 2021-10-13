package com.revature.service;

import java.math.BigDecimal;

import com.revature.dao.BalanceDAO;
import com.revature.dao.BalanceDAOImpl;
import com.revature.dao.TransDAO;
import com.revature.dao.TransDAOImpl;

public class AdminPortal extends EmployeePortal{
	private BalanceDAO balDAO = new BalanceDAOImpl();
	//private TransDAO td = new TransDAOImpl();

	public AdminPortal(String userName, int acc) {
		super(userName, acc);
		// TODO Auto-generated constructor stub
	}
	
	public void createAccount() {
		
	}
	

	public boolean withdrawCash(BigDecimal bd, int acc_no) {
		return balDAO.withdraw(bd,acc_no);
	}

	public boolean transfer(BigDecimal bd3, int otherAcc2, int fromAcc) {
		return balDAO.transfer(bd3, otherAcc2, fromAcc);
	}

	public boolean Deposit(BigDecimal bd2, int depAcc) {
		return balDAO.deposit(bd2, depAcc);
	}
	
}
