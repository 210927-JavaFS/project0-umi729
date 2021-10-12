package com.revature.dao;

import com.revature.models.AccountTb;

public class test {
	
	static AccountDAO bd= new AccountDAOImpl();
	static AccountTb tb=new AccountTb("Um", "zs","sadlkfj@gmai.com",46565,77777 );
	public static void main(String[] args) {
		
		//String str= ae.encrypt("myPassword");
		
		/*
		 * LoginTb tb=new LoginTb("Umer", str, "Active", "Cus", 8);
		 * 
		 * if(bd.signUp(tb)) { System.out.println("sussc"); }
		 */
		 
		System.out.println(bd.profile(tb));
		
	}

}
