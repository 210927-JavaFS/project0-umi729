package com.revature.service;

public class ValidationClass {
	public boolean zipUS( String z ) 
	
	{ 
		
		return z.matches( "\\d{5}" ); 
	}

	 public boolean isValid(String email) { 
		 String regex ="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; 
			  return email.matches(regex);
	 }
	 public boolean validateDoubleInput(double bal, double minVal, double maxVal) {
		 boolean check=true;
		 if ((bal <minVal) ) {
			 System.out.printf("please enter between %d - %d", minVal, maxVal);
				check = false;
				
			}
			else if (bal > maxVal) {
				System.out.printf("Maximum number you can enter is: %d", maxVal);
				check = false;
			}
		 return check;
	 }
	 
	 public boolean validateIntInput(int bal, int minVal, int maxVal) {
		 boolean check=true;
		 if ((bal <minVal) ) {
				System.out.printf("please enter between %d - %d", minVal, maxVal);
				check = false;
				
			}
			else if (bal > maxVal) {
				System.out.printf("Maximum number you can enter is: %d", maxVal);
				check = false;
			}
		 return check;
	 }
}
