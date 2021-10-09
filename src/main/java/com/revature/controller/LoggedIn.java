package com.revature.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.service.CustomerPortal;

public class LoggedIn {
	
	private String userName;
	private int uid;
	private CustomerPortal cp;
			
	public LoggedIn(String user, int uid) {
				this.userName= user;
				this.uid=uid;
				cp= new CustomerPortal(user, uid);
			}
			
			
	public LoggedIn() {
				super();
			}


	//update profile
	public void viewCP() throws InputMismatchException, IOException{
			System.out.println("welcome Name ");
			System.out.println("");// display information of user
			System.out.println();
			System.out.println("How can i help you. Please select from following options: ");
			boolean validation = false;
			String option="6";
			Scanner input = new Scanner(System.in);
			do {
				System.out.println("1: Check balance\n"
						+ "2: Withraw Money\n"
						+ "3: Deposit Money\n"
						+ "4: Transfer Money\n"
						+ "5: Update Account\n"
						+ "6: Logout");
				System.out.println();
				
				System.out.print("Press select options from 1-6: ");
				
				
				// validate the input
					do {
						if(input.hasNextInt()== true) {
							   option= input.nextLine();
							   validation = true;
							}
							else
							{
								 System.out.println("Please enter number from (1-6)");
								 input.next();
								 continue;
							}
						
					} while(validation== false);
				
					switch(option) {
					
						case "1"	: 
							//------------------------ user id selection  
							
						System.out.println("The current balence your account is: ");
						cp.checkBal(1);
						System.out.println("Press any key to continue");
						input.nextLine();
						break;
						
						case "2"	: //withdrawCash(100);// update cash
						break;
						case "3"	: //Deposit(100);// update case
						break;
						case "4"	: // transfer(100);//update)
						break;
						case "5"	: //
						break;
						case "6"	: ;
						break;
						}
					
				} while (!(option.equals("6")));
			
			
		}
		

}
