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
			lg.accountNumber = 1235;// came from database
			
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
