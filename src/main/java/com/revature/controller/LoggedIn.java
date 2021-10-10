package com.revature.controller;

import java.io.IOException;
import java.math.BigDecimal;
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
			System.out.println("Welcome to Our Bank ");
			
			System.out.println("How can i help you. Please select from following options: ");
			boolean validation = false;
			String option="6";
			Scanner input = new Scanner(System.in);
			do {
				System.out.println("1: Check balance\n"
						+ "2: Withraw Money\n"
						+ "3: Deposit Money\n"
						+ "4: Transfer Money\n"
						+ "5: Print your transactions \n"
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
						cp.checkBal(uid);
						System.out.println("Press any key to continue");
						input.nextLine();
						break;
						
						case "2"	: System.out.println("How much money you want to withdraw?");
									String str =input.nextLine();
									double dnum = Double.parseDouble(str);	
									BigDecimal bd= new BigDecimal(dnum);
									if(cp.withdrawCash(bd)) {
										System.out.println("You withdraw the money successfully\n");
										System.out.println("The current balence your account is now: ");
										cp.checkBal(uid);
										System.out.println("Press any key to continue");
										input.nextLine();
									}
									
									
									
						break;
						case "3"	: 	System.out.println("How much money you want to deposit?");
										String str1 =input.nextLine();								
										double dep = Double.parseDouble(str1);	
										BigDecimal bd2= new BigDecimal(dep);
										if(cp.Deposit(bd2)) {
										System.out.println("You deposit the money successfully\n");
										System.out.println("The current balence your account is now: ");
										cp.checkBal(uid);
										System.out.println("Press any key to continue");
										input.nextLine();
										}
						break;
						case "4"	: 	System.out.println("How much money you want to Transfer?");
										String str3 =input.nextLine();
										double amo = Double.parseDouble(str3);	
										System.out.println("Please provide the account number where you want to transfer:");
										String str4 =input.nextLine();
										int otherAcc = Integer.parseInt(str4);	
										BigDecimal bd3= new BigDecimal(amo);
										if(cp.transfer(bd3, otherAcc)) {
										System.out.println("Transfer the money successfully\n");
										System.out.println("The current balence your account is now: ");
										cp.checkBal(uid);
										System.out.println("Press any key to continue");
										input.nextLine();
										}
										
						break;
						
						case "5"	: cp.viewCustomerAccount(uid);;
						break;
						}
					
				} while (!(option.equals("6")));
			
			
		}
		

}
