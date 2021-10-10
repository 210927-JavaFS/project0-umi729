package com.revature.service;

import java.io.IOException;
import java.util.InputMismatchException;

import com.revature.controller.LoggedIn;

public enum Login {
	INSTANCE;
	String userName;
	int uid;
	String status;
	String type;
	int aid;
	public void show() throws InputMismatchException, IOException {
		System.out.println();
		LoggedIn cp= new LoggedIn(userName, uid);
		
		if(type.equals("Cus")) {
			cp.viewCP();
		}
	}
}
