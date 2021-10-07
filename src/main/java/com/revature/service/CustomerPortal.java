package com.revature.service;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerPortal extends Portal {
	
	
	protected CustomerPortal(String userName, int acc) {
		super(userName, acc);
	}
	protected double checkBal() {
		// get from database
		return 0.0;
	}
	protected final void withdrawCash(int amount) {
		// get from database
		System.out.println(checkBal());
		
	}
	protected void Deposit(int amount) {
		// get from database
		System.out.println(checkBal());
		
	}
	protected void transfer(int amount) {
		// get from database
		System.out.println(checkBal());
		
	}
	
	//update profile
	protected void viewCP() throws InputMismatchException, IOException{
		System.out.println("welcome Name ");
		System.out.println("");// display information of user
		System.out.println();
		System.out.println("How can i help you. Please select from following options: ");
		boolean validation = false;
		int option=1;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("1: Check balance");
			System.out.println("2: Withraw Money");
			System.out.println("3: Deposit Money");
			System.out.println("4: Transfer Money");
			System.out.println("5: Update Account");
			System.out.println("6: Logout");
			System.out.println();
			
			System.out.print("Press 1-6: ");
			
			
			// validate the input
				do {
					if(input.hasNextInt()== true) {
						   option= input.nextInt();
						}
						else
						{
							 System.out.println("Please enter number from (1-6)");
							 input.next();
							 continue;
						}
					if ((option <1) ) {
						System.out.println("Select a positive number");
						continue;
						
					}
					else if ((option > 6) ) {
						System.out.println("Select between 1 to 6");
						continue;
					}
					else {
					validation = true;
					}
				} while(validation== false);
			
				switch(option) {
				case 1	: checkBal();
				break;
				case 2	: 
					
					
					withdrawCash(100);// update cash
				break;
				case 3	: Deposit(100);// update case
				break;
				case 4	: transfer(100);//update)
				break;
				case 5	: checkBal();
				break;
				case 6	: ;
				break;
				}
				
			} while (option != 6);
		
		
	}

}
