package com.javaRainbow.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Test {

	private static DBUtil dbUntil = new DBUtil();

	/**
	 * 转出
	 * 
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void outCount(Connection con, BankAccount ba, int account) throws Exception {
		String sql = "update t_account set accountBalance=accountBalance-? where accountName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, account);
		pstmt.setString(2, ba.getAccountName());
		pstmt.executeUpdate();
		ba.setBalance(ba.getBalance() - account);
		pstmt.close();
	}

	/**
	 * 转入
	 * 
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void inCount(Connection con, BankAccount ba, int account) throws Exception {
		String sql = "update t_account set accountBalance=accountBalance+? where accountName=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, account);
		pstmt.setString(2, ba.getAccountName());
		pstmt.executeUpdate();
		ba.setBalance(ba.getBalance() + account);
		pstmt.close();
	}
	

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = dbUntil.getCon();
			BankAccount zs = new BankAccount(1, "张三", 1000);
			BankAccount ls = new BankAccount(2, "李四", 1000);
			Scanner scanner = new Scanner(System.in);
			int account = scanner.nextInt();
			scanner.close();
			System.out.println("张三开始向李四转账" + account + "元");
			outCount(con, ls, account);
			inCount(con, zs, account);
			System.out.println("转账成功");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
