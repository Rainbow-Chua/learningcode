package com.javaRainbow.jdbc.chap07.sec01;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	private static DbUtil dbUtil = new DbUtil();

	/**
	 * ���ô洢����ͨ��ID��ѯbookName
	 */
	private static String getBookNameById(int id) throws Exception {
		Connection con = dbUtil.getCon();//��ȡ���ݿ�����
		String sql = "CALL pro_getBookNameById(?,?)";
		CallableStatement cstmt = con.prepareCall(sql);
		cstmt.setInt(1, id);//���õ�һ������
		cstmt.registerOutParameter(2, Types.VARCHAR);//���õڶ�������
		cstmt.execute();
		String bookName = cstmt.getString("bN");//��ȡ����ֵ
		dbUtil.close(cstmt, con);
		return bookName;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("ͼ�������ǣ�" + getBookNameById(2));
	}
}
