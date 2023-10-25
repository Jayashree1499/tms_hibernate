package com.tms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tms.dao.UserDao;
import com.tms.dto.User;

@WebServlet(value = "/verify")
public class UserVerification extends HttpServlet {
	UserDao userDao = new UserDao();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter = resp.getWriter();
//		String userName = req.getParameter("user_name");
		String userEmail = req.getParameter("user_email");
		String password = req.getParameter("user_password");
		User user = userDao.findUserByEmailAndPassword(userEmail, password);
		System.out.println(user);
		if (user != null) {
			String role = user.getRole();
			if (role.equalsIgnoreCase("manager")) {

				List<User> userlist = userDao.fecthAllUser();
				req.setAttribute("employeeList", userlist);
				RequestDispatcher dispatcher = req.getRequestDispatcher("manager.jsp");
				dispatcher.include(req, resp);
			}

			else if (role.equalsIgnoreCase("employee")) {
				req.setAttribute("user_id", user.getUser_id());
				RequestDispatcher dispatcher = req.getRequestDispatcher("find");
				dispatcher.include(req, resp);
			}
		} else {
			printWriter.print("<h1>Get Lost</h1>");

		}

	}
}