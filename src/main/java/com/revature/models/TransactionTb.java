package com.revature.models;

import java.math.BigDecimal;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionTb {
	private static Logger Log=LoggerFactory.getLogger(TransactionTb.class);
	private int tid;
	private BigDecimal amount;
	private String TranType;
	private Calendar calendar;
	private int toAccount;
	private java.sql.Date Date;
	private int uid;
	//Constructions
	private int acc_no;
	
	public TransactionTb(BigDecimal amount, int acc_no, String tranType ) {
		super();
		this.amount = amount;
		this.TranType = tranType;
		this.acc_no = acc_no;
		this.calendar = Calendar.getInstance();
		this.Date = new java.sql.Date(calendar.getTime().getTime());
	}
	public TransactionTb(int tid, BigDecimal amount, String tranType, int uid, int toAccount, int acc_no) {
		super();
		this.tid = tid;
		this.amount = amount;
		this.TranType = tranType;
		this.calendar = Calendar.getInstance();
		this.Date = new java.sql.Date(calendar.getTime().getTime());
		this.uid = uid;
		this.toAccount=toAccount;
		this.acc_no=acc_no;
		Log.debug("In TransactionTb cunstructor ");
	}
	public TransactionTb(BigDecimal amount, String tranType, int uid) {
		super();
		this.amount = amount;
		this.TranType = tranType;
		this.uid = uid;
		this.calendar = Calendar.getInstance();
		this.Date = new java.sql.Date(calendar.getTime().getTime());
	}
	public TransactionTb(BigDecimal amount, String tranType,  int uid, int toAccount, int acc_no) {
		super();
		this.amount = amount;
		this.TranType = tranType;
		this.calendar = Calendar.getInstance();
		this.Date = new java.sql.Date(calendar.getTime().getTime());
		this.uid = uid;
		this.toAccount=toAccount;
		this.acc_no=acc_no;
		Log.debug("In TransactionTb cunstructor ");
	}
	public TransactionTb() {
		super();
		this.calendar = Calendar.getInstance();
		this.Date = new java.sql.Date(calendar.getTime().getTime());
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
	public BigDecimal getAmount() {
		Log.debug("In TransactionTb getAmount ");
		return amount;
	}
	public int getToAccount() {
		return toAccount;
	}
	
	public int getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public void setAmount(BigDecimal amount) {
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
	public java.sql.Date getDate() {
		Log.debug("In TransactionTb getDate ");
		return Date;
	}
	public void setDate(java.sql.Date date2) {
		Log.debug("In TransactionTb setDate ");
		Date = date2;;
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
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((calendar == null) ? 0 : calendar.hashCode());
		result = prime * result + tid;
		result = prime * result + toAccount;
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
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (calendar == null) {
			if (other.calendar != null)
				return false;
		} else if (!calendar.equals(other.calendar))
			return false;
		if (tid != other.tid)
			return false;
		if (toAccount != other.toAccount)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TransactionTb [tid=" + tid + ", amount=" + amount + ", TranType=" + TranType + ", calendar=" + calendar
				+ ", toAccount=" + toAccount + ", Date=" + Date + ", uid=" + uid + "]";
	}
	
	
		
}
