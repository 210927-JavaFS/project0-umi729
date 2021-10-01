package com.revature.account;

import java.time.LocalDate;

public class Account {
String firstname;
String middleName;
String lastName;

String dateOfBirth;
/*
 * function to get date of birth 
 * LocalDate dateOfBirth = LocalDate.of(2010, 01,
 * 14); System.out.println("Your Date of birth is : " + dateOfBirth);
 */
String address1;
String address2;
String city;
String state;
int zipCode;
/*
 * public static boolean zipUS( String z ) { return z.matches( "\\d{5}" ); }
 */
String country;
int phoneNumber;
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
String email;
/*
 * static boolean isValid(String email) { String regex =
 * "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"; return
 * email.matches(regex);
 */
int ssn;
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
boolean typeOfAccount;

}
