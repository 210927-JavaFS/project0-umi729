package com.revature.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTb {
	private static AES256 ae= new  AES256();
	private static Logger Log=LoggerFactory.getLogger(LoginTb.class);
	private int uid;
	private String userName;
	private String pwd;
	private String status;
	private String aType;
	private int aid;
	
	
	public LoginTb(int uid, String userName, String pwd, String status, String aType, int aid) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.pwd = ae.encrypt(pwd);
		this.status = status;
		this.aType = aType;
		this.aid = aid;
		
		Log.debug("In LoginTB cunstructor with id ");
	}
	public LoginTb(String userName, String pwd, String status, String aType, int aid) {
		super();
		this.userName = userName;
		this.pwd = ae.encrypt(pwd) ;
		this.status = status;
		this.aType = aType;
		this.aid = aid;
		
		Log.debug("In LoginTB cunstructor without id ");
	}
	
	public LoginTb() {
		super();
		Log.debug("In LoginTB cunstructor without parameters ");
	}
	public int getUid() {
		Log.debug("In LoginTB getUid method  ");
		return uid;
	}
	public void setUid(int uid) {
		Log.debug("In LoginTB setUid method  ");
		this.uid = uid;
	}
	public String getUserName() {
		Log.debug("In LoginTB getUserName method  ");
		return userName;
	}
	public void setUserName(String userName) {
		Log.debug("In LoginTB setUserName method  ");
		this.userName = userName;
	}
	public String getPwd() {
		Log.debug("In LoginTB getPwd method  ");
		return ae.decrypt(pwd);
	}
	public void setPwd(String pwd) {
		Log.debug("In LoginTB setPwd method  ");
		this.pwd = ae.encrypt(pwd);
	}
	public String getStatus() {
		Log.debug("In LoginTB getStatus method  ");
		return status;
	}
	public void setStatus(String status) {
		Log.debug("In LoginTB setStatus method  ");
		this.status = status;
	}
	public String getaType() {
		Log.debug("In LoginTB getaType method  ");
		return aType;
	}
	public void setaType(String aType) {
		Log.debug("In LoginTB setaType method  ");
		this.aType = aType;
	}
	public int getAid() {
		Log.debug("In LoginTB getAid method  ");
		return aid;
	}
	public void setAid(int aid) {
		Log.debug("In LoginTB setAid method  ");
		this.aid = aid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aType == null) ? 0 : aType.hashCode());
		result = prime * result + aid;
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + uid;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		LoginTb other = (LoginTb) obj;
		if (aType == null) {
			if (other.aType != null)
				return false;
		} else if (!aType.equals(other.aType))
			return false;
		if (aid != other.aid)
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (uid != other.uid)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoginTb [uid=" + uid + ", userName=" + userName + ", pwd=" + pwd + ", status=" + status + ", aType="
				+ aType + ", aid=" + aid + "]";
	}


	
	
}
