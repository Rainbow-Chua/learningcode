package com.javaRainbow.jdbc.chap09.sec04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	
	private static DbUtil dbUntil=new DbUtil();
	/**
	 * 转出
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void outCount(Connection con,String accountName,int account) throws Exception{
		String sql="update t_account set accountBalance=accountBalance-? where accountNAme=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, account);
		pstmt.setString(2, accountName);
		pstmt.executeUpdate();	
	}
	/**
	 * 转入
	 * @param con
	 * @param accountName
	 * @param account
	 * @throws Exception
	 */
	private static void inCount(Connection con,String accountName,int account) throws Exception{
		String sql="update t_account set account=accountBalance+? where accountNAme=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, account);
		pstmt.setString(2, accountName);
		pstmt.executeUpdate();	
	}
	public static void main(String[] args) {
		Connection con=null;
		Savepoint sp=null;
		try {
			con=dbUntil.getCon();
			con.setAutoCommit(false);//取消自动提交，打开事务处理
			System.out.println("张三开始向李四转账500元");
			int account=500;
			outCount(con,"张三",account);
			sp=con.setSavepoint();//设置一个保存点
			inCount(con,"李四",account);
			System.out.println("转账成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				con.rollback(sp);//回滚
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				con.commit();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
