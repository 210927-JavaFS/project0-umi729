package com.revature.service;

import java.math.BigDecimal;
import java.util.ListIterator;

import com.revature.dao.BalanceDAO;
import com.revature.dao.BalanceDAOImpl;
import com.revature.dao.TransDAO;
import com.revature.dao.TransDAOImpl;
import com.revature.models.AccBalance;
import com.revature.models.TransactionTb;

public class CustomerPortal extends Portal {
	private BalanceDAO balDAO = new BalanceDAOImpl();
	private TransDAO td = new TransDAOImpl();

	public CustomerPortal(String userName, int acc) {
		super(userName, acc);
	}

	@Override
	public void checkBal(int acc) {

		AccBalance bal = balDAO.findByAccNumber(acc);
		System.out.println(bal.getBalance());
	}

	public boolean withdrawCash(BigDecimal amount) {

		return balDAO.withdraw(amount, getAcc());
	}

	public boolean Deposit(BigDecimal amount) {

		return balDAO.deposit(amount, getAcc());
	}

	public boolean transfer(BigDecimal amount, int oa) {

		return balDAO.transfer(amount, oa, getAcc());
	}

	public void viewCustomerAccount(int uid) {

		ListIterator<TransactionTb> lst = td.ListIterator(uid);

		System.out.printf("Transaction Date: Type of Trans: Amount:%n");

		while (lst.hasNext()) {
			TransactionTb rec = lst.next();
			System.out.print(rec.getDate());
			System.out.print("         ");
//			System.out.printf("%8s%8d%15d%10d", rec.getTranType(), rec.getUid(), rec.getToAccount(),
//					rec.getAcc_no());
			System.out.printf("%8s", rec.getTranType());	
			System.out.print("       ");
			System.out.print(rec.getAmount());
			System.out.println();
			
			

		}
	}

}
