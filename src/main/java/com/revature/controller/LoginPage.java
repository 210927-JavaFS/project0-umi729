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
		String user;
		String pass;
		String email;
		int zipCode;
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
									user= input.nextLine();
									System.out.println("Please enter your password");
									pass= input.nextLine();
									um.userLogin(user, pass);
					break;
					case 2:			System.out.println("Please enter your email registered with your account");
									
									while(!(vc.isValid(email= input.next()))) {
										System.out.println("Please enter a valid email");
									}
									System.out.println("Please enter your zipCode");
									while (!(vc.zipUS(String.valueOf(zipCode= input.nextInt())) )) {
										System.out.println("5 digit Zip Code is required");
									}
									
					um.getMyUserName(email, zipCode);
					break;
					case 3:;
					break;
					case 4:;
					break;
					default : continue;
					}
						
		}while (!(option == 4));
	}

}
