package com.javaRainbow.jdbc.chap03.sec04;

import java.sql.Connection;
import java.sql.Statement;

import com.javaRainbow.jdbc.util.DbUtil;


public class Demo1 {

	private static DbUtil dbUtil = new DbUtil();
	/**
	 * É¾³ýÍ¼Êé
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private static int deleteBook(int id) throws Exception{
		Connection con=dbUtil.getCon();
		String sql="delete from t_book where id="+id;
		Statement stmt=con.createStatement();
		int result=stmt.executeUpdate(sql);
		dbUtil.close(stmt, con);
		return result;
	}
	public static void main(String[] args) throws Exception {
		int result=deleteBook(9);
		if(result==1){
			System.out.println("É¾³ý³É¹¦");
		}
		else{
			System.out.println("É¾³ýÊ§°Ü");
		}
	}
}
