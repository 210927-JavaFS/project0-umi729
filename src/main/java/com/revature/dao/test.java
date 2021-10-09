package com.revature.dao;

import com.revature.models.LoginTb;

public class test {
	static AES256 ae=new AES256();
	static LoginDAO bd= new LoginDAOImpl();
	public static void main(String[] args) {
		
		//String str= ae.encrypt("myPassword");
		
		/*
		 * LoginTb tb=new LoginTb("Umer", str, "Active", "Cus", 8);
		 * 
		 * if(bd.signUp(tb)) { System.out.println("sussc"); }
		 */
		 
		System.out.println(bd.findAll());
		
	}

}
