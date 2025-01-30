package com.servletDemo;

import java.io.IOException;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regipage")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String Lname = request.getParameter("lname");
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		String Address = request.getParameter("address");
		String State = request.getParameter("state");
		String City = request.getParameter("city");
		String Country = request.getParameter("country");
		String Monumber = request.getParameter("mo number");
		String Aadharno = request.getParameter("Aadhar_No");
		String Age = request.getParameter("age");
		String Gender = request.getParameter("gender");
		String Dob = request.getParameter("dob");
		String Degree = request.getParameter("degree");
		String Passingyear = request.getParameter("passing year");
		String Marks = request.getParameter("marks");
//	
		System.out.println("sucess...");

		//PrintWriter out = response.getWriter();
		//out.println("inserted successfully....!");

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");
			PreparedStatement ps = c.prepareStatement(
					"insert into registerform(fname, lname, email, password, address, state, city, country,mobile_no, aadhar_no, age, gender, dob, degree, passing_year, marks)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, Lname);
			ps.setString(3, Email);
			ps.setString(4, Password);
			ps.setString(5, Address);
			ps.setString(6, State);
			ps.setString(7, City);
			ps.setString(8, Country);
			ps.setString(9, Monumber);
			ps.setString(10, Aadharno);
			ps.setString(11, Age);
			ps.setString(12, Gender);
			ps.setString(13, Dob);
			ps.setString(14, Degree);
			ps.setString(15, Passingyear);
			ps.setString(16, Marks);
			ps.executeUpdate();
			c.close();
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.print("<h1 style='color:salmon;'>inserted sucessfully......!</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/LoginPge.html");
			rd.include(request, response);
		} catch (Exception e) {

		}

	}

}
