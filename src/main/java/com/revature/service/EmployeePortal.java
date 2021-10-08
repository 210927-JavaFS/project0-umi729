package com.revature.service;

import java.util.Scanner;

public class EmployeePortal extends Portal {
	
	//Constructor 
	protected EmployeePortal(String userName, int acc) {
		super(userName, acc);
	}
	
	
	protected void updateStatus() {
		// get from database
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Press a for approval or any key for deny");
		String option=scan.next();
		if(option.equals("a")) {
			approve();
		}
		else {
			deny();
		}
		scan.close();
	}
	
	
	protected void viewCustomerAccount(int AccNo) {
		// get from database
		
	}
	protected void viewCustomerAccount(String userName) {
		// get from database
		
	}
	protected void viewCustomerAccount(String fName, String lName, int zipCode) {
		// get from database
		
	}
	protected void approve() {
		
	}
	protected void deny() {
			
	}
	protected double checkBal(int acc) {
		return 0.0;
	}

}
