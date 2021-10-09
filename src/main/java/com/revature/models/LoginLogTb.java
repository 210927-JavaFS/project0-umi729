package com.revature.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginLogTb {
	private static Logger Log=LoggerFactory.getLogger(LoginLogTb.class);
	private String lid;
	private String timeStamps;
	private int uid;
	public LoginLogTb(String lid, String timeStamps, int uid) {
		super();
		this.lid = lid;
		this.timeStamps = timeStamps;
		this.uid = uid;
		Log.debug("LoginLogTb constructor with id");
	}
	public LoginLogTb(String timeStamps, int uid) {
		super();
		this.timeStamps = timeStamps;
		this.uid = uid;
		Log.debug("LoginLogTb constructor without id");
	}
	public LoginLogTb() {
		super();
		Log.debug("LoginLogTb constructor without parameters ");
	}
	
	//hash and equal method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lid == null) ? 0 : lid.hashCode());
		result = prime * result + ((timeStamps == null) ? 0 : timeStamps.hashCode());
		result = prime * result + uid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Log.debug("LoginLogTb equal method ");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginLogTb other = (LoginLogTb) obj;
		if (lid == null) {
			if (other.lid != null)
				return false;
		} else if (!lid.equals(other.lid))
			return false;
		if (timeStamps == null) {
			if (other.timeStamps != null)
				return false;
		} else if (!timeStamps.equals(other.timeStamps))
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}
	public String getLid() {
		Log.debug("LoginLogTb getLid method ");
		return lid;
	}
	public void setLid(String lid) {
		Log.debug("LoginLogTb setLid method ");
		this.lid = lid;
	}
	public String getTimeStamps() {
		Log.debug("LoginLogTb getTimeStamps method ");
		return timeStamps;
	}
	public void setTimeStamps(String timeStamps) {
		Log.debug("LoginLogTb setTimeStamps method ");
		this.timeStamps = timeStamps;
	}
	public int getUid() {
		Log.debug("LoginLogTb getUid method ");
		return uid;
	}
	public void setUid(int uid) {
		Log.debug("LoginLogTb setUid method ");
		this.uid = uid;
	}
	@Override
	public String toString() {
		Log.debug("LoginLogTb toString method ");
		return "LoginLogTb [lid=" + lid + ", timeStamps=" + timeStamps + ", uid=" + uid + "]";
	}
	
	

}
