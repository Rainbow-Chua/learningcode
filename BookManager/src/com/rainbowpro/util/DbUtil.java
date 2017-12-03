package com.rainbowpro.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 数据库工具类
 * @author Useradmin
 *
 */
public class DbUtil {

	private String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	private String dbUserName = "root";
	private String dbPassword = "123456";
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	/**
	 * 关闭连接&statement
	 * @param con
	 * @throws Exception
	 */
	public void close(Statement stmt,Connection con)throws Exception{
		if(stmt!=null){
			stmt.close();
			if(con!=null){
				con.close();
			}
		}
	} 
	/**
	 * 关闭连接
	 * @param con
	 * @throws Exception
	 */
	public void close(Connection con)throws Exception{
		con.close();
	}
	public static void main(String[] args) {
		try {
			Connection con = new DbUtil().getCon();
			System.out.println("db connection success!");
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("db connection fail!");
		}
	}
	
}
