package com.revature.dao;

import java.util.List;
import java.util.ListIterator;

import com.revature.models.TransactionTb;

public interface TransDAO {
	public List<TransactionTb> findAll();
	public  List<TransactionTb>  findByAccNumber(int acc);
	public  List<TransactionTb>  findByUserID(int uid);
	public boolean addTrans(TransactionTb tb);
	
	public ListIterator<TransactionTb> ListIterator(int uid);
	public ListIterator<TransactionTb> ListIterat(int uid);
	
	
	

}
