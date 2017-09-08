package com.javaRainbow.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.Statement;

import com.javaRainbow.jdbc.model.Book;
import com.javaRainbow.jdbc.util.DbUtil;

public class Demo2 {

	private static DbUtil dbUtil=new DbUtil();
	/**
	 * ���ͼ��
	 * @param bookName
	 * @param price
	 * @param author
	 * @param bookTypeId
	 * @return
	 * @throws Excepion
	 */
	private static int addBook(Book book)throws Exception{
		Connection con=dbUtil.getCon();
		String sql="insert into t_book values(null,'"+book.getBookName()+"',"+book.getPrice()+",'"+book.getAuthor()+"',"+book.getBookTypeId()+")";
		Statement stmt=con.createStatement();//����Statement
		int result=stmt.executeUpdate(sql);
		dbUtil.close(stmt, con);//�ر�Statement������
		return result;
	}
	
	public static void main(String[] args) throws Exception {
/*		int result=addBook("Java�������", 121, "���", 1);
		
		if(result==1){
			System.out.println("��ӳɹ�");
		}
		else{
			System.out.println("���ʧ��");
		}*/
		//����ע�� ctrl+shift+/
		Book book=new Book("Java�������2", 1221, "���", 2);
		int result=addBook(book);
		if(result==1){
			System.out.println("��ӳɹ�");
		}
		else{
			System.out.println("���ʧ��");
		}
	}
}
