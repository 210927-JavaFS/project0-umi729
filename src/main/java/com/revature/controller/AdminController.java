package com.revature.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.service.AdminPortal;
import com.revature.service.ValidationClass;

public class AdminController {

	private String userName;
	private int uid;
	private AdminPortal cp;

	public AdminController(String user, int uid) {
		this.userName = user;
		this.uid = uid;
		cp = new AdminPortal(user, uid);
	}

	public void viewCP() throws InputMismatchException, IOException {
		System.out.println("Admin Management Service ");
		System.out.println(" Please select from following options: ");
		boolean validation = false;
		String option = "0";
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("1: Check balance by Account Number \n" + "2: Check Balance by User Name \n"
					+ "3: Pending applications for approval \n" + "4: Check Customer Profile \n"
					+ "5: Activate Custormer Account \n" + "6: Deactivate Custormer Account \n"
					+ "7: Print Customer transactions \n" + "8: Withdraw Money from Customer Account \n"
					+ "9: Transfer Money between Accounts \n" + "10: Deposit Money in Account \n"
					+ "11: Create Customer/Employee Account \n" + "12: Update Customer Profile \n"
					+ "13: Upgrate to Employee account \n" + "0: Logout");
			System.out.print("Press select options from 1-13 \n");

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
				int acc2 = Integer.parseInt(input.next());
				cp.viewProfile(acc2);
				System.out.println("=======================================================================");
				break;

			case "5":
				System.out.println("Please Enter Customer Account Number: ");
				int acc3 = Integer.parseInt(input.next());
				System.out.println(acc3);
				System.out.println("Please enter first name of Account Holder");
				String fname1 = input.next();
				// cp.activate(acc3, fname1);
				;
				System.out.println("=======================================================================");
				break;
			case "6":
				System.out.println("Please Enter Customer Account Number: ");
				int acc4 = Integer.parseInt(input.next());
				System.out.println("Please enter first name of Account Holder");
				String fname2 = input.next();
				cp.deactivate(acc4, fname2);
				;
				System.out.println("=======================================================================");
				break;

			case "7":
				System.out.println("Please enter the account number to print statement");
				cp.viewCustomerAccount(Integer.parseInt(input.next()));
				System.out.println("=======================================================================");
				break;
			case "8":
				System.out.println("How much money you want to withdraw?");
				String str2 = input.nextLine();
				double dnum = Double.parseDouble(str2);
				BigDecimal bd = new BigDecimal(dnum);
				System.out.println("Please provide the account from where you want to withdraw money:");
				String str4 = input.nextLine();
				int acc_no = Integer.parseInt(str4);
				if (cp.withdrawCash(bd, acc_no)) {
					System.out.println("You withdraw the money successfully\n");
					System.out.println("The current balence your account is now: ");
					cp.checkBal(uid);
					System.out.println("Press any key to continue");
					input.nextLine();
				}
				System.out.println("=======================================================================");
				break;
			case "9":
				System.out.println("How much money you want to Transfer?");
				String str3 = input.nextLine();
				double amo = Double.parseDouble(str3);
				System.out.println("Please provide the account number **From** you want to transfer:");
				String str6 = input.nextLine();
				int fromAcc = Integer.parseInt(str6);
				System.out.println("Please provide the account number where you want to transfer:");
				String str7 = input.nextLine();
				int otherAcc2 = Integer.parseInt(str7);
				BigDecimal bd3 = new BigDecimal(amo);
				if (cp.transfer(bd3, otherAcc2, fromAcc)) {
					System.out.println("Transfer the money successfully\n");
					System.out.println("The current balence your account is now: ");
					cp.checkBal(uid);
					System.out.println("Press any key to continue");
					input.nextLine();
				}
				System.out.println("=======================================================================");
				break;
			case "10":
				System.out.println("How much money you want to deposit?");
				String str1 = input.nextLine();
				double dep = Double.parseDouble(str1);
				BigDecimal bd2 = new BigDecimal(dep);
				System.out.println("Please provide the account number in which you want to deposit money");
				String str8 = input.nextLine();
				int depAcc = Integer.parseInt(str8);
				if (cp.Deposit(bd2, depAcc)) {
					System.out.println("You deposit the money successfully\n");
					System.out.println("The current balence your account is now: ");
					cp.checkBal(uid);
					System.out.println("Press any key to continue");
					input.nextLine();
				}
				System.out.println("=======================================================================");
				break;
			case "11":

				// System.out.println("Please enter the account number to print statement");
				NewProfile np = new NewProfile();
				np.createProfile();

				System.out.println("=======================================================================");
				break;
			case "12":
				System.out.println("Please enter the account number to print statement");
				cp.viewCustomerAccount(Integer.parseInt(input.next()));
				System.out.println("=======================================================================");
				break;
			case "13":
				System.out.println("Please enter the account number to print statement");
				cp.viewCustomerAccount(Integer.parseInt(input.next()));
				System.out.println("=======================================================================");
				break;

			default:
				System.out.println("Something went wrong!!!");
				System.out.println("=======================================================================");
				break;
			}

		} while (!(option.equals("0")));

	}

}
