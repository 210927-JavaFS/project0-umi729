package com.revature.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.service.UserManagement;
import com.revature.service.ValidationClass;


public class LoginPage {
	
	private static Logger Log=LoggerFactory.getLogger(LoginPage.class);
	
	public void loginInfo() throws InputMismatchException, IOException {
	
		Log.info("In controller: login input ");
		
		ValidationClass vc=new ValidationClass();
		// 
		
		UserManagement um=new UserManagement();
		
		System.out.println("Please logon to system");
		System.out.println();
		System.out.println("Please select from following options");
		Scanner input=new Scanner(System.in);
		String option="4";
		String user=null;
		String pass=null;
		String email=null;
		int zipCode=0;
		boolean validation = false;
		do {
			System.out.println("1: Enter user credentials \n"
					+ "2: Forget User Name \n"
					+ "3: Forget password \n"
					+ "4: Exit ");
			
				// validate the input
					do {
						if(input.hasNext()== true) {
							   option= input.nextLine();
							   validation = true;
							}
							else
							{
								 System.out.println("Please enter number from (1-4)");
								 input.next();
								 continue;
							}
						
					} while(validation== false);
					
//Condition testing where the code should go
					switch(option) {
					
						case "1":	System.out.println("Please enter your username");
									if (input.hasNext()) {
										user= input.next();
									}
									
									System.out.println("Please enter your password");
									if (input.hasNext()) {
										
										// not stopping here for user input
										pass= input.next();
										
									}
									
										if(user!=null )	{
											if( ! (pass == null) ){//even password is null but it is continue going in block{
												// call userManagement Class
												Log.debug("Username and password has taken by user");
												um.userLogin(user, pass);
											}
										}
									
										break;
// trying to find username by using email and zip code						
						case "2":	System.out.println("Please enter your email registered with your account");
									
									while(!(vc.isValid(email= input.next()))) {
										System.out.println("Please enter a valid email");
									}
									System.out.println("Please enter your zipCode");
									
									while (!(vc.zipUS(String.valueOf(zipCode= input.nextInt())) )) {
										System.out.println("5 digit Zip Code is required");
									}
// calling getmyusername method from usermanagement Class
									Log.debug("Email and zip code has taken by user in case (2) switch statement");
									System.out.println(um.getMyUserName(email, zipCode));
									break;
									
// resetting password after verifying username email and password
						case "3":	System.out.println("Please enter your User name");
									user= input.next();
									System.out.println("Please enter your email registered with your account");
									
									while(!(vc.isValid(email= input.next()))) {
										System.out.println("Please enter a valid email");
									}
									
									System.out.println("Please enter your zipCode");
									
									while (!(vc.zipUS(String.valueOf(zipCode= input.nextInt())) )) {
										System.out.println("5 digit Zip Code is required");
									}
//call reset User name method from usermanagement Class
									Log.debug("User, Email and zip code has taken by user in case (2) switch statement");
									um.resetPassword(user, email, zipCode);
									break;
						case "4":;
									break;
						
						default : System.out.println("It was not valid entry. ");;
					}
						
		}while (!(option.equals("4")));
	}

}
