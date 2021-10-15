package com.revature.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.BankMS;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.AccountTb;
import com.revature.models.LoginTb;
import com.revature.service.UserManagement;
import com.revature.service.ValidationClass;

public class NewProfile {
	private static Logger Log = LoggerFactory.getLogger(NewProfile.class);
	List<AccountTb> la = new ArrayList<>();
	List<LoginTb> ll = new ArrayList<>();

	public void createProfile() throws InputMismatchException, IOException {
		Log.info("Creating new profile Method createProfile in new profile class ");
		System.out.println("Welcome to our bank");
		System.out.println("=============================================");
		System.out.println("Please provide the following information\n");

		Scanner scan = new Scanner(System.in);
		boolean validation = false;
		ValidationClass vc = new ValidationClass();

		int option = 0;
		BigDecimal bd = null;
		System.out.println("Enter number of Account Holder(Max 10) or 0 for Exit:");

		do {

			if (scan.hasNextInt() == true) {
				option = scan.nextInt();

			} else {
				System.out.println("Please enter number from (1-10)");
				scan.next();
				continue;
			}

			if (vc.validateIntInput(option, 1, 10)) {

				for (int i = 1; i <= option; i++) {
					AccountTb atb = new AccountTb();// = new AccountTb();
					LoginTb ltb = new LoginTb();

					System.out.printf("Person Number: %d%n", i);

					System.out.println("Enter First Name: ");
					String str = scan.next().toLowerCase();
					atb.setfName(str);

					System.out.println("Enter Last Name: ");
					atb.setlName(scan.next());

					System.out.println("Enter Email Address: ");
					String eemail;

					while (!(vc.isValid(eemail = scan.next()))) {
						System.out.println("Please enter a valid email");
					}
					atb.setEmail(eemail);

					System.out.println("Enter your ZipCode: ");
					int pzipCode = 0;
					validation = false;
					do {
						if (scan.hasNextInt() == true) {
							pzipCode = scan.nextInt();
						} else {
							System.out.println("Please enter 5 digit Zip Code");
							scan.next();
							continue;
						}
						if ((pzipCode < 1)) {
							System.out.println("Select a positive number");
							continue;

						} else if (!(vc.zipUS(String.valueOf(pzipCode)))) {
							System.out.println("5 digit Zip Code is required");
							continue;
						} else {

							atb.setZipCode(pzipCode);
							validation = true;
						}

					} while (validation == false);
					System.out.println("Create User Name ");
					LoginDAOImpl ldo = new LoginDAOImpl();
					String usr = null;
					boolean availibility = false;

					while (!(availibility)) {
						usr = scan.next().toLowerCase();
						availibility = ldo.findByUser(usr);
						if (availibility) {
							availibility = false;
							System.out.println("This username has already been taken, please try another!\n>>>");
							continue;
						} else {

							break;
						}
					}
					ltb.setUserName(usr);

					System.out.println("Create password");
					ltb.setPwd(scan.next().toLowerCase());
					ltb.setStatus("Active");
					ltb.setaType("Cus");
					ll.add(ltb);
					// System.out.println(ll);
					la.add(atb);
					// System.out.println(la);

				}
				option = 0;

			} else {
				continue;
			}
			System.out.println("Enter the amount you want as initial deposit (100-500) ");

			int bal = 0;
			validation = false;

			do {
				if (scan.hasNextInt() == true) {

					bal = scan.nextInt();
				} else {
					System.out.println("Please enter in numbers");

					scan.next();
					continue;
				}

				if (vc.validateIntInput(bal, 100, 500)) {

					bd = new BigDecimal(bal);
					validation = true;
				} else {

					continue;
				}

			} while (validation == false);

			// System.out.println(option);
		} while (option > 0);
		// System.out.println("6");
		UserManagement um = new UserManagement();
		Log.debug("calling usermanagement object to register ");
		um.createAccount(bd, la, ll);
		// System.out.println("in new profile");

	}
}
