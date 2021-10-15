package com.revature.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.revature.models.AccBalance;
import com.revature.models.TransactionTb;
import com.revature.util.ConnectionUtil;

public class BalanceDAOImpl implements BalanceDAO {
	private static Logger Log = LoggerFactory.getLogger(BalanceDAOImpl.class);
	private static TransactionTb tb = new TransactionTb();

	@Override
	public List<AccBalance> findAll() {
		Log.debug("BalanceDAOImpl >  findAll()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "Select * from acc_bal";

			Statement statement = conn.createStatement();

			ResultSet result = statement.executeQuery(sql);

			List<AccBalance> list = new ArrayList<>();

			while (result.next()) {

				AccBalance home = new AccBalance();

				home.setBalance(result.getBigDecimal("bal"));

				home.setId(result.getInt("acc_no"));

				list.add(home);

			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccBalance findByAccNumber(int acc) {
		Log.debug("BalanceDAOImpl >  findByAccNumber()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT bal FROM acc_bal ab " + "JOIN account a ON ab.acc_no =a.acc_no "
					+ "JOIN login l ON a.aid = l.aid WHERE l.uid = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, acc);

			ResultSet result = statement.executeQuery();

			AccBalance ab = new AccBalance();

			if (result.next()) {

				ab.setBalance(result.getBigDecimal("bal"));

				// ab.setId(result.getInt("acc_no"));
			}
			return ab;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	public AccBalance findByUserName(String user) {
		Log.debug("BalanceDAOImpl >  findByUserName()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT * FROM acc_bal ab " + "JOIN account a ON ab.acc_no =a.acc_no "
					+ "JOIN login l ON a.aid = l.aid WHERE l.user_name = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setString(1, user);

			ResultSet result = statement.executeQuery();

			AccBalance ab = new AccBalance();

			if (result.next()) {

				ab.setBalance(result.getBigDecimal("bal"));

				ab.setId(result.getInt("acc_no"));
			}
			return ab;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	public AccBalance findByAcc(int acc) {
		Log.debug("BalanceDAOImpl >  findByAcc()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT bal FROM acc_bal WHERE acc_no = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, acc);

			ResultSet result = statement.executeQuery();

			AccBalance ab = new AccBalance();

			if (result.next()) {

				ab.setBalance(result.getBigDecimal("bal"));

				// ab.setId(result.getInt("acc_no"));
			}
			return ab;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public boolean deposit(BigDecimal amount, int uid) {
		Log.debug("BalanceDAOImpl >  deposit()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE acc_bal SET bal = ((SELECT bal FROM acc_bal ab  "
					+ "JOIN account a ON ab.acc_no =a.acc_no " + "JOIN login l ON a.aid = l.aid "
					+ "WHERE l.uid = ? ) + ?) " + "WHERE acc_no = (SELECT ab.acc_no FROM acc_bal ab "
					+ "JOIN account a ON ab.acc_no =a.acc_no " + "JOIN login l ON a.aid = l.aid "
					+ "WHERE l.uid = ? ) ;";

			PreparedStatement statement = conn.prepareStatement(sql);
			int count = 0;
			statement.setInt(++count, uid);
			statement.setBigDecimal(++count, amount);
			statement.setInt(++count, uid);
			if ((statement.executeUpdate()) == 1) {
				tb.setTranType("Deposit");
				tb.setAmount(amount);
				tb.setUid(uid);
				TransDAO tdao = new TransDAOImpl();
				tdao.addTrans(tb);
			}

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deposit(int acc_no, BigDecimal amount) {
		Log.debug("BalanceDAOImpl >  deposit()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE acc_bal SET bal = ((SELECT bal FROM acc_bal ab  " + "WHERE acc_no = ? ) + ?) "
					+ "WHERE acc_no = ?; ";

			PreparedStatement statement = conn.prepareStatement(sql);
			int count = 0;
			statement.setInt(++count, acc_no);
			statement.setBigDecimal(++count, amount);
			statement.setInt(++count, acc_no);

			if ((statement.executeUpdate()) == 1) {
				tb.setTranType("Deposit");
				tb.setAmount(amount);
				tb.setToAccount(acc_no);
				TransDAO tdao = new TransDAOImpl();
				tdao.addTrans(tb);
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	public boolean withdraw(int acc_no, BigDecimal amount) {
		Log.debug("BalanceDAOImpl >  withdraw()");
		AccBalance ac = findByAcc(acc_no);
		BigDecimal bg2 = amount;
		BigDecimal bg4 = new BigDecimal(0);
		BigDecimal bg3 = bg2.subtract(ac.getBalance());
		// System.out.println(bg3);
		if (bg4.compareTo(bg3) == 1) {
			try (Connection conn = ConnectionUtil.getConnection()) {

				String sql = "UPDATE acc_bal SET bal = ((SELECT bal FROM acc_bal ab  " + "WHERE acc_no = ? ) - ?) "
						+ "WHERE acc_no = ?; ";

				PreparedStatement statement = conn.prepareStatement(sql);
				int count = 0;
				statement.setInt(++count, acc_no);
				statement.setBigDecimal(++count, amount);
				statement.setDouble(++count, acc_no);
				if ((statement.executeUpdate()) == 1) {
					tb.setTranType("Withdraw");
					tb.setAmount(amount);
					tb.setAcc_no(acc_no);
					TransDAO tdao = new TransDAOImpl();
					tdao.addTrans(tb);
				}

				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
		}
		System.out.println("Not sufficient balance available");
		return false;

	}

	public boolean withdraw(BigDecimal amount, int uid) {
		Log.debug("BalanceDAOImpl >  withdraw()");
		AccBalance ac = findByAccNumber(uid);

		BigDecimal bg2 = amount;
		BigDecimal bg4 = new BigDecimal(0);
		BigDecimal bg3 = bg2.subtract(ac.getBalance());
		// System.out.println(bg3);
		if (bg4.compareTo(bg3) == 1) {

			try (Connection conn = ConnectionUtil.getConnection()) {

				String sql = "UPDATE acc_bal SET bal = ((SELECT bal FROM acc_bal ab  "
						+ "JOIN account a ON ab.acc_no =a.acc_no " + "JOIN login l ON a.aid = l.aid "
						+ "WHERE l.uid = ? ) - ?) " + "WHERE acc_no = (SELECT ab.acc_no FROM acc_bal ab "
						+ "JOIN account a ON ab.acc_no =a.acc_no " + "JOIN login l ON a.aid = l.aid "
						+ "WHERE l.uid = ? ) ";

				PreparedStatement statement = conn.prepareStatement(sql);
				int count = 0;
				statement.setInt(++count, uid);
				statement.setBigDecimal(++count, amount);
				statement.setInt(++count, uid);

				if ((statement.executeUpdate()) == 1) {
					tb.setTranType("Withdraw");
					tb.setAmount(amount);
					tb.setUid(uid);
					TransDAO tdao = new TransDAOImpl();
					tdao.addTrans(tb);
				}
				return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		System.out.println("Not sufficient balance available");
		return false;
	}

	public boolean transfer(BigDecimal amount, int ota, int uid) {
		Log.debug("BalanceDAOImpl >  transfer()");

		if (withdraw(amount, uid)) {
			if (deposit(ota, amount)) {
				return true;
			}

		} else {
			System.out.println("Something went wrong");
		}

		return false;
	}

	public boolean transfer(BigDecimal amount, int ota, int fta, int uid) {
		Log.debug("BalanceDAOImpl >  transfer()");

		if (withdraw(amount, fta, uid)) {
			if (deposit(ota, amount, uid)) {
				return true;
			}

		} else {
			System.out.println("Something went wrong");
		}

		return false;
	}

	public boolean deposit(int acc_no, BigDecimal amount, int uid) {
		Log.debug("BalanceDAOImpl >  deposit()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "UPDATE acc_bal SET bal = ((SELECT bal FROM acc_bal ab  " + "WHERE acc_no = ? ) + ?) "
					+ "WHERE acc_no = ?; ";

			PreparedStatement statement = conn.prepareStatement(sql);
			int count = 0;
			statement.setInt(++count, acc_no);
			statement.setBigDecimal(++count, amount);
			statement.setInt(++count, acc_no);

			if ((statement.executeUpdate()) == 1) {
				tb.setUid(uid);
				tb.setTranType("Deposit");
				tb.setAmount(amount);
				tb.setToAccount(acc_no);
				TransDAO tdao = new TransDAOImpl();
				tdao.addTrans(tb);
			}
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}

	public boolean withdraw(BigDecimal amount, int acc_no, int uid) {
		Log.debug("BalanceDAOImpl >  withdraw()");

		BigDecimal bg1 = findByA(acc_no);
		BigDecimal bg2 = amount;
		BigDecimal bg4 = new BigDecimal(0);
		BigDecimal bg3 = bg1.subtract(bg2);
		// System.out.println(bg3);
		if (bg3.compareTo(bg4) == 1) {
			try (Connection conn = ConnectionUtil.getConnection()) {

				String sql = "UPDATE acc_bal SET bal = ((SELECT bal FROM acc_bal ab  " + "WHERE acc_no = ? ) - ?) "
						+ "WHERE acc_no = ?; ";

				PreparedStatement statement = conn.prepareStatement(sql);
				int count = 0;
				statement.setInt(++count, acc_no);
				statement.setBigDecimal(++count, amount);
				statement.setDouble(++count, acc_no);
				if ((statement.executeUpdate()) == 1) {
					tb.setUid(uid);
					tb.setTranType("Withdraw");
					tb.setAmount(amount);
					tb.setAcc_no(acc_no);
					TransDAO tdao = new TransDAOImpl();
					tdao.addTrans(tb);
				}

				return true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Not sufficient balance available");
		return false;
	}

	@Override
	public boolean addBalance(AccBalance ab) {
		Log.debug("BalanceDAOImpl >  addBalance()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "INSERT INTO acc_bal (acc_no, bal) " + "VALUES (?,?);";

			int count = 0;

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(++count, ab.getId());
			statement.setBigDecimal(++count, ab.getBalance());

			statement.execute();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public BigDecimal findByA(int acc) {
		Log.debug("BalanceDAOImpl >  findByA()");
		try (Connection conn = ConnectionUtil.getConnection()) {

			String sql = "SELECT bal FROM acc_bal WHERE acc_no = ?;";

			PreparedStatement statement = conn.prepareStatement(sql);

			statement.setInt(1, acc);

			ResultSet result = statement.executeQuery();

		

			if (result.next())
				return result.getBigDecimal("bal");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;

	}

}
