package com.javaRainbow.jdbc.chap05.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javaRainbow.jdbc.model.Book;
import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	private static DbUtil dbUtil = new DbUtil();
	/**
	 * ������ѯ�����ʹ�ñ�Ŷ�λ���ݣ�
	 * @throws Exception
	 */
	private static void listBook() throws Exception {
		Connection con = dbUtil.getCon();// ��ȡ����
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();// ���ؽ����ResultSet
		while (rs.next()) {
			int id = rs.getInt(1);// ��ȡ��һ�е�ֵ ��id
			String bookName = rs.getString(2);// ��ȡ�ڶ��� ͼ������
			float price = rs.getFloat(3);// ͼ��۸�
			String author = rs.getString(4);// ����
			int bookTypeId = rs.getInt(5);// ͼ�����ͺ�
			System.out.println(id + " " + bookName + " " + price + " " + author + " " + bookTypeId);
		}
	}
	/**
	 * ������ѯ�����ʹ����������λ���ݣ�
	 * @throws Exception
	 */
	private static void listBook2() throws Exception {
		Connection con = dbUtil.getCon();// ��ȡ����
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();// ���ؽ����ResultSet
		while (rs.next()) {
			int id = rs.getInt("id");// ��ȡ��һ�е�ֵ ��id
			String bookName = rs.getString("bookName");// ��ȡ�ڶ��� ͼ������
			float price = rs.getFloat("price");// ͼ��۸�
			String author = rs.getString("author");// ����
			int bookTypeId = rs.getInt("bookTypeId");// ͼ�����ͺ�
			System.out.println(id + " " + bookName + " " + price + " " + author + " " + bookTypeId);
		}
	}
	/**
	 * ������ѯ�����ʹ����������λ���ݣ�,ʹ�ü��ϴ洢���ݲ�������
	 * @return
	 * @throws Exception
	 */
	private static List<Book> listbook3() throws Exception{
		List<Book> bookList=new ArrayList<Book>();
		Connection con = dbUtil.getCon();// ��ȡ����
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();// ���ؽ����ResultSet
		while (rs.next()) {
			int id = rs.getInt("id");// ��ȡ��һ�е�ֵ ��id
			String bookName = rs.getString("bookName");// ��ȡ�ڶ��� ͼ������
			float price = rs.getFloat("price");// ͼ��۸�
			String author = rs.getString("author");// ����
			int bookTypeId = rs.getInt("bookTypeId");// ͼ�����ͺ�
			Book book=new Book(id,bookName,price,author,bookTypeId);
			bookList.add(book);
		}
		return bookList;
	}

	public static void main(String[] args) throws Exception {
		//listBook2();
//		listBook1();
		List<Book> bookList=listbook3();
		for(Book book:bookList){
			System.out.println(book.toString());
		}
	}
}
