package com.revature.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.dao.BalanceDAO;
import com.revature.dao.BalanceDAOImpl;
import com.revature.models.AccBalance;

public class CustomerPortal extends Portal {
	private BalanceDAO balDAO= new BalanceDAOImpl();
	
	public CustomerPortal(String userName, int acc) {
		super(userName, acc);
	}
	@Override
	public void checkBal(int acc) {
		
		AccBalance bal= balDAO.findByAccNumber(acc);
		System.out.println(bal.getBalance());
	}

	protected final void withdrawCash(int amount) {
		// get from database
		//System.out.println(checkBal());
		
	}
	protected void Deposit(int amount) {
		// get from database
	//	System.out.println(checkBal());
		
	}
	protected void transfer(int amount) {
		// get from database
		//System.out.println(checkBal());
		
	}
	protected void viewCustomerAccount(int AccNo) {
		
	}
	
	
	
	

}
