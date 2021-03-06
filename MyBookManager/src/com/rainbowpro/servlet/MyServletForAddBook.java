package com.rainbowpro.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rainbowpro.dao.BookDao;
import com.rainbowpro.model.Book;
import com.rainbowpro.util.DbUtil;

/**
 * Servlet implementation class MyServletForLogin
 */
public class MyServletForAddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DbUtil dbUtil = new DbUtil();
	private BookDao bookDao = new BookDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServletForAddBook() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   //根据标示名获取JSP文件中表单所包含的参数
		   String bookName=request.getParameter("bookName");
	       String bookAuthor=request.getParameter("bookAuthor");
	       String bookPrice=request.getParameter("bookPrice");
	       String bookDec=request.getParameter("bookDec");
	       String[] bookTypeInfo=request.getParameter("bookType").split(",");
	       String bookTypeId=bookTypeInfo[1];
	       String authorSex=request.getParameter("Sex");
	       //解决中文乱码问题
	       bookName=new String(bookName.getBytes("iso8859-1"),"UTF-8");
	       bookAuthor=new String(bookAuthor.getBytes("iso8859-1"),"UTF-8");
	       bookDec=new String(bookDec.getBytes("iso8859-1"),"UTF-8");
	       authorSex=new String(authorSex.getBytes("iso8859-1"),"UTF-8");
	       System.out.println(bookName+" "+bookAuthor+" "+bookPrice+" "+bookDec+" "+bookTypeId+" "+authorSex);
	       try{
				Book book = new Book(bookName, bookAuthor, authorSex, Float.parseFloat(bookPrice), Integer.parseInt(bookTypeId), bookDec);
				Connection con = null;
				try{
					con = dbUtil.getCon();
					int addNum = bookDao.add(con, book);
					if(addNum == 1){
						response.sendRedirect("addBookSuccess.jsp");
					}else{
						response.sendRedirect("addBookFailed.jsp");
					}
				}catch(Exception e){
					response.sendRedirect("addBookFailed.jsp");
					e.printStackTrace();
				}finally{
					try {
						dbUtil.close(con);
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}
			}catch(Exception e){
				response.sendRedirect("addBookFailed.jsp");
				e.printStackTrace();
			}
	       
	}

}
