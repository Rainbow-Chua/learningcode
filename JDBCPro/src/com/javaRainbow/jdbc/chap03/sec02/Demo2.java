package com.javaRainbow.jdbc.chap03.sec02;

import java.sql.Connection;
import java.sql.Statement;

import com.javaRainbow.jdbc.model.Book;
import com.javaRainbow.jdbc.util.DbUtil;

public class Demo2 {

	private static DbUtil dbUtil=new DbUtil();
	/**
	 * 添加图书
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
		Statement stmt=con.createStatement();//创建Statement
		int result=stmt.executeUpdate(sql);
		dbUtil.close(stmt, con);//关闭Statement和连接
		return result;
	}
	
	public static void main(String[] args) throws Exception {
/*		int result=addBook("Java读书读书", 121, "妞子", 1);
		
		if(result==1){
			System.out.println("添加成功");
		}
		else{
			System.out.println("添加失败");
		}*/
		//多行注释 ctrl+shift+/
		Book book=new Book("Java读书读书2", 1221, "妞子", 2);
		int result=addBook(book);
		if(result==1){
			System.out.println("添加成功");
		}
		else{
			System.out.println("添加失败");
		}
	}
}
