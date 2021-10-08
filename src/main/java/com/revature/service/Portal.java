package com.revature.service;

 abstract class Portal {

	private String userName;
	private int acc;
	//constructor
	
	protected Portal(String userName, int acc) {
		this.userName=userName;
		this.acc=acc;
	}
	
	// getter setter
	protected String getUserName() {
		return userName;
	}


	protected void setUserName(String userName) {
		this.userName = userName;
	}


	protected int getAcc() {
		return acc;
	}


	protected void setAcc(int acc) {
		this.acc = acc;
	}

//-------------------------------------------------
	
	// Methods
	protected abstract double checkBal(int acc) ;
	protected  void updateAccount(String userName, int uid) {
		
	};
	protected abstract void viewCustomerAccount(int AccNo) ;
	
	
	

}
