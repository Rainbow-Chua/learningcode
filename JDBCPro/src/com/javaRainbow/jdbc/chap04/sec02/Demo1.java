package com.javaRainbow.jdbc.chap04.sec02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.javaRainbow.jdbc.model.Book;
import com.javaRainbow.jdbc.util.DbUtil;

public class Demo1 {

	private static DbUtil dbUtil=new DbUtil();
	
	private static int addBook(Book book)throws Exception{
		Connection con=dbUtil.getCon();
		String sql="insert into t_book values(null,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setFloat(2, book.getPrice());
		pstmt.setString(3, book.getAuthor());
		pstmt.setInt(4, book.getId());
		int result=pstmt.executeUpdate();
		dbUtil.close(pstmt, con);
		return result;
	}
	public static void main(String[] args) throws Exception {
		Book book=new Book("Java贤",250,"OJJ",2);
		int result=addBook(book);
		if(result==1){
			System.out.println("添加成功");
		}
		else{
			System.out.println("添加失败");
		}
	}
}
