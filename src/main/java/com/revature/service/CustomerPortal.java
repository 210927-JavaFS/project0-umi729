package com.revature.service;

public class CustomerPortal {
	private String userName;
	private int acc;
	
	protected CustomerPortal(String userName, int acc) {
		this.userName=userName;
		this.acc=acc;
	}
	protected double checkBal() {
		// get from database
		return 0.0;
	}
	protected void widrawCash(int amount) {
		// get from database
		System.out.println(checkBal());
		
	}
	protected void Deposit(int amount) {
		// get from database
		System.out.println(checkBal());
		
	}
	protected void transfer(int amount) {
		// get from database
		System.out.println(checkBal());
		
	}

}
