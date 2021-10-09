package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.revature.models.LoginTb;
import com.revature.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO{

	@Override
	public List<LoginTb> findAll() {
		try(Connection conn= ConnectionUtil.getConnection()){
			
			String sql ="Select * from login";	
			
			PreparedStatement statement= conn.prepareStatement(sql);
			
			ResultSet result = statement.executeQuery();
			
			
			List<LoginTb> tb=new ArrayList<>();
			while(result.next()) {
				LoginTb ab = new LoginTb();
				
				ab.setUid(result.getInt("uid"));
				ab.setUserName(result.getString("user_name"));
				ab.setPwd(result.getString("pwd"));
				ab.setStatus(result.getString("status"));
				ab.setaType(result.getString("a_type"));
				ab.setAid(result.getInt("aid"));
				tb.add(ab);
					
			}
			return tb;
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return null;

	}

	@Override
	public List<LoginTb> findByAccNumber(int acc) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public LoginTb findByUserName(String userName) {
			try(Connection conn= ConnectionUtil.getConnection()){
			
			String sql ="Select * from login where user_name= ?";	
			
			PreparedStatement statement= conn.prepareStatement(sql);
			
			statement.setString(1, userName);
			
			ResultSet result = statement.executeQuery();
			
			LoginTb ab = new LoginTb();
				
			if(result.next()) {
					
				
				ab.setUid(result.getInt("uid"));
				ab.setUserName(result.getString("user_name"));
				ab.setPwd(result.getString("pwd"));
				ab.setStatus(result.getString("status"));
				ab.setaType(result.getString("a_type"));
				ab.setAid(result.getInt("aid"));
				
					
			}
			return ab;
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return null;

	}

	@Override
	public boolean signUp(LoginTb tb) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			//String sql = "INSERT INTO account (first_name, last_name, email, zipcode) "
			//		+ "VALUES (?, ?, ?, ?)";
			String sql = "INSERT INTO login (user_name, pwd, status, a_type, aid) "
					+ "VALUES (?, ?, ?,?, ?)";
			
			int count = 0;
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(++count, tb.getUserName());
			statement.setString(++count, tb.getPwd());
			statement.setString(++count, tb.getStatus());
			statement.setString(++count, tb.getaType());
			statement.setInt(++count, tb.getAid());
			//statement.setString(++count, tb.getPsk());
			
			statement.execute();
			
			return true;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;



	}

	@Override
	public ListIterator<LoginTb> ListIterator(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LoginTb> findByUserID(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
