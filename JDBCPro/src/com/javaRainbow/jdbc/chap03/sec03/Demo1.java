package com.javaRainbow.jdbc.chap03.sec03;

import java.sql.Connection;
import java.sql.Statement;

import com.javaRainbow.jdbc.model.Book;
import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	private static DbUtil dbUtil = new DbUtil();
	/**
	 * ����ͼ��
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private static int updateBook(Book book) throws Exception {
		Connection con = dbUtil.getCon();// ��ȡ����
		String sql = "update t_book set bookName='" + book.getBookName() + "',price=" + book.getPrice() + ",author='"
				+ book.getAuthor() + "',bookTypeId=" + book.getBookTypeId() + " where id=" + book.getId();
		Statement stmt = con.createStatement();// ����Statement
		int result = stmt.executeUpdate(sql);
		dbUtil.close(stmt, con);// �ر�Statement������
		return result;//ctrl+aȫѡ ctrl+shift+f ��ʽ��
	}

	public static void main(String[] args) throws Exception {
		Book book=new Book(3,"dsada",222,"wwwww",1);
		int result=updateBook(book);
		if(result==1){
			System.out.println("���³ɹ�");
		}
		else{
			System.out.println("����ʧ��");
		}
		
	}
}
