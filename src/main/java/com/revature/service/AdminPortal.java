package com.revature.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.BalanceDAO;
import com.revature.dao.BalanceDAOImpl;
import com.revature.dao.LoginDAOImpl;

public class AdminPortal extends EmployeePortal{
	private static Logger Log = LoggerFactory.getLogger(AdminPortal.class);

	private BalanceDAO balDAO = new BalanceDAOImpl();
	private LoginDAOImpl logDAO = new LoginDAOImpl();
	//private TransDAO td = new TransDAOImpl();

	public AdminPortal(String userName, int acc) {
		super(userName, acc);
		Log.info("In adminportal: constructor ");
		// TODO Auto-generated constructor stub
	}
	
	public void createAccount() {	}
	

	public boolean withdrawCash(BigDecimal bd, int acc_no, int uid) {
		Log.debug("In adminportal: withdrawCash ");
		return balDAO.withdraw(bd,acc_no, uid);
	}

	public boolean transfer(BigDecimal bd3, int otherAcc2, int fromAcc, int uid) {
		Log.debug("In adminportal: transfer ");
		return balDAO.transfer(bd3, otherAcc2, fromAcc, uid);
	}

	public boolean Deposit(BigDecimal bd2, int depAcc, int uid) {
		Log.debug("In adminportal: Deposit ");
		return balDAO.deposit(depAcc, bd2 , uid);
	}
	public boolean upgrade(String user) {
		Log.debug("In adminportal: upgrade ");
		return logDAO.upgradeEmp(user);
	}

	public boolean viewCustomerAccount(String fname, String lname, String email, int pzipCode, String user) {
		Log.debug("In adminportal: viewCustomerAccount ");
		return logDAO.updateUser(fname, lname, email, pzipCode, user);
		
	}
	
	
}
