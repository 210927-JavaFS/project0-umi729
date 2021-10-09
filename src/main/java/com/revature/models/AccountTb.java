package com.revature.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountTb {
	
	private static Logger Log=LoggerFactory.getLogger(AccountTb.class);
	private int aid;
	private String fName;
	private String lName;
	private String email;
	private int zipCode;
	private int accNo;
	public AccountTb(int aid, String fName, String lName, String email, int zipCode, int accNo) {
		super();
		this.aid = aid;
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.zipCode = zipCode;
		this.accNo = accNo;
		Log.debug("In AccountTb cunstructor with id ");
	}
	public AccountTb(String fName, String lName, String email, int zipCode, int accNo) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.email = email;
		this.zipCode = zipCode;
		this.accNo = accNo;
		Log.debug("In AccountTb cunstructor without id ");
	}
	public AccountTb() {
		super();
		Log.debug("In AccountTb cunstructor without parameters ");
	}
	@Override
	public int hashCode() {
		Log.debug("In AccountTb hashcode method ");
		final int prime = 31;
		int result = 1;
		result = prime * result + accNo;
		result = prime * result + aid;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + zipCode;
		return result;
	}
	
	
	public int getAid() {
		Log.debug("In AccountTb hashcode method ");
		return aid;
	}
	public void setAid(int aid) {
		Log.debug("In AccountTb hashcode method ");
		this.aid = aid;
	}
	public String getfName() {
		Log.debug("In AccountTb hashcode method ");
		return fName;
	}
	public void setfName(String fName) {
		Log.debug("In AccountTb hashcode method ");
		this.fName = fName;
	}
	public String getlName() {
		Log.debug("In AccountTb hashcode method ");
		return lName;
	}
	public void setlName(String lName) {
		Log.debug("In AccountTb hashcode method ");
		this.lName = lName;
	}
	public String getEmail() {
		Log.debug("In AccountTb hashcode method ");
		return email;
	}
	public void setEmail(String email) {
		Log.debug("In AccountTb hashcode method ");
		this.email = email;
	}
	public int getZipCode() {
		Log.debug("In AccountTb hashcode method ");
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		Log.debug("In AccountTb hashcode method ");
		this.zipCode = zipCode;
	}
	public int getAccNo() {
		Log.debug("In AccountTb hashcode method ");
		return accNo;
	}
	public void setAccNo(int accNo) {
		Log.debug("In AccountTb hashcode method ");
		this.accNo = accNo;
	}
	@Override
	public boolean equals(Object obj) {
		Log.debug("In AccountTb hashcode method ");
		Log.debug("In equals hashcode method ");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountTb other = (AccountTb) obj;
		if (accNo != other.accNo)
			return false;
		if (aid != other.aid)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}
	@Override
	public String toString() {
		Log.debug("In AccountTb hashcode method ");
		Log.debug("In AccountTb toString method ");
		return "AccountTb [aid=" + aid + ", fName=" + fName + ", lName=" + lName + ", email=" + email + ", zipCode="
				+ zipCode + ", accNo=" + accNo + "]";
	}
	
	

}
