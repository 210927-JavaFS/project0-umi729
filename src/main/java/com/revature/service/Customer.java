package com.revature.service;

import java.security.SecureRandom;
import java.util.ArrayList;

public class Customer extends Account{
	private String userName;
	private String password;
	private double balence;
	
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
		System.out.println(getFirstName());
		System.out.println(getLastName());
		System.out.println(getEmail());
		System.out.println(getZipCode());
		 
		// Generate random integers in range 0 to 999
		SecureRandom rand = new SecureRandom();
	    int accountNumber = rand.nextInt(1000000);
		
		System.out.println("Account submitted for approval");
}
	public void createAccount(ArrayList<String> jNames) {
		System.out.println(getFirstName());
		System.out.println(getLastName());
		System.out.println(getEmail());
		System.out.println(getZipCode());
		 
		// Generate random integers in range 0 to 999
		SecureRandom rand = new SecureRandom();
	    int accountNumber = rand.nextInt(1000000);
	    
	    for (String string : jNames) {
			System.out.println(string);
		}
	    
	    
		
		System.out.println("Joint Account submitted for approval");
}

	public void resetPassword() {

	}

	

}
