package com.rainbowpro.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rainbowpro.dao.UserDao;
import com.rainbowpro.model.User;
import com.rainbowpro.util.DbUtil;

/**
 * Servlet implementation class MyServletForLogin
 */
public class MyServletForLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DbUtil dbUtil = new DbUtil();
	private UserDao userDao = new UserDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServletForLogin() {
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
		   String id=request.getParameter("id");
	       String password=request.getParameter("password");
	       User user = new User(id,password);
			Connection con = null;
			try {
				con = dbUtil.getCon();
				User currentUser = userDao.login(con, user);
				if(currentUser != null){
					response.sendRedirect("addBook.jsp");
				}else{
					response.sendRedirect("LoginFailed.jsp");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}

}
