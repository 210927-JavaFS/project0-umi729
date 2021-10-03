package com.revature.service;

public class Portal {

	private String userName;
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getAcc() {
		return acc;
	}


	public void setAcc(int acc) {
		this.acc = acc;
	}


	private int acc;
	//constructor
	protected Portal(String userName, int acc) {
		this.userName=userName;
		this.acc=acc;
	}
	
	
	//
	protected double checkBal(int acc) {
		// get from database
		return 0.0;
	}
	protected void updateAccount() {
		// get from database
		
	}
	protected void viewAccount() {
		// get from database
		
	}
	
	
	
	

}
