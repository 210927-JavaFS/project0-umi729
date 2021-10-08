package com.revature.models;

public class AccBalance {
private int id;
private double balance;
	
//Constructors 
	public AccBalance(int id, double balance) {
		super();
		this.id = id;
		this.balance = balance;
	}
	public AccBalance() {
		super();
	}
// Getter Setter Methods
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
//HashCode and Equals methods override
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
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
		AccBalance other = (AccBalance) obj;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
//ToString Method
	@Override
	public String toString() {
		return "Home [id=" + id + ", balance=" + balance + "]";
	}


}
