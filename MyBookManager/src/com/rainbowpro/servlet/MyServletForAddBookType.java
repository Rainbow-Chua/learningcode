package com.rainbowpro.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rainbowpro.dao.BookTypeDao;
import com.rainbowpro.model.BookType;
import com.rainbowpro.util.DbUtil;

/**
 * Servlet implementation class MyServletForLogin
 */
public class MyServletForAddBookType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServletForAddBookType() {
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
		   String bookTypeName=request.getParameter("bookTypeName");
	       String bookTypeDesc=request.getParameter("bookTypeDesc");
	       //解决中文乱码问题
	       bookTypeName=new String(bookTypeName.getBytes("iso8859-1"),"UTF-8");
	       bookTypeDesc=new String(bookTypeDesc.getBytes("iso8859-1"),"UTF-8");
			BookType bookType = new BookType(bookTypeName, bookTypeDesc);
			Connection con = null;
			try {
				con = dbUtil.getCon();
				int n = bookTypeDao.add(con, bookType);
				if(n == 1){
					response.sendRedirect("addBookTypeSuccess.jsp");
				}else{
					response.sendRedirect("addBookTypeFailed.jsp");
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}finally{
				try {
					dbUtil.close(con);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}

}
