package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
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
		System.out.println("Please provide the following information\n");
		
		// input obj
		Scanner scan = new Scanner(System.in);
			boolean validation=false;
			// customer class is where we are creating profile;
			Customer ac=new Customer();
			
			// variables
			ArrayList<String> fName=new ArrayList<>();
			ArrayList<String> lName=new ArrayList<>();
			ArrayList<String> email=new ArrayList<>();
			ArrayList<Integer> zipCode=new ArrayList<>();
			ArrayList<String> uName=new ArrayList<>();
			ArrayList<String> pass=new ArrayList<>();
			int option=0;
			
			
			// validation class 
			ValidationClass vc=new ValidationClass();
			
			
			
			System.out.println("Enter number of Account Holder(Max 10) Or 0 for Exit:");
			
			
			do {
				if(scan.hasNextInt()== true) {
					   option= scan.nextInt();
					   if(option==0) {
						  break; 
					   }
					}
					else
					{
						 System.out.println("Please enter number from (1-10)");
						 scan.next();
						 continue;
					}
				
				// if validation is true then start taking data
				if(vc.validateIntInput(option, 1, 10)) {
					for(int i=1; i<=option; i++) {
						System.out.printf("Person Number: %d%n%n%n", i);
						System.out.println("Enter First Name: ");
						fName.add(scan.next());
						System.out.println("Enter Last Name: ");
						lName.add(scan.next());
						System.out.println("Enter Email Address: ");
						String eemail;
						while(!(vc.isValid(eemail=scan.next()))) {
							System.out.println("Please enter a valid email");
						}
						email.add(eemail);
						System.out.println("Enter your ZipCode: ");
						int pzipCode=0;
						validation = false;
						do {
							if(scan.hasNextInt()== true) {
								pzipCode= scan.nextInt();
								}
								else
								{
									 System.out.println("Please enter 5 digit Zip Code");
									 scan.next();
									 continue;
								}
							if ((pzipCode <1) ) {
								System.out.println("Select a positive number");
								continue;
								
							}
							else if (!(vc.zipUS(String.valueOf(pzipCode)) )) {
								System.out.println("5 digit Zip Code is required");
								continue;
							}
							else {
							zipCode.add(pzipCode);
							validation = true;
							}
						} while(validation== false);
						System.out.println("Create User Name ");
						uName.add(scan.next());
						System.out.println("Create password");
						pass.add(scan.next());
						System.out.println("\n\n");
					}
					
					ac.createAccount(fName, lName, email, zipCode, option, uName, pass);
					validation = true;
				}
				else {
				continue;
				}
			} while(validation== false);
			
			// Taking initial Balance 
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
			
			
			
		
			
			
		
	}
}
