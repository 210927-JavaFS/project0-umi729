package com.revature.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.service.EmployeePortal;

public class Employee {

	private String userName;
	private int uid;
	private EmployeePortal cp;

	public Employee(String user, int uid) {
		this.userName = user;
		this.uid = uid;
		cp = new EmployeePortal(user, uid);
	}

	public void viewCP() throws InputMismatchException, IOException {
		System.out.println("Welcome to Our Bank ");
		System.out.println(" Please select from following options: ");
		boolean validation = false;
		String option = "6";
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("1: Check Customer balance\n " + "2: Check Customer Profile\n "
					+ "3: Print Customer transactions \n " + "4: Activate/deactivate Custormer Account\n"
					+ "5: Logout");
			System.out.print("Press select options from 1-5: ");

			// validate the input
			do {
				if (input.hasNext() == true) {
					option = input.nextLine();
					validation = true;
				} else {
					System.out.println("Please enter number from (1-5)");
					input.next();
					continue;
				}

			} while (validation == false);

			switch (option) {

			case "1":
				System.out.println("Please Enter Customer Account number: ");
				System.out.println("The current balence your account is: ");
				int acc= Integer.parseInt(input.next());
				cp.checkBal(acc);
				System.out.println("Press any key to continue");
				input.nextLine();
				break;

			case "2":
				System.out.println("How much money you want to withdraw?");
				String str = input.nextLine();
				double dnum = Double.parseDouble(str);
				BigDecimal bd = new BigDecimal(dnum);
				

				break;
			case "3":
				System.out.println("How much money you want to deposit?");
				String str1 = input.nextLine();
				double dep = Double.parseDouble(str1);
				BigDecimal bd2 = new BigDecimal(dep);
				
				
				break;
			case "4":
				System.out.println("How much money you want to Transfer?");
				String str3 = input.nextLine();
				double amo = Double.parseDouble(str3);
				System.out.println("Please provide the account number where you want to transfer:");
				String str4 = input.nextLine();
				int otherAcc = Integer.parseInt(str4);
				BigDecimal bd3 = new BigDecimal(amo);
				
				break;

			case "5":
				
				;
				break;
			}

		} while (!(option.equals("6")));

	}

}
