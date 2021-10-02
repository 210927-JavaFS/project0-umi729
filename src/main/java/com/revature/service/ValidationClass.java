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
}
