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
					+ "3: Pending applications for approval \n" + "4: Check Account Profile \n"
					+ "5: Activate Custormer Account \n" + "6: Deactivate Custormer Account \n"
					+ "7: Print Customer transactions \n" + "8: Withdraw Money from Customer Account \n"
					+ "9: Transfer Money between Accounts \n" + "10: Deposit Money in Account \n"
					+ "11: Create Customer/Employee Account \n" + "12: Update Customer Profile \n"
					+ "13: Upgrade to Employee account \n" + "0: Logout");
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
				System.out.println("How much money you want to withdraw?");
				String str2 = input.nextLine();
				double dnum = 0;
				if (ValidationClass.isDouble(str2)) {
					dnum = Double.parseDouble(str2);
					BigDecimal bd = new BigDecimal(dnum);
					System.out.println("Please provide the account from where you want to withdraw money:");
					accN = input.next();
					if (ValidationClass.isNumeric(accN)) {
						int acc = Integer.parseInt(accN);
						if (cp.withdrawCash(bd, acc, uid)) {
							System.out.println("You withdraw the money successfully\n");
							System.out.println("The current balence your account is now: ");
							cp.checkBal(acc);
							System.out.println("Press any key to continue");
							input.nextLine();
						}
					}
				}
				System.out.println("=======================================================================");
				break;
			case "9":
				System.out.println("How much money you want to Transfer?");
				String str3 = input.nextLine();
				dnum = 0;
				if (ValidationClass.isDouble(str3)) {
					dnum = Double.parseDouble(str3);
					System.out.println("Please provide the account number **From** you want to transfer:");
					String str6 = input.nextLine();
					if (ValidationClass.isNumeric(str6)) {
						int fromAcc = Integer.parseInt(str6);
						System.out.println("Please provide the account number where you want to transfer:");
						String str7 = input.nextLine();
						if (ValidationClass.isNumeric(str7)) {
							int otherAcc2 = Integer.parseInt(str7);
							BigDecimal bd3 = new BigDecimal(dnum);
							if (cp.transfer(bd3, otherAcc2, fromAcc, uid)) {
								System.out.println("Transfer the money successfully\n");
								System.out.println("Credited account balance: ");
								cp.checkBal(fromAcc);
								System.out.println("Debited account balance: ");
								cp.checkBal(otherAcc2);
								System.out.println("Press any key to continue");
								input.nextLine();
							}
						}
					}
				}
				System.out.println("=======================================================================");
				break;
			case "10":
				System.out.println("How much money you want to deposit?");
				String str1 = input.nextLine();
				dnum = 0;
				if (ValidationClass.isDouble(str1)) {
					dnum = Double.parseDouble(str1);
					BigDecimal bd2 = new BigDecimal(dnum);
					System.out.println("Please provide the account number in which you want to deposit money");
					String str8 = input.nextLine();

					if (ValidationClass.isNumeric(str8)) {
						int depAcc = Integer.parseInt(str8);
						if (cp.Deposit(bd2, depAcc, uid)) {
							System.out.println("You deposit the money successfully\n");
							System.out.println("The current balence your account is now: ");
							cp.checkBal(depAcc);
							System.out.println("Press any key to continue");
							input.nextLine();
						}
					}
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
				ValidationClass vc= new ValidationClass();
				System.out.println("Please enter the user name of account you want to update");
				String username = input.next().toLowerCase();
				System.out.println("Enter First Name: ");
				String fname = input.next().toLowerCase();
				

				System.out.println("Enter Last Name: ");
				String lname=input.next();

				System.out.println("Enter Email Address: ");
				String eemail;

				while (!(vc.isValid(eemail = input.next()))) {
					System.out.println("Please enter a valid email");
				}
				String email=eemail;

				System.out.println("Enter your ZipCode: ");
				int pzipCode = 0;
				validation = false;
				do {
					if (input.hasNextInt() == true) {
						pzipCode = input.nextInt();
					} else {
						System.out.println("Please enter 5 digit Zip Code");
						input.next();
						continue;
					}
					if ((pzipCode < 1)) {
						System.out.println("Select a positive number");
						continue;

					} else if (!(vc.zipUS(String.valueOf(pzipCode)))) {
						System.out.println("5 digit Zip Code is required");
						continue;
					} else {

						
						validation = true;
					}

				} while (validation == false);

				if(cp.viewCustomerAccount(fname, lname, email, pzipCode,username) ){
					System.out.println("Update Successfully");
				}
				System.out.println("=======================================================================");
				break;
			case "13":
				System.out.println("Please enter username of employee");
				String user=input.next().toLowerCase();
				if(cp.upgrade(user)) {
					System.out.printf("Successful!!! %s can login as Employee", user);
				}
				
				System.out.println("=======================================================================");
				break;

			default:
				System.out.println("Log Out");
				System.out.println("=======================================================================");
				break;
			}

		} while (!(option.equals("0")));

	}

}
