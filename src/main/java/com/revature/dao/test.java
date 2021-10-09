package com.revature.dao;

public class test {

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a= "This string is going to encrypt";
		String b= AES256.encrypt(a);
		String c= AES256.decrypt(b);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		 

	}

}
