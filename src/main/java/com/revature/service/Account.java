package com.revature.service;

public class Account {
	private String firstName;
	private String lastName;
	// private String dateOfBirth;
	// private String address1;
	// private String city;
	// private String state;
	private int zipCode;
//	private String country;
	// private int phoneNumber;
	private String email;
	private int ssn;
	private String typeOfAccount;

	// getter and setter
	public String getFirstName() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * public String getDateOfBirth() { return dateOfBirth; } public void
	 * setDateOfBirth(String dateOfBirth) { this.dateOfBirth = dateOfBirth; } public
	 * String getAddress1() { return address1; } public void setAddress1(String
	 * address1) { this.address1 = address1; }
	 * 
	 * 
	 * public String getCity() { return city; } public void setCity(String city) {
	 * this.city = city; } public String getState() { return state; } public void
	 * setState(String state) { this.state = state; }
	 */
	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	/*
	 * public String getCountry() { return country; } public void setCountry(String
	 * country) { this.country = country; }
	 */
	/*
	 * public int getPhoneNumber() { return phoneNumber; }
	 * 
	 * public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber;
	 * }
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	// constructor
	public Account() {

	}

	public Account(String firstName,  String lastName, int zipCode, String email,
										int ssn, String typeOfAccount) {

		this.firstName = firstName;
		this.lastName = lastName;
		/*
		 * this.dateOfBirth = dateOfBirth; this.address1 = address1; this.address2 =
		 * address2; this.city = city; this.state = state;
		 */
		this.zipCode = zipCode;
		/*
		 * this.country = country; this.phoneNumber = phoneNumber;
		 */
		this.email = email;
		this.ssn = ssn;
		this.typeOfAccount = typeOfAccount;

	}

	void createAccount() {

	}

	void resetAccount() {

	}

	void displayProfile(int ssn, int zipCode) {

	}

	void displayProfile(int accountNumber) {

	}

	void displayProfile(String userName) {

	}

	/*
	 * boolean modifyAccount() {
	 * 
	 * 
	 * return true; }
	 */
}

/*
 * function to get date of birth LocalDate dateOfBirth = LocalDate.of(2010, 01,
 * 14); System.out.println("Your Date of birth is : " + dateOfBirth);
 * 
 */
/*
 * public static boolean zipUS( String z ) { return z.matches( "\\d{5}" ); }
 */

/*
 * String input = "1234567890";
 * 
 * String number = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");
 * 
 * System.out.println(); System.out.println(isValid(number));
 * 
 * private static boolean isValid(String s) { String regex =
 * "\\d{3}-\\d{3}-\\d{4}"; // XXX-XXX-XXXX return s.matches(regex); }
 */

/*
 * static boolean isValid(String email) { String regex =
 * "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; return
 * email.matches(regex);
 */

/*
 * public static boolean isValidSSN(String str) {
 * 
 * String regex = "^(?!666|000|9\\d{2})\\d{3}" + "-(?!00)\\d{2}-"
 * +"(?!0{4})\\d{4}$"; Pattern p = Pattern.compile(regex);
 * 
 * if (str == null) { return false; }
 * 
 * Matcher m = p.matcher(str); return m.matches(); }
 */
