package com.revature.service;

public class ValidationClass {
	public boolean zipUS(String z)

	{

		return z.matches("\\d{5}");
	}

	public boolean isValid(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		return email.matches(regex);
	}

	public boolean validateDoubleInput(double bal, double minVal, double maxVal) {
		boolean check = true;
		if ((bal < minVal)) {
			System.out.println("Not a valid Entry");
			check = false;

		} else if (bal > maxVal) {
			System.out.println("Not a valid Entry please check max and min");
			check = false;
		}
		return check;
	}

	public boolean validateIntInput(int bal, int minVal, int maxVal) {
		boolean check = true;
		if ((bal < minVal)) {
			System.out.println("Not valid entry");
			check = false;

		} else if (bal > maxVal) {
			System.out.println("Not a valid Entry");
			check = false;
		}
		return check;
	}
}
