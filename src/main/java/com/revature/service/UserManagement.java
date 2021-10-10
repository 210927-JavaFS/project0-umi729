package com.revature.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.dao.AccountDAO;
import com.revature.dao.AccountDAOImpl;
import com.revature.dao.BalanceDAOImpl;
import com.revature.dao.LoginDAO;
import com.revature.dao.LoginDAOImpl;
import com.revature.models.AccBalance;
import com.revature.models.AccountTb;
import com.revature.models.LoginTb;

public class UserManagement {
	private static Logger Log = LoggerFactory.getLogger(UserManagement.class);
	private static LoginDAO ld = new LoginDAOImpl();

	public void userLogin(String userName, String password) throws InputMismatchException, IOException {

		LoginTb lt = ld.findByUserPass(userName, password);

		if (!(lt.getUid() == 0)) {
			Log.info("login Successfully ");
			Login lg = Login.INSTANCE;
			lg.userName = lt.getUserName();
			lg.uid = lt.getUid();// select uid
			lg.status = lt.getStatus();// select active
			lg.type = lt.getaType(); // select type
			lg.aid = lt.getAid(); // select type

			lg.show();

		} else {
			Log.warn("unsuccessful login attempt ");
			System.out.println("Could not find user/password in database. Please try again");
		}
	}

	public void createAccount(BigDecimal bal, List<AccountTb>  at, List<LoginTb> lt ) {

		// Generate random integers in range 0 to 999
		SecureRandom rand = new SecureRandom();
		int accountNumber = rand.nextInt(1000000);
		AccBalance ab=new AccBalance(accountNumber,bal);
		BalanceDAOImpl bala=new BalanceDAOImpl();
		AccountDAO adao=new AccountDAOImpl();
		LoginDAO ldao=new LoginDAOImpl();
		
		/*
		 * if(bala.addBalance(ab)) { for(int i=0; i<at.length; i++) {
		 * at[i].setAccNo(accountNumber);
		 * 
		 * int aidNo= adao.profile(at[i]);
		 * 
		 * if(aidNo>0) {
		 * 
		 * lt[i].setAid(aidNo);
		 * 
		 * if(ldao.signUp(lt[i])) {
		 * System.out.println("Profile submitted for approval"); }
		 * 
		 * }
		 * 
		 * }
		 * 
		 * }
		 */
	}

	public String getMyUserName(String email, int zipCode) {
		Log.info("username searching ");
		/*
		 * SELECT user_name FROM login l JOIN account a ON l.aid = a.aid WHERE email =
		 * 'umi729@gmail.com' AND zipcode = 85008
		 * 
		 */

		return "username";
	}

	public void resetPassword(String userName, String email, int zipCode) {

		/*
		 * SELECT pwd FROM login l JOIN account a ON l.aid = a.aid WHERE email =
		 * 'umi729@gmail.com' AND zipcode = 85008 AND user_name = 'Umer1'
		 */

		// information matched. Creating new password
		System.out.println("Information matched please create your password");
		Log.info("password reseting ");
		int count = 0;
		do {
			System.out.println("Enter new password");
			Scanner input = new Scanner(System.in);
			String a = input.next();
			System.out.println("Re-enter password");
			String b = input.next();
			if (a.equals(b)) {
				/*
				 * UPDATE login SET pwd = 'abc' WHERE user_name = 'Umer1'
				 */
				Log.info("password reset");
				System.out.println("Password resetted");
				break;
			} else {
				System.out.println("Password mismatched");
				Log.info("password missmatched ");
				count++;
			}
		} while (count < 3);

	}
}
