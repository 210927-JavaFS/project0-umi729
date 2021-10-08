package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.AccBalance;
import com.revature.util.ConnectionUtil;

public class BalanceDAOImpl implements BalanceDAO {

	@Override
public List<AccBalance> findAll() {
		
		try(Connection conn= ConnectionUtil.getConnection()){
			
		String sql ="Select * from acc_bal";	
		
		Statement statement= conn.createStatement();
		
		ResultSet result = statement.executeQuery(sql);
		
		List<AccBalance> list = new ArrayList<>();
		
		
			while(result.next()) {
				
				AccBalance home = new AccBalance();
				
				home.setBalance(result.getDouble("bal"));
				
				home.setId(result.getInt("acc_no"));
				
				list.add(home);
				
			}
			return list;
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AccBalance findByAccNumber(int acc) {
		try(Connection conn= ConnectionUtil.getConnection()){
			
			String sql ="SELECT bal FROM acc_bal ab "
					+ "JOIN account a ON ab.acc_no =a.acc_no "
					+ "JOIN login l ON a.aid = l.aid WHERE l.uid = ?;";	
			
			PreparedStatement statement= conn.prepareStatement(sql);
			
			statement.setInt(1, acc);
			
			ResultSet result = statement.executeQuery();
			
			
				AccBalance ab = new AccBalance();
				
				if(result.next()) {
					
					
					ab.setBalance(result.getDouble("bal"));
					
					//ab.setId(result.getInt("acc_no"));
					
				}
				return ab;
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return null;

	}

	@Override
	public boolean updateBalance(AccBalance ab) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addBalance(AccBalance ab) {
		// TODO Auto-generated method stub
		return false;
	}

}
