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
@WebServlet("/McsPage")
public class McsServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String FirstName = request.getParameter("fname");
	String Degree = request.getParameter("degree");
	try {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
		PreparedStatement ps = c.prepareStatement("select * from registerform where fname=? and degree=?");
		ps.setString(1, FirstName);
		ps.setString(2, Degree);
		if (Degree.equals("MCS")) {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				request.setAttribute("fname", rs.getString(1));
				request.setAttribute("lname", rs.getString(2));
				request.setAttribute("email", rs.getString(3));
				request.setAttribute("password", rs.getString(4));
				request.setAttribute("address", rs.getString(5));
				request.setAttribute("state", rs.getString(6));
				request.setAttribute("city", rs.getString(7));
				request.setAttribute("country", rs.getString(8));
				request.setAttribute("mobile_no", rs.getString(9));
				request.setAttribute("aadhar_no", rs.getString(10));
				request.setAttribute("age", rs.getString(11));
				request.setAttribute("gender", rs.getString(12));
				request.setAttribute("dob", rs.getString(13));
				request.setAttribute("degree", rs.getString(14));
				request.setAttribute("passing_year", rs.getString(15));
				request.setAttribute("marks", rs.getString(16));
				RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
				rd.include(request, response);

			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.print("<h1 style='color:red;'>first name   don't match.....!</h1>");
				RequestDispatcher rd = request.getRequestDispatcher("/McsStudentProfile.html");
				rd.include(request, response);

			}
			c.close();
		} else {

			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.print("<h1 style='color:red;'>The degree name don't match.....!</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/McsStudentProfile.html");
			rd.include(request, response);
		}
	} catch (Exception e) {

	}
}
}
