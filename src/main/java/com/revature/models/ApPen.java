package com.revature.models;

public class ApPen {
	private int Acc_no;
	private String FName;
	private String lName;
	private String status;
	private String atype;
	private double bal;
	private String email;
	private int zipCode;
	private String user_name;

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public ApPen(int acc_no, String fName, String lName, String status, String atype, double bal, String email,
			int zipCode, String user_name) {
		super();
		Acc_no = acc_no;
		FName = fName;
		this.lName = lName;
		this.status = status;
		this.atype = atype;
		this.bal = bal;
		this.email = email;
		this.zipCode = zipCode;
		this.user_name = user_name;
	}

	public ApPen(int acc_no, String fName, String lName, String status, String atype) {
		super();
		Acc_no = acc_no;
		FName = fName;
		this.lName = lName;
		this.status = status;
		this.atype = atype;
	}
	
	public ApPen() {
		super();
	}
	public int getAcc_no() {
		return Acc_no;
	}
	public void setAcc_no(int acc_no) {
		Acc_no = acc_no;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		FName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}

	@Override
	public String toString() {
		
		return " Applicant: " +" [ "+ Acc_no + " " + FName + " " + lName + " " + status + " "
				+ atype + " " + bal + " " + email + " " + zipCode + " " + user_name
				+ " ]";
	}

	
	

}
