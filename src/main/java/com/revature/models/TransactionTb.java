package com.revature.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.controller.LoginPage;

public class TransactionTb {
	private static Logger Log=LoggerFactory.getLogger(TransactionTb.class);
	private int tid;
	private int amount;
	private String TranType;
	private String Date;
	private int uid;
	//Constructions
	public TransactionTb(int tid, int amount, String tranType, String date, int uid) {
		super();
		this.tid = tid;
		this.amount = amount;
		TranType = tranType;
		Date = date;
		this.uid = uid;
		Log.debug("In TransactionTb cunstructor ");
	}
	public TransactionTb(int amount, String tranType, String date, int uid) {
		super();
		this.amount = amount;
		TranType = tranType;
		Date = date;
		this.uid = uid;
		Log.debug("In TransactionTb cunstructor ");
	}
	public TransactionTb() {
		super();
		Log.debug("In TransactionTb cunstructor ");
	}
	public int getTid() {
		Log.debug("In TransactionTb getTid ");
		return tid;
	}
	public void setTid(int tid) {
		Log.debug("In TransactionTb setTid ");
		this.tid = tid;
	}
	public int getAmount() {
		Log.debug("In TransactionTb getAmount ");
		return amount;
	}
	public void setAmount(int amount) {
		Log.debug("In TransactionTb setAmount ");
		this.amount = amount;
	}
	public String getTranType() {
		Log.debug("In TransactionTb getTranType ");
		return TranType;
	}
	public void setTranType(String tranType) {
		Log.debug("In TransactionTb setTranType ");
		TranType = tranType;
	}
	public String getDate() {
		Log.debug("In TransactionTb getDate ");
		return Date;
	}
	public void setDate(String date) {
		Log.debug("In TransactionTb setDate ");
		Date = date;
	}
	public int getUid() {
		Log.debug("In TransactionTb getUid ");
		return uid;
	}
	public void setUid(int uid) {
		Log.debug("In TransactionTb setuid ");
		this.uid = uid;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Date == null) ? 0 : Date.hashCode());
		result = prime * result + ((TranType == null) ? 0 : TranType.hashCode());
		result = prime * result + amount;
		result = prime * result + tid;
		result = prime * result + uid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionTb other = (TransactionTb) obj;
		if (Date == null) {
			if (other.Date != null)
				return false;
		} else if (!Date.equals(other.Date))
			return false;
		if (TranType == null) {
			if (other.TranType != null)
				return false;
		} else if (!TranType.equals(other.TranType))
			return false;
		if (amount != other.amount)
			return false;
		if (tid != other.tid)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionTb [tid=" + tid + ", amount=" + amount + ", TranType=" + TranType + ", Date=" + Date
				+ ", uid=" + uid + "]";
	}
	
	
}
