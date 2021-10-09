package com.revature.models;

import java.math.BigDecimal;

public class AccBalance {
private int id;
private BigDecimal balance;
	
//Constructors 
	public AccBalance(int id, BigDecimal balance) {
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
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
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
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AccBalance [id=" + id + ", balance=" + balance + "]";
	}
	
//HashCode and Equals methods override
	

}
