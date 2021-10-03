package com.revature.service;

import java.io.IOException;
import java.util.InputMismatchException;

public enum Login {
	INSTANCE;
	String userName;
	int uid;
	String status;
	String type;
	public void show() throws InputMismatchException, IOException {
		System.out.println();
		CustomerPortal cp= new CustomerPortal(userName, uid);
		cp.viewCP();
		
	}
}
