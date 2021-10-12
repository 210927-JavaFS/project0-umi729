package com.revature.service;

import java.io.IOException;
import java.util.InputMismatchException;

import com.revature.controller.Employee;
import com.revature.controller.LoggedIn;

public enum Login {
	INSTANCE;
	String userName;
	int uid;
	String status;
	String type;
	int aid;
	public void show() throws InputMismatchException, IOException {
		
		if(type.equals("Cus")) {
			LoggedIn cp= new LoggedIn(userName, uid);
			cp.viewCP();
		}
		else if(type.equals("Emp")) {
			Employee cp= new Employee(userName, uid);
			cp.viewCP();
		}
	}
}
