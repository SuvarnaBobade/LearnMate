package com.servletDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String email = request.getParameter("email");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
			PreparedStatement ps = c.prepareStatement("DELETE FROM registerform WHERE email=?");
			ps.setString(1, email);
			int result = ps.executeUpdate();
			if (result > 0) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print("<h1 style='color:green;'>Record deleted successfully!</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/LoginPge.html");
				rd.include(request, response);
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print("<h1 style='color:red;'>Deletion failed. No such record found!</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.html");
				rd.forward(request, response);
			}

			c.close();
		} catch (Exception e) {

		}
	}
}
