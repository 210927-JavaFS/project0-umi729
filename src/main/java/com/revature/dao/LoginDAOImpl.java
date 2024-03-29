package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.ApPen;
import com.revature.models.LoginTb;
import com.revature.util.ConnectionUtil;

public class LoginDAOImpl implements LoginDAO {
	AESDecrypt ae = new AESDecrypt();
	private static Logger Log = LoggerFactory.getLogger(LoginDAOImpl.class);

	@Override
	public List<LoginTb> findAll() {
		Log.debug("LoginDAOImpl >  findAll()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Select * from login";

			PreparedStatement statement = conn.prepareStatement(sql);

			ResultSet result = statement.executeQuery();

			List<LoginTb> tb = new ArrayList<>();
			while (result.next()) {
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

		} catch (SQLException e) {
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
		Log.debug("LoginDAOImpl >  findByUserName()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Select * from login where user_name= ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, userName);

			ResultSet result = statement.executeQuery();

			LoginTb ab = new LoginTb();

			if (result.next()) {

				ab.setUid(result.getInt("uid"));
				ab.setUserName(result.getString("user_name"));
				ab.setPwd(result.getString("pwd"));
				ab.setStatus(result.getString("status"));
				ab.setaType(result.getString("a_type"));
				ab.setAid(result.getInt("aid"));

			}
			return ab;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	public boolean findByUser(String userName) {
		Log.debug("LoginDAOImpl >  findByUser()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Select * from login where user_name= ?";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, userName);

			ResultSet result = statement.executeQuery();

			LoginTb ab = new LoginTb();

			if (result.next()) {

				ab.setUid(result.getInt("uid"));
				ab.setUserName(result.getString("user_name"));
				ab.setPwd(result.getString("pwd"));
				ab.setStatus(result.getString("status"));
				ab.setaType(result.getString("a_type"));
				ab.setAid(result.getInt("aid"));
				return true;
			}
			// return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;

	}

	/*
	 * UPDATE login SET status = 'Active' WHERE uid = ( SELECT uid FROM login l JOIN
	 * account a ON l.aid =a.aid JOIN acc_bal ab ON ab.acc_no = a.acc_no WHERE
	 * ab.acc_no = 888888 );
	 */
	public boolean activate(int acc, String fname) {
		Log.debug("LoginDAOImpl >  activate()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE login SET status = 'Active' WHERE uid = ("
					+ "SELECT uid FROM login l JOIN account a ON l.aid =a.aid "
					+ "JOIN acc_bal ab ON ab.acc_no = a.acc_no WHERE ab.acc_no = ? and first_name = ?" + "); ";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, acc);
			statement.setString(2, fname);
			// System.out.println(statement);
			if (statement.executeUpdate() == 1) {

				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean deactivate(int acc, String fname) {
		Log.debug("LoginDAOImpl >  deactivate()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE login SET status = 'Disable' WHERE uid = ("
					+ "SELECT uid FROM login l JOIN account a ON l.aid =a.aid "
					+ "JOIN acc_bal ab ON ab.acc_no = a.acc_no WHERE ab.acc_no = ? and first_name = ?" + "); ";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, acc);
			statement.setString(2, fname);
			if (statement.executeUpdate() == 1) {

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean upgradeEmp(String user) {
		Log.debug("LoginDAOImpl >  upgradeEmp()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE login SET a_type = 'Emp' WHERE user_name = ?";
			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, user);

			if (statement.executeUpdate() == 1) {

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean signUp(LoginTb tb) {
		Log.debug("LoginDAOImpl >  signUp()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			// String sql = "INSERT INTO account (first_name, last_name, email, zipcode) "
			// + "VALUES (?, ?, ?, ?)";
			String sql = "INSERT INTO login (user_name, pwd, status, a_type, aid) " + "VALUES (?, ?, ?,?, ?)";

			int count = 0;

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(++count, tb.getUserName());
			statement.setString(++count, tb.getPwd());
			statement.setString(++count, tb.getStatus());
			statement.setString(++count, tb.getaType());
			statement.setInt(++count, tb.getAid());
			// statement.setString(++count, tb.getPsk());

			statement.execute();

			return true;

		} catch (SQLException e) {
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

// User verifications
	@Override
	public LoginTb findByUserPass(String userName, String Pass) {
		Log.debug("LoginDAOImpl >  findByUserPass()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Select * from login where user_name= ? and pwd = ? and status = 'Active'";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, userName);

			statement.setString(2, ae.encrypt(Pass));

			ResultSet result = statement.executeQuery();

			LoginTb ab = new LoginTb();

			if (result.next()) {
				System.out.println();
				ab.setUid(result.getInt("uid"));
				ab.setUserName(result.getString("user_name"));
				ab.setPwd(result.getString("pwd"));
				ab.setStatus(result.getString("status"));
				ab.setaType(result.getString("a_type"));
				ab.setAid(result.getInt("aid"));

			}
			// System.out.println(ab);
			return ab;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	public List<ApPen> applications() {
		Log.debug("LoginDAOImpl >  applications()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT ab.acc_no AS acc_no, bal, first_name , last_name, email, zipCode, user_name, a_type, status "
					+ " FROM acc_bal ab  JOIN account a ON ab.acc_no =a.acc_no \r\n" + "JOIN login l ON a.aid = l.aid "
					+ " WHERE status='Disable';";

			PreparedStatement statement = conn.prepareStatement(sql);
//System.out.println(statement);
			ResultSet result = statement.executeQuery();
//System.out.println(statement);
			List<ApPen> tb = new ArrayList<>();
			while (result.next()) {
				ApPen ab = new ApPen();

				ab.setAcc_no(result.getInt("acc_no"));
				ab.setBal(result.getDouble("acc_no"));
				ab.setFName(result.getString("first_name"));
				ab.setlName(result.getString("last_name"));
				ab.setZipCode(result.getInt("zipCode"));
				ab.setEmail(result.getString("email"));
				ab.setUser_name(result.getString("user_name"));
				ab.setStatus(result.getString("status"));
				ab.setAtype(result.getString("a_type"));

				tb.add(ab);

			}
			return tb;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	public List<ApPen> proFileReport(int acc) {
		Log.debug("LoginDAOImpl >  proFileReport()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT ab.acc_no AS acc_no, bal, first_name , last_name, email, zipCode, user_name, a_type, status \r\n"
					+ "FROM acc_bal ab \r\n" + "JOIN account a ON ab.acc_no =a.acc_no \r\n"
					+ "JOIN login l ON a.aid = l.aid \r\n" + "WHERE ab.acc_no = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, acc);
			ResultSet result = statement.executeQuery();
//System.out.println(statement);
			List<ApPen> list = new ArrayList<>();
			while (result.next()) {
				ApPen ab =new ApPen();
				ab.setAcc_no(result.getInt("acc_no"));
				ab.setBal(result.getDouble("acc_no"));
				ab.setFName(result.getString("first_name"));
				ab.setlName(result.getString("last_name"));
				ab.setZipCode(result.getInt("zipCode"));
				ab.setEmail(result.getString("email"));
				ab.setUser_name(result.getString("user_name"));
				ab.setStatus(result.getString("status"));
				ab.setAtype(result.getString("a_type"));
				list.add(ab);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	public ListIterator<ApPen> ListIterator() {
		Log.debug("LoginDAOImpl >  ListIterator()");
		List<ApPen> td = applications();

		ListIterator<ApPen> arItr = td.listIterator();
		return arItr;
	}
	public ListIterator<ApPen> ListIteratorProfile(int acc) {
		Log.debug("LoginDAOImpl >  ListIteratorProfile()");
		List<ApPen> td = proFileReport(acc);

		ListIterator<ApPen> arItr = td.listIterator();
		return arItr;
	}
	public ListIterator<ApPen> ListIteratorAllProfile() {
		Log.debug("LoginDAOImpl >  ListIteratorAllProfile()");
		List<ApPen> td = AllProfileReport();
		ListIterator<ApPen> arItr = td.listIterator();
		return arItr;
	}

	private List<ApPen> AllProfileReport() {
		Log.debug("LoginDAOImpl >  AllProfileReport()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT ab.acc_no AS acc_no, bal, first_name , last_name, email, zipCode, user_name, a_type, status \r\n"
					+ "FROM acc_bal ab \r\n" + "JOIN account a ON ab.acc_no =a.acc_no \r\n"
					+ "JOIN login l ON a.aid = l.aid \r\n" + ";";

			PreparedStatement statement = conn.prepareStatement(sql);
		
			ResultSet result = statement.executeQuery();
//System.out.println(statement);
			List<ApPen> list = new ArrayList<>();
			while (result.next()) {
				ApPen ab =new ApPen();
				ab.setAcc_no(result.getInt("acc_no"));
				ab.setBal(result.getDouble("acc_no"));
				ab.setFName(result.getString("first_name"));
				ab.setlName(result.getString("last_name"));
				ab.setZipCode(result.getInt("zipCode"));
				ab.setEmail(result.getString("email"));
				ab.setUser_name(result.getString("user_name"));
				ab.setStatus(result.getString("status"));
				ab.setAtype(result.getString("a_type"));
				list.add(ab);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public void log(int uid) {
		Log.debug("LoginDAOImpl >  log()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM log_user(?);";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, uid);

			statement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String getMyUserName(String email, int zipCode) {
		Log.debug("LoginDAOImpl >  getMyUserName()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT user_name FROM login l JOIN account a ON l.aid = a.aid WHERE email ="
					+ " ? AND zipcode = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.setInt(2, zipCode);

			ResultSet result = statement.executeQuery();

			if (result.next()) {
				return result.getString("user_name");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public String resetPassword(String userName, String email, int zipCode) {
		Log.debug("LoginDAOImpl >  resetPassword()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "  SELECT pwd FROM login l JOIN account a ON l.aid = a.aid WHERE email ="
					+ " ? AND zipcode = ? AND user_name = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, email);
			statement.setInt(2, zipCode);
			statement.setString(3, userName);
			ResultSet result = statement.executeQuery();

			if (result.next()) {
				return ae.decrypt(result.getString("pwd"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	public boolean updateUser(String fname, String lname, String email, int pzipCode, String user) {
		Log.debug("LoginDAOImpl >  updateUser()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE account SET first_name =?, last_name = ?, email =?, zipcode = ?"
					+ " WHERE aid = (SELECT aid FROM login WHERE user_name = ?)";

			int count = 0;

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(++count, fname);
			statement.setString(++count, lname);
			statement.setString(++count,email);
			statement.setInt(++count, pzipCode);
			statement.setString(++count, user);
			// statement.setString(++count, tb.getPsk());

			statement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

}
