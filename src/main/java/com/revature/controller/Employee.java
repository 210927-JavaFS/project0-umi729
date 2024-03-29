package com.revature.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.service.EmployeePortal;
import com.revature.service.ValidationClass;

public class Employee  {
	private static Logger Log = LoggerFactory.getLogger(AdminController.class);
	private String userName;
	private int uid;
	private EmployeePortal cp;

	public Employee(String user, int uid) {
		this.userName = user;
		this.uid = uid;
		cp = new EmployeePortal(user, uid);
		Log.info("In controller: Employee constructor ");
	}

	public void viewCP() throws InputMismatchException, IOException {
		Log.info("In controller: Employee viewCP ");
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
				String accN = input.next();

				if (ValidationClass.isNumeric(accN)) {
					int acc = Integer.parseInt(accN);
					System.out.println("The balence of account is: ");
					cp.checkBal(acc);
				}
				System.out.println("=======================================================================");

				break;

			case "2":
				System.out.println("Please Enter Customer User Name: ");
				String str = input.nextLine().toLowerCase();
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
				accN = input.next();
				if (ValidationClass.isNumeric(accN)) {
					int acc = Integer.parseInt(accN);
					cp.viewProfile(acc);
				}
				System.out.println("=======================================================================");
				break;

			case "5":
				System.out.println("Please Enter Customer Account Number: ");
				accN = input.next();
				if (ValidationClass.isNumeric(accN)) {
					int acc = Integer.parseInt(accN);
					System.out.println("Please enter first name of Account Holder");
					String fname1 = input.next();
					cp.activate(acc, fname1);
				}
				System.out.println("=======================================================================");
				break;
			case "6":
				System.out.println("Please Enter Customer Account Number: ");
				accN = input.next();
				if (ValidationClass.isNumeric(accN)) {
					int acc = Integer.parseInt(accN);
					System.out.println("Please enter first name of Account Holder");
					String fname2 = input.next();
					cp.deactivate(acc, fname2);
				}
				System.out.println("=======================================================================");
				break;

			case "7":
				System.out.println("Please enter the account number to print statement");
				accN = input.next();
				if (ValidationClass.isNumeric(accN)) {
					int acc = Integer.parseInt(accN);
					cp.viewCustomerAccount(acc);
				}
				System.out.println("=======================================================================");
				break;
			case "8":
				
				System.out.println("=======================================================================");
				break;
			default:
				System.out.println("Something went wrong!!!");
				System.out.println("=======================================================================");
				break;
			}

		} while (!(option.equals("8")));

	}

}
