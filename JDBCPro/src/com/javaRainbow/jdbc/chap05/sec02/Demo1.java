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
	 * 遍历查询结果（使用编号定位数据）
	 * @throws Exception
	 */
	private static void listBook() throws Exception {
		Connection con = dbUtil.getCon();// 获取连接
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();// 返回结果集ResultSet
		while (rs.next()) {
			int id = rs.getInt(1);// 获取第一列的值 即id
			String bookName = rs.getString(2);// 获取第二列 图书名称
			float price = rs.getFloat(3);// 图书价格
			String author = rs.getString(4);// 作者
			int bookTypeId = rs.getInt(5);// 图书类型号
			System.out.println(id + " " + bookName + " " + price + " " + author + " " + bookTypeId);
		}
	}
	/**
	 * 遍历查询结果（使用属性名定位数据）
	 * @throws Exception
	 */
	private static void listBook2() throws Exception {
		Connection con = dbUtil.getCon();// 获取连接
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();// 返回结果集ResultSet
		while (rs.next()) {
			int id = rs.getInt("id");// 获取第一列的值 即id
			String bookName = rs.getString("bookName");// 获取第二列 图书名称
			float price = rs.getFloat("price");// 图书价格
			String author = rs.getString("author");// 作者
			int bookTypeId = rs.getInt("bookTypeId");// 图书类型号
			System.out.println(id + " " + bookName + " " + price + " " + author + " " + bookTypeId);
		}
	}
	/**
	 * 遍历查询结果（使用属性名定位数据）,使用集合存储数据并遍历。
	 * @return
	 * @throws Exception
	 */
	private static List<Book> listbook3() throws Exception{
		List<Book> bookList=new ArrayList<Book>();
		Connection con = dbUtil.getCon();// 获取连接
		String sql = "select * from t_book";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();// 返回结果集ResultSet
		while (rs.next()) {
			int id = rs.getInt("id");// 获取第一列的值 即id
			String bookName = rs.getString("bookName");// 获取第二列 图书名称
			float price = rs.getFloat("price");// 图书价格
			String author = rs.getString("author");// 作者
			int bookTypeId = rs.getInt("bookTypeId");// 图书类型号
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
