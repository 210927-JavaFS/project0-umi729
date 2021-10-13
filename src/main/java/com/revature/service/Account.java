//package com.revature.service;
//
//public class Account {
//	private String firstName;
//	private String lastName;
//	
//	private int zipCode;
//
//	private String email;
//	
//	private String typeOfAccount;
//
//	// getter and setter
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	
//	public int getZipCode() {
//		return zipCode;
//	}
//
//	public void setZipCode(int zipCode) {
//		this.zipCode = zipCode;
//	}
//
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	
//	public String getTypeOfAccount() {
//		return typeOfAccount;
//	}
//
//	public void setTypeOfAccount(String typeOfAccount) {
//		this.typeOfAccount = typeOfAccount;
//	}
//
//	// constructor
//	public Account() {
//		super();
//	}
//
//	public Account(String firstName,  String lastName, int zipCode, String email,
//										int ssn, String typeOfAccount) {
//
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.zipCode = zipCode;
//		this.email = email;
//		this.typeOfAccount = typeOfAccount;
//
//	}
//
//	public void createAccount() {
//			System.out.println(getFirstName());
//			System.out.println(getLastName());
//			System.out.println(getEmail());
//			System.out.println(getZipCode());
//	}
//
//	
//
//	void displayProfile(int ssn, int zipCode) {
//
//	}
//
//	void displayProfile(int accountNumber) {
//
//	}
//
//	void displayProfile(String userName) {
//
//	}
//
//	
//}
//
///*
// * function to get date of birth LocalDate dateOfBirth = LocalDate.of(2010, 01,
// * 14); System.out.println("Your Date of birth is : " + dateOfBirth);
// * 
// */
///*
// * 
// */
//
///*
// * String input = "1234567890";
// * 
// * String number = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
// * 
// * System.out.println(); System.out.println(isValid(number));
// * 
// * private static boolean isValid(String s) { String regex =
// * "\\d{3}-\\d{3}-\\d{4}"; // XXX-XXX-XXXX return s.matches(regex); }
// */
//
//
// 
// 
//
///*
// * public static boolean isValidSSN(String str) {
// * 
// * String regex = "^(?!666|000|9\\d{2})\\d{3}" + "-(?!00)\\d{2}-"
// * +"(?!0{4})\\d{4}$"; Pattern p = Pattern.compile(regex);
// * 
// * if (str == null) { return false; }
// * 
// * Matcher m = p.matcher(str); return m.matches(); }
// */
