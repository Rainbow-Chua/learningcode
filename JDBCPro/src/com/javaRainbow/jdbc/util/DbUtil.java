package com.javaRainbow.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbUtil {

			//���ݿ��ַ
			private static String dbUrl="jdbc:mysql://localhost:3306/db_bank";
			//�û���
			private static String dbUserName="root";
			//����
			private static String dbPassword="123456";
			//��������
			private static String jdbcName="com.mysql.jdbc.Driver";
			
			/**
			 * ��ȡ���ݿ�����
			 * @return
			 * @throws Exception
			 */
			public Connection getCon() throws Exception{
				Class.forName(jdbcName);
				Connection con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
				return con;
			}
			/**
			 * �ر�����
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
}
