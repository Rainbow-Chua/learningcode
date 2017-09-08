package com.javaRainbow.jdbc.chap08.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	/**
	 * 使用ResultSetMetaData获取ResultSet对象的信息
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		DbUtil dbUtil=new DbUtil();
		Connection con=dbUtil.getCon();
		String sql="select * from t_book";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSetMetaData rsmd=pstmt.getMetaData();//获取元数据
		int num=rsmd.getColumnCount();//获取元数据列的总数
		System.out.println("共有"+num+"列");
		for(int i=1;i<=num;i++){
			System.out.println(rsmd.getColumnName(i)+","+rsmd.getColumnTypeName(i));
		}
	}
}
