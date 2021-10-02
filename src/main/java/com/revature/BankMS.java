package com.revature;

import java.time.LocalDate;
import java.util.Scanner;

public class BankMS {

	public static void main(String[] args) {
		System.out.println("Please select from following options:");
		try (Scanner input = new Scanner(System.in)) {
			int option = 0;
			boolean validation=false;
			
			// taking input from user
			do {
			System.out.println("1: Open an Account");
			System.out.println("2: Login to Account");
			System.out.println("3: Check Balance");
			System.out.println("4: Exit");
			System.out.println();
			
			System.out.print("Press 1-4: ");
			
			
			// validate the input
				do {
					if(input.hasNextInt()== true) {
						   option= input.nextInt();
						}
						else
						{
							 System.out.println("Please enter number from (1-4)");
							 input.next();
							 continue;
						}
					if ((option <1) ) {
						System.out.println("Select a positive number");
						continue;
						
					}
					else if ((option > 4) ) {
						System.out.println("Select between 1 to 4");
						continue;
					}
					else {
					validation = true;
					}
				} while(validation== false);
			
				if(option==1) {
					
				}
			
				
			} while (option != 4);
		}
		

	}
	

        

}
