package com.revature.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ListIterator;
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
import com.revature.models.TransactionTb;

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

	public void createAccount(BigDecimal bal, List<AccountTb> at, List<LoginTb> lt) {

		// Generate random integers in range 0 to 999
		SecureRandom rand = new SecureRandom();
		int accountNumber = rand.nextInt(1000000);
		AccBalance ab = new AccBalance(accountNumber, bal);
		BalanceDAOImpl bala = new BalanceDAOImpl();
		
		LoginDAO ldao = new LoginDAOImpl();
		AccountDAO adao = new AccountDAOImpl();
		ListIterator<AccountTb> lst = at.listIterator();
		ListIterator<LoginTb> lsLogin = lt.listIterator();
		// System.out.println(at);
	
	int[] aidNo= new int[2];
	int c=0;
		if (bala.addBalance(ab)) {
			while (lst.hasNext()) { //

				AccountTb rec = lst.next();
				rec.setAccNo(accountNumber);
				aidNo[c]= adao.profile(rec);
				c++;
				
				
			}
		int d=0;	
		
			while (lsLogin.hasNext()) {
				LoginTb ltt = lsLogin.next();
				
				if (aidNo[d] > 0) {
					//System.out.println(ltt.getUserName());
					ltt.setAid(aidNo[d]);
					if (ldao.signUp(ltt)) {
						
						d++;
						
					}

				}

			}
			System.out.println("Profile submitted for approval");
		}

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
