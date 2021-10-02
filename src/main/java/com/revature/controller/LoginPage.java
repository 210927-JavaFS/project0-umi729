package com.revature.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.service.UserManagement;
import com.revature.service.ValidationClass;

public class LoginPage {
	
	
	public void loginInfo() throws InputMismatchException, IOException {
		ValidationClass vc=new ValidationClass();
		UserManagement um=new UserManagement();
		System.out.println("Please logon to system");
		System.out.println();
		System.out.println("Please select from following options");
		
		Scanner input=new Scanner(System.in);
		int option=0;
		String user=null;
		String pass=null;
		String email=null;
		int zipCode=0;
		boolean validation = false;
		do {
			System.out.println("1: Enter user credentials ");
			System.out.println("2: Forget User Name ");
			System.out.println("3: Forget password ");
			System.out.println("4: Exit ");
			
			
				
				
				// validate the input
					do {
						if(input.hasNextInt()== true) {
							   option= input.nextInt();
							}
							else
							{
								 System.out.println("Please enter number from (1-4)");
								 input.next();
								 continue;
							}
						if ((option <1) ) {
							System.out.println("Select a positive number");
							continue;
							
						}
						else if ((option > 4) ) {
							System.out.println("Select between 1 to 4");
							continue;
						}
						else {
						validation = true;
						}
					} while(validation== false);
				
					switch(option) {
						case 1:		System.out.println("Please enter your username");
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
												um.userLogin(user, pass);
											}
										}
									
						break;
						case 2:		System.out.println("Please enter your email registered with your account");
									
									while(!(vc.isValid(email= input.next()))) {
										System.out.println("Please enter a valid email");
									}
									System.out.println("Please enter your zipCode");
									while (!(vc.zipUS(String.valueOf(zipCode= input.nextInt())) )) {
										System.out.println("5 digit Zip Code is required");
									}
// call getmyusername method from usermanagement Class
									System.out.println(um.getMyUserName(email, zipCode));
						break;
						case 3:		System.out.println("Please enter your User name");
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
						um.resetPassword(user, email, zipCode);
						break;
						case 4:;
						break;
						default : System.out.println("It was not valid entry. ");;
					}
						
		}while (!(option == 4));
	}

}
