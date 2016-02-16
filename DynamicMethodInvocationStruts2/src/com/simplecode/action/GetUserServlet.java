/*
 * @Programmer sushil kumar bhaskar JSR 1.0 skbh 
 * @Auther ${Programmer_Name}
 * @Project Name Dynamic Method Invocation
 * @File Name GetUserServlet.java
 * 
 */
package com.simplecode.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetUserServlet
 */
public class GetUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName").trim();
		if (userName == null || "".equals(userName)) {
			userName = "Guest";
		}

		String greetings = "Hello " + userName;

		response.setContentType("text/plain");
		response.getWriter().write(greetings);
	}

}
