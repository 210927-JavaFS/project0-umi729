package com.revature.service;

import java.io.IOException;
import java.util.InputMismatchException;

public class UserManagement {

	public void userLogin(String userName, String password) throws InputMismatchException, IOException {
		//username found in database
		// password matched to username
		//check account approved
		
		
		if(true) {
			Login lg=Login.INSTANCE;
			lg.userName = userName;
			lg.uid = 1235;// came from database
			lg.status="Approved";// getting from table 
			lg.type="Employee"	;	// getting from table
			lg.show();
			
		}
	}
	
	public String getMyUserName(String email, int zipCode) {
		
		return "username";
	}
	public void resetPassword(String userName, String email, int zipCode) {
		
		if(true) {
			// set password
		}
	}
}
