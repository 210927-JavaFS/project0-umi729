package com.revature.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.service.EmployeePortal;

public class Employee  {

	private String userName;
	private int uid;
	private EmployeePortal cp;

	public Employee(String user, int uid) {
		this.userName = user;
		this.uid = uid;
		cp = new EmployeePortal(user, uid);
	}

	public void viewCP() throws InputMismatchException, IOException {
		System.out.println("Employee Management Service ");
		System.out.println(" Please select from following options: ");
		boolean validation = false;
		String option = "6";
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("1: Check balance by Account Number \n"
					+ "2: Check Balance by User Name \n"
					+ "3: Pending applications for approval \n"
					+ "4: Check Customer Profile \n"
					+ "5: Activate Custormer Account \n"
					+ "6: Deactivate Custormer Account \n"
					+ "7: Print Customer transactions \n"
					+ "8: Logout");
			System.out.print("Press select options from 1-8: ");

			// validate the input
			do {
				if (input.hasNext() == true) {
					option = input.nextLine();
					validation = true;
				} else {
					System.out.println("Please enter number from (1-8)");
					input.next();
					continue;
				}

			} while (validation == false);

			switch (option) {

			case "1":
				System.out.println("Please Enter Customer Account number: ");
				int acc = Integer.parseInt(input.next());
				System.out.println("The balence of account is: ");
				cp.checkBal(acc);
				System.out.println("=======================================================================");

				break;

			case "2":
				System.out.println("Please Enter Customer User Name: ");
				String str = input.nextLine();
				cp.checkBalByUser(str);
				System.out.println("The balence of account is: ");
				System.out.println("=======================================================================");

				break;
			case "3":
				System.out.println("Pending Accounts for approvals:\n");
				cp.viewPendApp();
				System.out.println("=======================================================================");
				break;
			case "4":
				System.out.println("Please Enter Customer Account Number: ");
				int acc2 = Integer.parseInt(input.next());
				cp.viewProfile(acc2);
				System.out.println("=======================================================================");
				break;

			case "5":
				System.out.println("Please Enter Customer Account Number: ");
				int acc3 = Integer.parseInt(input.next());
				System.out.println("Please enter first name of Account Holder");
				String fname1=input.next();
				cp.activate(acc3, fname1);;
				System.out.println("=======================================================================");
				break;
			case "6":
				System.out.println("Please Enter Customer Account Number: ");
				int acc4 = Integer.parseInt(input.next());
				System.out.println("Please enter first name of Account Holder");
				String fname2=input.next();
				cp.deactivate(acc4, fname2);;
				
				System.out.println("=======================================================================");
				break;
			
			case "7":
				System.out.println("Please enter the account number to print statement");
				cp.viewCustomerAccount(Integer.parseInt(input.next()));
				System.out.println("=======================================================================");
				break;

			default:
				System.out.println("Something went wrong!!!");
				System.out.println("=======================================================================");
				break;
			}

		} while (!(option.equals("7")));

	}

}
