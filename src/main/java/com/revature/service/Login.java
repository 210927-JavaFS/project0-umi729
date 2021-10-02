package com.revature.service;

import java.io.IOException;
import java.util.InputMismatchException;

public enum Login {
	INSTANCE;
	String userName;
	int accountNumber;
	public void show() throws InputMismatchException, IOException {
		System.out.println();
		CustomerPortal cp= new CustomerPortal(userName, accountNumber);
		cp.viewCP();
		
	}
}
