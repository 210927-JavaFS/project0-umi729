package com.revature.dao;

public class test {
	
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
