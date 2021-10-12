package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.revature.models.TransactionTb;
import com.revature.util.ConnectionUtil;

public class TransDAOImpl implements TransDAO {

	@Override
	public List<TransactionTb> findAll() {
		try(Connection conn= ConnectionUtil.getConnection()){
			
			String sql ="Select * from transction_tb";	
			
			Statement statement= conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<TransactionTb> list = new ArrayList<>();
			
			
				while(result.next()) {
					
					TransactionTb tb = new TransactionTb();
					
					tb.setTid(result.getInt("tid"));
					tb.setDate(result.getDate("t_time"));
					tb.setTranType(result.getString("t_type"));
					tb.setUid(result.getInt("uid"));
					tb.setAmount(result.getBigDecimal("amount"));
					tb.setToAccount(result.getInt("to_accountno"));
					tb.setAcc_no(result.getInt("acc_no"));
					list.add(tb);
				}
				return list;
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return null;

	}

	@Override
	public  List<TransactionTb>  findByAccNumber(int acc) {
		try(Connection conn= ConnectionUtil.getConnection()){
			
			String sql ="Select * from transction_tb where acc_no =?";	
			
			PreparedStatement statement= conn.prepareStatement(sql);
			statement.setInt(1, acc);
			
			ResultSet result = statement.executeQuery(sql);
			
			List<TransactionTb> list = new ArrayList<>();
			
			
				while(result.next()) {
					
					TransactionTb tb = new TransactionTb();
					
					tb.setTid(result.getInt("tid"));
					tb.setDate(result.getDate("t_time"));
					tb.setTranType(result.getString("t_type"));
					tb.setUid(result.getInt("uid"));
					tb.setAmount(result.getBigDecimal("amount"));
					tb.setToAccount(result.getInt("to_accountno"));
					tb.setAcc_no(result.getInt("acc_no"));
					list.add(tb);
				}
				return list;
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return null;


	}

	@Override
	public boolean addTrans(TransactionTb tb) {
		try(Connection conn = ConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO transction_tb (t_time, t_type, uid, amount, to_accountno, acc_no) "
					+ "VALUES (?, ?, ?, ?, ?, ?);";
			
			int count = 0;
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setDate(++count, tb.getDate());
			statement.setString(++count, tb.getTranType());
			statement.setInt(++count, tb.getUid());
			statement.setBigDecimal(++count, tb.getAmount());
			statement.setInt(++count, tb.getToAccount());
			statement.setInt(++count, tb.getAcc_no());
			
			statement.execute();
			
			return true;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;


	}

	@Override
	public List<TransactionTb> findByUserID(int uid) {
try(Connection conn= ConnectionUtil.getConnection()){
			
			String sql ="Select * from transction_tb where uid =?";	
			
			PreparedStatement statement= conn.prepareStatement(sql);
			statement.setInt(1, uid);
			System.out.println(statement);
			ResultSet result = statement.executeQuery();
			
			List<TransactionTb> list = new ArrayList<>();
			
			
				while(result.next()) {
					
					TransactionTb tb = new TransactionTb();
					
					tb.setTid(result.getInt("tid"));
					tb.setDate(result.getDate("t_time"));
					tb.setTranType(result.getString("t_type"));
					tb.setUid(result.getInt("uid"));
					tb.setAmount(result.getBigDecimal("amount"));
					tb.setToAccount(result.getInt("to_accountno"));
					tb.setAcc_no(result.getInt("acc_no"));
					list.add(tb);
				}
				return list;
			
			}catch (SQLException e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			return null;


	}

	@Override
	public java.util.ListIterator<TransactionTb> ListIterator(int uid) {
		List<TransactionTb> td= findByUserID(uid);
	
		ListIterator<TransactionTb> arItr = td.listIterator();
		return arItr;
	}

}
