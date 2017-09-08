package com.javaRainbow.jdbc.chap09.sec03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	
	private static DbUtil dbUntil=new DbUtil();
	/**
	 * ת��
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
	 * ת��
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
		try {
			con=dbUntil.getCon();
			con.setAutoCommit(false);//ȡ���Զ��ύ����������
			System.out.println("������ʼ������ת��500Ԫ");
			int account=500;
			outCount(con,"����",account);
			inCount(con,"����",account);
			System.out.println("ת�˳ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();//�ع�
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
