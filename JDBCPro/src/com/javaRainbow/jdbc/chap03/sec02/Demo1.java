package com.javaRainbow.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.Statement;

import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {
	
	public static void main(String[] args) throws Exception {
		DbUtil dbUtil=new DbUtil();
		String sql="insert into t_book values(null,'Java(�ܹ������)',888,'OJ',1)";
		Connection con=dbUtil.getCon();
		Statement stmt=con.createStatement();
		int result=stmt.executeUpdate(sql);
		System.out.println("�����Ľ����"+result+"������");
		stmt.close();//�ر�statement
		con.close();//�ر�����
		
	}
}
