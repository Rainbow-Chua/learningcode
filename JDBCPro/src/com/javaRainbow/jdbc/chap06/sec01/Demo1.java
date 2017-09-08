package com.javaRainbow.jdbc.chap06.sec01;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.javaRainbow.jdbc.model.Book;
import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	private static DbUtil dbUtil=new DbUtil();

	private static int addBook(Book book)throws Exception{
		Connection con=dbUtil.getCon();
		String sql="insert into t_book values(null,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setFloat(2, book.getPrice());
		pstmt.setString(3, book.getAuthor());
		pstmt.setInt(4, book.getBookTypeId());
		File context=book.getContext();//获取文件
		InputStream inputStream=new FileInputStream(context);
		pstmt.setAsciiStream(5, inputStream, context.length());
		int result=pstmt.executeUpdate();
		dbUtil.close(pstmt, con);
		return result;
	}
	
	public static void getBook(int id) throws Exception{
		Connection con=dbUtil.getCon();
		String sql="select * from t_book where id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			String bookName=rs.getString("bookName");
			float price=rs.getFloat("price");
			String author=rs.getString("author");
			int bookTypeId=rs.getInt("bookTypeId");
			Clob c=rs.getClob("context");
			String context=c.getSubString(1, (int)c.length());
			System.out.println("图书名称："+bookName);
			System.out.println("图书价格："+price);
			System.out.println("图书类型："+bookTypeId);
			System.out.println("图书作者："+author);
			System.out.println("图书内容："+context);
		}
		dbUtil.close(pstmt, con);
	}
	public static void main(String[] args) throws Exception {
		/*File context=new File("C:/Users/Useradmin/Desktop/helloWorld.txt");
		Book book=new Book("helloWorld",22,"ccaihon",2,context);
		int result=addBook(book);
		if(result==1){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败");
		}*/
		getBook(12);
	}
}
