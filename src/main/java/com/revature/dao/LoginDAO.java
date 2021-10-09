package com.revature.dao;

import java.util.List;
import java.util.ListIterator;

import com.revature.models.LoginTb;
import com.revature.models.TransactionTb;

public interface LoginDAO {
	public List<LoginTb> findAll();
	public  List<LoginTb>  findByAccNumber(int acc);
	public  List<LoginTb>  findByUserID(int uid);
	public boolean signUp(LoginTb tb);
	public LoginTb findByUserName(String userName);
	public ListIterator<LoginTb> ListIterator(int uid);
}
