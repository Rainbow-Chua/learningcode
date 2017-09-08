package com.javaRainbow.jdbc.chap07.sec01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	private static DbUtil dbUtil = new DbUtil();

	/**
	 * 调用存储过程通过ID查询bookName
	 */
	private static String getBookNameById(int id) throws Exception {
		Connection con = dbUtil.getCon();//获取数据库连接
		String sql = "CALL pro_getBookNameById(?,?)";
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, id);//设置第一个参数
		cstmt.registerOutParameter(2, Types.VARCHAR);//设置第二个参数
		cstmt.execute();
		String bookName = cstmt.getString("bN");//获取返回值
		dbUtil.close(cstmt, con);
		return bookName;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("图书名称是：" + getBookNameById(2));
	}
}
