package com.revature.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.LoginPage;

public class UserManagement {
	private static Logger Log=LoggerFactory.getLogger(UserManagement.class);
	public void userLogin(String userName, String password) throws InputMismatchException, IOException {
		
		// select * from login where username = userName and pwd =password; 
		
		// if found in database
		if(true) {
			Log.info("login Successfully ");
			Login lg=Login.INSTANCE;
			lg.userName = "Umer1";
			lg.uid = 1;// select uid
			lg.status= "active";// select active
			lg.type="Employee"	;	//select type
			lg.show();
			
		}
		else {
			Log.warn("unsuccessful login attempt ");
			System.out.println("Could not find user/password in database");
		}
	}
	
	public String getMyUserName(String email, int zipCode) {
		Log.info("username searching ");
		/* SELECT user_name FROM login l
			JOIN account a
			ON l.aid = a.aid
			WHERE email = 'umi729@gmail.com' 
			AND zipcode = 85008
		
		*/
		
		return "username";
	}
	public void resetPassword(String userName, String email, int zipCode) {
		
		/*SELECT pwd FROM login l
			JOIN account a
			ON l.aid = a.aid
			WHERE email = 'umi729@gmail.com' 
			AND zipcode = 85008
			AND user_name = 'Umer1'
*/
		
		
		// information matched. Creating new password
		System.out.println("Information matched please create your password");
		Log.info("password reseting ");
		int count=0;
		do {
			System.out.println("Enter new password");
			Scanner input = new Scanner(System.in);
			String a= input.next();
			System.out.println("Re-enter password");
			String b= input.next();
			if(a.equals(b)) {
				/* UPDATE login 
				SET pwd = 'abc' 
				WHERE user_name = 'Umer1'*/
				Log.info("password reset");
				System.out.println("Password resetted");
				break;
			}
			else {
				System.out.println("Password mismatched");
				Log.info("password missmatched ");
				count++;
			}
		}while (count < 3);
		
	}
}
