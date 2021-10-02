package com.revature.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.service.Account;
import com.revature.service.Customer;
import com.revature.service.ValidationClass;

public class NewProfile {

	public NewProfile() {
		
	}
	public void createProfile() throws InputMismatchException, IOException {
		System.out.println("Welcome to our bank");
		System.out.println("=============================================");
		System.out.println();
		System.out.println();
		System.out.println("Please provide the following information");
		
		Scanner scan = new Scanner(System.in);
			boolean validation=false;
			Customer ac=(Customer) new Account();
			ValidationClass vc=new ValidationClass();
			int zipCode=0;
			
			System.out.println("Enter your First Name: ");
			ac.setFirstName(scan.next());
			System.out.println("Enter your Last Name: ");
			ac.setLastName(scan.next());
			System.out.println("Enter your Email Address: ");
			String email;
			while(!(vc.isValid(email=scan.next()))) {
				System.out.println("Please enter a valid email");
			}
			ac.setEmail(email);
			System.out.println("Enter your ZipCode: ");
			
			validation = false;
			do {
				if(scan.hasNextInt()== true) {
					zipCode= scan.nextInt();
					}
					else
					{
						 System.out.println("Please enter 5 digit Zip Code");
						 scan.next();
						 continue;
					}
				if ((zipCode <1) ) {
					System.out.println("Select a positive number");
					continue;
					
				}
				else if (!(vc.zipUS(String.valueOf(zipCode)) )) {
					System.out.println("5 digit Zip Code is required");
					continue;
				}
				else {
				ac.setZipCode(zipCode);
				validation = true;
				}
			} while(validation== false);
			System.out.println("Enter the amount you want as initial deposit (100-500) ");
			
			double bal=0.0;
			validation= false;
			
			do {
				if(scan.hasNextDouble()== true) {
					bal= scan.nextDouble();
					}
					else
					{
						 System.out.println("Please enter in decimal number");
						 scan.next();
						 continue;
					}
				if ((bal <100.00) ) {
					System.out.println("please enter between 100 -500");
					continue;
					
				}
				else if (bal > 500) {
					System.out.println("Max you can deposit $500");
					continue;
				}
				else {
					ac.setBalence(scan.nextDouble());
				validation = true;
				}
			} while(validation== false);
			
			System.out.println("Enter your User Name for future login ");
			ac.setUserName(scan.next());
			System.out.println("Enter your password");
			ac.setUserName(scan.next());
			ac.createAccount();
		
	}
}
