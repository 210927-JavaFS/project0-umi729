package com.revature.dao;

import java.util.List;
import java.util.ListIterator;

import com.revature.models.AccountTb;
import com.revature.models.LoginTb;

public interface AccountDAO {
	
	public List<AccountTb> findAll();
	public  List<AccountTb>  findByAccNumber(int acc);
	public  List<AccountTb>  findByUserID(int uid);
	public boolean profile(AccountTb tb);
	public ListIterator<AccountTb> ListIterator(int uid);

}
