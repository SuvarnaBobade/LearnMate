package com.servletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/changepass")
public class ChangePasswordServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
			PreparedStatement ps = c.prepareStatement("update registerform  set password=? where email=? ");
			ps.setString(1, Password);
			ps.setString(2, Email);
			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print("<h1 style='color:green;'>password updated sucessfully......!</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/LoginPge.html");
				rd.include(request, response);
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print("<h1 style='color:red;'>No user found with the provided email....!</h1>");
				out.print("<h1 style='color:red;'>Please enter valid Email....!</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/ForgotPass.html");
				rd.include(request, response);

			}
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
