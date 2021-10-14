package com.revature.service;

import java.math.BigDecimal;

import com.revature.dao.BalanceDAO;
import com.revature.dao.BalanceDAOImpl;
import com.revature.dao.LoginDAOImpl;

public class AdminPortal extends EmployeePortal{
	private BalanceDAO balDAO = new BalanceDAOImpl();
	private LoginDAOImpl logDAO = new LoginDAOImpl();
	//private TransDAO td = new TransDAOImpl();

	public AdminPortal(String userName, int acc) {
		super(userName, acc);
		// TODO Auto-generated constructor stub
	}
	
	public void createAccount() {
		
	}
	

	public boolean withdrawCash(BigDecimal bd, int acc_no, int uid) {
		return balDAO.withdraw(bd,acc_no, uid);
	}

	public boolean transfer(BigDecimal bd3, int otherAcc2, int fromAcc, int uid) {
		return balDAO.transfer(bd3, otherAcc2, fromAcc, uid);
	}

	public boolean Deposit(BigDecimal bd2, int depAcc, int uid) {
		return balDAO.deposit(depAcc, bd2 , uid);
	}
	public boolean upgrade(String user) {
		return logDAO.upgradeEmp(user);
	}

	public boolean viewCustomerAccount(String fname, String lname, String email, int pzipCode, String user) {
		return logDAO.updateUser(fname, lname, email, pzipCode, user);
		
	}
	
	
}
