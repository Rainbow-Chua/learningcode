package com.rainbowpro.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.rainbowpro.dao.BookDao;
import com.rainbowpro.model.Book;
import com.rainbowpro.model.BookType;
import com.rainbowpro.util.DbUtil;

/**
 * Servlet implementation class MyServletForLogin
 */
public class MyServletForBookManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DbUtil dbUtil = new DbUtil();
	private BookDao bookDao = new BookDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServletForBookManager() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookName=request.getParameter("bookName");
	    String bookAuthor=request.getParameter("bookAuthor");
	    String[] bookTypeInfo = null;
	    Integer bookTypeId = null;
	    if(request.getParameter("bookType").split(",")!=null){
	    	bookTypeInfo=request.getParameter("bookType").split(",");
	    	bookTypeId=Integer.parseInt(bookTypeInfo[1]);
	    }
	    bookName=new String(bookName.getBytes("iso8859-1"),"UTF-8");
	    bookAuthor=new String(bookAuthor.getBytes("iso8859-1"),"UTF-8");
        Connection conn = null;  
        ResultSet res = null;  
        Book book = new Book(bookName, bookAuthor, bookTypeId);
        //声明一个ArrayList.用来存放Book类中的数据  
        ArrayList<Book> list = new ArrayList<Book>();  
        try {  
        	conn = dbUtil.getCon();
            res = bookDao.list(conn, book);
            while (res.next()) {  
                //建立了一个实体类,用来存放从数据库中拿到的数据  
                Book book1 = new Book();  
                book1.setId(Integer.parseInt(res.getString("id")));
                book1.setBookName(res.getString("bookName"));
                book1.setAuthor(res.getString("author"));  
                book1.setPrice(Float.parseFloat(res.getString("price")));  
                book1.setSex(res.getString("sex")); 
                book1.setBookDesc(res.getString("bookDesc")); 
                book1.setBookTypeName(res.getString("bookTypeName"));
                list.add(book1);  
            }
            //将list数据打包  
            request.setAttribute("list", list);  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        //将list数据发送到.jsp文件中  
        request.getRequestDispatcher("BookManager.jsp").forward(request, response);  
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		String bookId=request.getParameter("bookId");
		String bookName=request.getParameter("bookName1");
		String bookAuthor=request.getParameter("bookAuthor1");
		String bookPrice=request.getParameter("bookPrice1");
		String bookDec=request.getParameter("bookDec1");
		String[] bookTypeInfo=request.getParameter("bookType1").split(",");
		String bookTypeId=bookTypeInfo[1];
		String authorSex=request.getParameter("Sex");
		//解决中文乱码问题
		bookName=new String(bookName.getBytes("iso8859-1"),"UTF-8");
		bookAuthor=new String(bookAuthor.getBytes("iso8859-1"),"UTF-8");
		bookDec=new String(bookDec.getBytes("iso8859-1"),"UTF-8");
		authorSex=new String(authorSex.getBytes("iso8859-1"),"UTF-8");
		System.out.println(bookId + " " +bookName+" "+bookAuthor+" "+bookPrice+" "+bookDec+" "+bookTypeId+" "+authorSex);
		if(request.getParameter("modify")!=null){
			try {
				con = dbUtil.getCon();
				Book b = new Book(Integer.parseInt(bookId), bookName, bookAuthor, authorSex, Float.parseFloat(bookPrice), Integer.parseInt(bookTypeId), bookDec);
				int num = update(con, b);
				if(num == 1){
					response.sendRedirect("modifyBookSuccess.jsp");
				}else{
					response.sendRedirect("modifyBookFailed.jsp");
				}
			} catch (Exception e1) {
				response.sendRedirect("modifyBookFailed.jsp");
				e1.printStackTrace();
			} finally{
				try {
					dbUtil.close(con);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else if(request.getParameter("delete")!=null){
			try {
				con = dbUtil.getCon();
				int num = delete(con,bookId);
				if(num == 1){
					response.sendRedirect("modifyBookSuccess.jsp");
				}else{
					response.sendRedirect("modifyBookFailed.jsp");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	/**
	 * 图书信息删除
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	private int delete(Connection con, String id) throws Exception{
		String sql = "delete from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}
	
	/**
	 * 图书信息更改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	private int update(Connection con, Book book)throws Exception{
		String sql = "update t_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getSex());
		pstmt.setFloat(4, book.getPrice());
		pstmt.setString(5, book.getBookDesc());
		pstmt.setInt(6, book.getBookTypeId());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}
			

}
