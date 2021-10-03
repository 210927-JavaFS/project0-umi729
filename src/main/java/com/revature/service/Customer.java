package com.revature.service;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Customer{
	private String userName;
	private String password;
	private double balence;
	private String typeOfAccount;
	
	public String getTypeOfAccount() {
		return typeOfAccount;
	}


	public void setTypeOfAccount() {
		this.typeOfAccount = "Customer";
	}


	public Customer() {
		super();
	}
	
	
	// constructor
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalence() {
		return balence;
	}
	public void setBalence(double balence) {
		this.balence = balence;
	}
	
	public void createAccount() {
		
	}
	
	public void createAccount(ArrayList<String> fName, ArrayList<String> lName, ArrayList<String> email, 
			ArrayList<Integer> zipCode, int TotalAcctHolder,
			ArrayList<String> uName, ArrayList<String> pass
			
			) {
		
		 
		// Generate random integers in range 0 to 999
		SecureRandom rand = new SecureRandom();
	    int accountNumber = rand.nextInt(1000000);
	    // type of accout == "customer"
	    for (int i=0; i< TotalAcctHolder; i++) {
			System.out.printf("%d%5s%5s%5s%5d%5s%5s\n\n", accountNumber, fName.get(i),lName.get(i),email.get(i),zipCode.get(i),uName.get(i),pass.get(i));
			
		}
	    
	    
		
		System.out.println("Joint Account submitted for approval");
}

	public void resetPassword() {

	}

	

}
