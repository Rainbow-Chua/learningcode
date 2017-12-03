package com.rainbowpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rainbowpro.model.Book;
import com.rainbowpro.util.StringUtil;

/**
 * 图书Dao类
 * @author Useradmin
 *
 */
public class BookDao {

	/**
	 * 添加图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, Book book)throws Exception{
		String sql = "insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setInt(5, book.getBookTypeId());
		pstmt.setString(6, book.getBookDesc());
		return pstmt.executeUpdate();
		
	}
	
	/**
	 * 查询图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, Book book)throws Exception{
		StringBuffer sb = new StringBuffer("select * from t_book b,t_bookType bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())){
			sb.append(" and bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())){
			sb.append(" and b.author like '%"+book.getAuthor()+"%'");
		}
		if(book.getBookTypeId() != null && book.getBookTypeId() != -1){
			sb.append(" and b.bookTypeId="+book.getBookTypeId());
		}
		PreparedStatement pstmt = con.prepareStatement(sb.toString()+" order by b.id");
		return pstmt.executeQuery();
	}
}
