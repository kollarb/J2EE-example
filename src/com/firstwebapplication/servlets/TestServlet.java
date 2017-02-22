package com.firstwebapplication.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.firstwebapplication.dao.LoginDao;
import com.firstwebapplication.model.UserModel;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final boolean SUCCESS=true;

	//Service method
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("userName");
		String password= request.getParameter("password");
		
		UserModel um = new UserModel();
		um.setUserName(userName);
		um.setPassword(password);
		RequestDispatcher rd=null;
		HttpSession session= request.getSession();
		PrintWriter out = response.getWriter(); 
		LoginDao loginDao= new LoginDao();
		boolean result=loginDao.checkUserValidity(um);
		if(result==SUCCESS){
		request.setAttribute("userModel", um);	
		session.setAttribute("Username", userName);
		rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
		}else{
			out.print("<p style=\"color:red\">Sorry username or password error</p>"); 
			rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
		
	}
}
