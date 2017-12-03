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

import com.rainbowpro.dao.BookTypeDao;
import com.rainbowpro.model.Book;
import com.rainbowpro.model.BookType;
import com.rainbowpro.util.DbUtil;

/**
 * Servlet implementation class MyServletForLogin
 */
public class MyServletForBookTypeManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DbUtil dbUtil = new DbUtil();
	private BookTypeDao bookTypeDao = new BookTypeDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServletForBookTypeManager() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookTypeName=request.getParameter("bookTypeName");
		bookTypeName=new String(bookTypeName.getBytes("iso8859-1"),"UTF-8");
        Connection conn = null;  
        ResultSet res = null;  
        BookType bookType = new BookType();
        bookType.setBookTypeName(bookTypeName);
        //声明一个ArrayList.用来存放BookType类中的数据  
        ArrayList<BookType> list = new ArrayList<BookType>();  
        try {  
        	conn = dbUtil.getCon();	
            res = bookTypeDao.list(conn, bookType);
            while (res.next()) {  
                //建立了一个实体类,用来存放从数据库中拿到的数据  
                BookType bookType1 = new BookType();  
                bookType1.setId(Integer.parseInt(res.getString("id")));
                bookType1.setBookTypeName(res.getString("bookTypeName"));
                bookType1.setNum(Integer.parseInt(res.getString("booknum")));  
                bookType1.setBookTypeDesc(res.getString("bookTypeDesc"));  
                list.add(bookType1);  
            }
            //将list数据打包  
            request.setAttribute("list", list);  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        //将list数据发送到.jsp文件中  
        request.getRequestDispatcher("BookTypeManager.jsp").forward(request, response);  
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		String bookTypeId=request.getParameter("bookTypeId");
		String bookTypeName1=request.getParameter("bookTypeName1");
		String bookTypeDec1=request.getParameter("bookTypeDec1");
		String modify = request.getParameter("modify");
		String delete = request.getParameter("delete");
		//解决中文乱码问题
		bookTypeName1=new String(bookTypeName1.getBytes("iso8859-1"),"UTF-8");
		bookTypeDec1=new String(bookTypeDec1.getBytes("iso8859-1"),"UTF-8");
		System.out.println(bookTypeName1+" "+bookTypeDec1);
		if(modify!=null){
			try {
				con = dbUtil.getCon();
				BookType b = new BookType(Integer.parseInt(bookTypeId), bookTypeName1, bookTypeDec1);
				int num = bookTypeDao.update(con, b);
				if(num == 1){
					response.sendRedirect("modifyBookTypeSuccess.jsp");
				}else{
					response.sendRedirect("modifyBookTypeFailed.jsp");
				}
			} catch (Exception e1) {
				response.sendRedirect("modifyBookTypeFailed.jsp");
				e1.printStackTrace();
			} finally{
				try {
					dbUtil.close(con);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		} else {
			try {
				con = dbUtil.getCon();
				System.out.println(bookTypeId);
				int num = bookTypeDao.delete(con,bookTypeId);
				if(num == 1){
					response.sendRedirect("modifyBookTypeSuccess.jsp");
				}else{
					response.sendRedirect("modifyBookTypeFailed.jsp");
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	
	
			

}
