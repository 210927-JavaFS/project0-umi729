package com.revature.dao;

import java.util.List;
import java.util.ListIterator;

import com.revature.models.ApPen;
import com.revature.models.LoginTb;
import com.revature.models.TransactionTb;

public interface LoginDAO {
	public List<LoginTb> findAll();
	public  List<LoginTb>  findByAccNumber(int acc);
	public  List<LoginTb>  findByUserID(int uid);
	public boolean signUp(LoginTb tb);
	public LoginTb findByUserName(String userName);
	public LoginTb findByUserPass(String userName, String Pass);
	public ListIterator<LoginTb> ListIterator(int uid);
	public List<ApPen> applications();
	public ListIterator<ApPen> ListIterator();
	public ApPen proFileReport(int acc);
	public boolean activate(int acc);
	public boolean deactivate(int acc);
}
