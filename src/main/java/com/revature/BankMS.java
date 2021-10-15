package com.revature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.Welcome;

public class BankMS {
	private static Logger Log = LoggerFactory.getLogger(BankMS.class);
	public static void main(String[] args) {
		Log.info("In main> starting the application ");
		Welcome wc=new Welcome();
		wc.drive();
		
	}
	
}
