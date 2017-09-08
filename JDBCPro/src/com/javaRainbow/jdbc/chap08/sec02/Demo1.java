package com.javaRainbow.jdbc.chap08.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	/**
	 * ʹ��ResultSetMetaData��ȡResultSet�������Ϣ
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		DbUtil dbUtil=new DbUtil();
		Connection con=dbUtil.getCon();
		String sql="select * from t_book";
		PreparedStatement pstmt=con.prepareStatement(sql);
		ResultSetMetaData rsmd=pstmt.getMetaData();//��ȡԪ����
		int num=rsmd.getColumnCount();//��ȡԪ�����е�����
		System.out.println("����"+num+"��");
		for(int i=1;i<=num;i++){
			System.out.println(rsmd.getColumnName(i)+","+rsmd.getColumnTypeName(i));
		}
	}
}
