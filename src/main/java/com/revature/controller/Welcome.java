package com.revature.controller;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.revature.service.ValidationClass;

public class Welcome {

	public void drive() {
		ValidationClass vc;
		System.out.println("Please select from following options:");
		try (Scanner input = new Scanner(System.in)) {
			String option="3";
			boolean validation=false;
			vc=new ValidationClass();
			// taking input from user
			do {
			System.out.println("1: Open an Account\n"
					+ "2: Login to Account\n"
					+ "3: Exit");
			
			
			System.out.print("Press 1-3: ");
			
			
				if(input.hasNext()== true) {
				   option= input.nextLine();
				}
				else
				{
					 System.out.println("Please enter number from (1-3)");
					 input.next();
					 continue;
				}

				switch(option) {
				case "1" : NewProfile np=new NewProfile();
							np.createProfile();
							break;
				case "2" :LoginPage lp=new LoginPage();
						lp.loginInfo();
						break;
				default : System.out.println("Something went wrong");
				break;
				
				}

				
			} while (option.equals("3"));
		}catch(InputMismatchException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
}
