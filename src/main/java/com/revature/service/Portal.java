package com.revature.service;

 abstract class Portal {

	private String userName;
	private int acc;
	//constructor
	
	public Portal(String userName, int acc) {
		this.userName=userName;
		this.acc=acc;
	}
	
	// getter setter
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

//-------------------------------------------------
	
	// Methods
	public abstract void checkBal(int acc) ;
	public  void updateAccount(String userName, int uid) {
		
	};
	public abstract void viewCustomerAccount(int AccNo) ;
	
	
	

}
