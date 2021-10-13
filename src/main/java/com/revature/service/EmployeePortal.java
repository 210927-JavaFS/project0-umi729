package com.revature.service;

import java.util.ListIterator;

import com.revature.dao.BalanceDAO;
import com.revature.dao.BalanceDAOImpl;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.dao.TransDAO;
import com.revature.dao.TransDAOImpl;
import com.revature.models.AccBalance;
import com.revature.models.ApPen;
import com.revature.models.TransactionTb;

public class EmployeePortal extends Portal {

	private BalanceDAO balDAO = new BalanceDAOImpl();
	private LoginDAO logDAO = new LoginDAOImpl();

	// Constructor
	public EmployeePortal(String userName, int acc) {
		super(userName, acc);
	}

	public void activate(int acc, String fname) {
		if(logDAO.activate(acc, fname)) {
			System.out.println("Account Activated");
		}
		else {
			System.out.println("Something went wrong!!1");
		}
	}

	public void deactivate(int acc, String fname) {
		if(logDAO.deactivate(acc, fname)) {
			System.out.println("Account Deactivated");
		}
		else {
			System.out.println("Something went wrong!!1");
		}
	}

	public void checkBal(int acc) {

		AccBalance bal = balDAO.findByAcc(acc);
		if (!(bal.getBalance() == null)) {
			System.out.println("Account No: " + bal.getBalance());
		} else
			System.out.println("Couldn't find account");
	}

	public void checkBalByUser(String user) {

		AccBalance bal = balDAO.findByUserName(user);
		if (!(bal.getBalance() == null)) {
			System.out.println("Account No: " + bal.getId());
			System.out.println("Balance: " + bal.getBalance());
		} else
			System.out.println("Couldn't find account");

	}

	@Override
	public void viewCustomerAccount(int AccNo) {
		TransDAO td = new TransDAOImpl();
		ListIterator<TransactionTb> lst = td.ListIterat(AccNo);

		System.out.printf("Transaction Date: Amount: Type of Trans: UserID: ToAccount No: FromAccount%n");

		while (lst.hasNext()) {
			TransactionTb rec = lst.next();
			System.out.print(rec.getDate());
			System.out.print("         ");
			System.out.print(rec.getAmount());
			System.out.printf("  %8s  %8d %15d %10d %n", rec.getTranType(), rec.getUid(), rec.getToAccount(),
					rec.getAcc_no());

		}

	}

	public void viewPendApp() {
		
		ListIterator<ApPen> lst = logDAO.ListIterator();

		//System.out.printf("Transaction Date: Amount: Type of Trans: UserID: ToAccount No: FromAccount%n");

		while (lst.hasNext()) {
			ApPen rec = lst.next();
			System.out.println(rec.toString());
			
		}
	}

		public void viewProfile(int acc) {
		
		System.out.println(logDAO.proFileReport(acc));

		//System.out.printf("Transaction Date: Amount: Type of Trans: UserID: ToAccount No: FromAccount%n");

		
	}
}
