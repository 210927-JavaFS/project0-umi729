package com.revature.dao;

import java.math.BigDecimal;

public class test {

	static BalanceDAO bd= new BalanceDAOImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double dum=100.00;
		BigDecimal bg=new BigDecimal(dum);
		System.err.println(bg);
		 

	}

}
