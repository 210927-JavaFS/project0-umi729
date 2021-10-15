package com.revature.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.service.ValidationClass;

public class Welcome {
	private static Logger Log = LoggerFactory.getLogger(Welcome.class);
	public void drive() {
		ValidationClass vc;
		
		Log.info("In controller: Welcome input ");
		try (Scanner input = new Scanner(System.in)) {
			String option = "0";
		
			vc = new ValidationClass();
			// taking input from user
			do {
				System.out.println("1: Sign up \n" + "2: Sign in \n" + "3: Exit");

				System.out.print("Please select 1-3: ");

				if (input.hasNext() == true) {
					option = input.nextLine();
				} else {
					System.out.println("Please enter number from (1-3)");
					input.next();
					continue;
				}

				switch (option) {
				case "1":
					Log.info("In controller: Welcome input> case 1 ");
					NewProfile np = new NewProfile();
					np.createProfile();
					//System.out.println("welcome page per");
					//System.out.println(option);
					System.out.println("==========================================================");
					break;
				case "2":
					Log.info("In controller: Welcome input> case 2 ");
					LoginPage lp = new LoginPage();
					lp.loginInfo();
					System.out.println("==========================================================");
					break;
				case "3":
					Log.info("In controller: Welcome input> case 3 ");
					System.out.println("Exiting......");;
					break;
				default:
					Log.info("In controller: Welcome input > default ");
					System.out.println("Something went wrong");
					System.out.println("==========================================================");
					break;

				}

			} while (!(option.equals("3")));
			
		} catch (InputMismatchException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
