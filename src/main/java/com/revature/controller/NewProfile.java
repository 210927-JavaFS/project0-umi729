package com.revature.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

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
			Customer ac=new Customer();
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
			System.out.println("Enter the amount you want as initial deposit (100.00-500.00) \n please use decimal number1 ");
			
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
				
				
				if(vc.validateDoubleInput(bal, 100.00, 500.00)) {
					ac.setBalence(bal);
					validation = true;
				}
				else 
					continue;
				
			} while(validation== false);
			
			System.out.println("Enter your User Name for future login ");
			ac.setUserName(scan.next());
			System.out.println("Enter your password");
			ac.setUserName(scan.next());
			System.out.println("Is this individual account of Joint? Please select from following option");
			int option=0;
			validation =false;
			do {
				if(scan.hasNextInt()== true) {
					   option= scan.nextInt();
					}
					else
					{
						 System.out.println("Please enter number from (1-4)");
						 scan.next();
						 continue;
					}
				if(vc.validateIntInput(option, 1, 2)) {
					switch(option) {
					case 1: ac.createAccount();
					break;
					case 2: 
							
					}
					validation = true;
				}
				else {
				continue;
				}
			} while(validation== false);
		
			
			
		
	}
}
