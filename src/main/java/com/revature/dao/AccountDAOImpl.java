package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

import com.revature.models.AccountTb;
import com.revature.util.ConnectionUtil;

public class AccountDAOImpl implements AccountDAO {

	@Override
	public List<AccountTb> findAll() {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Select * from account";

			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			List<AccountTb> tb = new ArrayList<>();
			while (result.next()) {
				AccountTb ab = new AccountTb();

				ab.setAid(result.getInt("aid"));
				ab.setfName(result.getString("first_name"));
				ab.setlName(result.getString("last_name"));
				ab.setEmail(result.getString("email"));
				ab.setZipCode(result.getInt("zipcode"));
				ab.setAccNo(result.getInt("acc_no"));
				tb.add(ab);

			}
			return tb;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountTb> findByAccNumber(int acc) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Select * from account where acc_no = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, acc);

			ResultSet result = statement.executeQuery();
			AccountTb ab = new AccountTb();
			List<AccountTb> tb = new ArrayList<>();
			if (result.next()) {

				ab.setAid(result.getInt("aid"));
				ab.setfName(result.getString("first_name"));
				ab.setlName(result.getString("last_name"));
				ab.setEmail(result.getString("email"));
				ab.setZipCode(result.getInt("zipcode"));
				ab.setAccNo(result.getInt("acc_no"));
				tb.add(ab);

			}
			return tb;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public List<AccountTb> findByUserID(int uid) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account WHERE aid = (SELECT aid FROM login WHERE uid= ?); ";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, uid);

			ResultSet result = statement.executeQuery();
			AccountTb ab = new AccountTb();
			List<AccountTb> tb = new ArrayList<>();
			if (result.next()) {

				ab.setAid(result.getInt("aid"));
				ab.setfName(result.getString("first_name"));
				ab.setlName(result.getString("last_name"));
				ab.setEmail(result.getString("email"));
				ab.setZipCode(result.getInt("zipcode"));
				ab.setAccNo(result.getInt("acc_no"));
				tb.add(ab);

			}
			return tb;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}
	
	public List<AccountTb> findByUserID(String user) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM account WHERE aid = (SELECT aid FROM login WHERE user_name= ?); ";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user);

			ResultSet result = statement.executeQuery();
			AccountTb ab = new AccountTb();
			List<AccountTb> tb = new ArrayList<>();
			if (result.next()) {

				ab.setAid(result.getInt("aid"));
				ab.setfName(result.getString("first_name"));
				ab.setlName(result.getString("last_name"));
				ab.setEmail(result.getString("email"));
				ab.setZipCode(result.getInt("zipcode"));
				ab.setAccNo(result.getInt("acc_no"));
				tb.add(ab);

			}
			return tb;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}


	@Override
	public int profile(AccountTb tb) {
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO account (first_name, last_name, email, zipcode, acc_no) "
					+ "VALUES (?, ?, ?, ?, ?)";

			int count = 0;

			PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			statement.setString(++count, tb.getfName());
			statement.setString(++count, tb.getlName());
			statement.setString(++count, tb.getEmail());
			statement.setInt(++count, tb.getZipCode());
			statement.setInt(++count, tb.getAccNo());

			statement.executeUpdate();
			//System.out.println("a");
			ResultSet keys = statement.getGeneratedKeys();
			int id = 0;
			if (keys.next()) {
				//System.out.println("b");
				id = keys.getInt(1);
			}
			return id;

		} catch(PSQLException e){
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

	@Override
	public java.util.ListIterator<AccountTb> ListIterator(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
