package com.revature.service;

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
		
		System.out.println("Account submitted for approval");
}

	public void resetPassword() {

	}

	

}
