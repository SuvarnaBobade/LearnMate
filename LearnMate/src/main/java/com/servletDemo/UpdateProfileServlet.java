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

@WebServlet("/update")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve data from the form
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String state = request.getParameter("state");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String monumber = request.getParameter("mobile_no");
        String aadharno = request.getParameter("aadhar_no");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String degree = request.getParameter("degree");
        String passingyear = request.getParameter("passing_year");
        String marks = request.getParameter("marks");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "root");

            PreparedStatement ps = c.prepareStatement( "UPDATE registerform SET fname=?, lname=?, password=?, address=?, state=?, city=?, country=?, mobile_no=?, aadhar_no=?, age=?, gender=?, dob=?, degree=?, passing_year=?, marks=? WHERE email=?");
            
            ps.setString(1, fname);
            ps.setString(2, lname);
            ps.setString(3, password);
            ps.setString(4, address);
            ps.setString(5, state);
            ps.setString(6, city);
            ps.setString(7, country);
            ps.setString(8, monumber);
            ps.setString(9, aadharno);
            ps.setString(10, age);
            ps.setString(11, gender);
            ps.setString(12, dob);
            ps.setString(13, degree);
            ps.setString(14, passingyear);
            ps.setString(15, marks);
            ps.setString(16, email);

            int result = ps.executeUpdate(); 

            if (result > 0) {
                request.setAttribute("fname", fname);
                request.setAttribute("lname", lname);
                request.setAttribute("email", email);
                request.setAttribute("password", password);
                request.setAttribute("address", address);
                request.setAttribute("state", state);
                request.setAttribute("city", city);
                request.setAttribute("country", country);
                request.setAttribute("mobile_no", monumber);
                request.setAttribute("aadhar_no", aadharno);
                request.setAttribute("age", age);
                request.setAttribute("gender", gender);
                request.setAttribute("dob", dob);
                request.setAttribute("degree", degree);
                request.setAttribute("passing_year", passingyear);
                request.setAttribute("marks", marks);

                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                out.print("<h1 style='color:green;'>Updated successfully!</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("/profile.jsp");
                rd.include(request, response);
            } else {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                out.print("<h1 style='color:red;'>Update failed. Please try again!</h1>");
                RequestDispatcher rd = request.getRequestDispatcher("/LoginPage.html");
                rd.forward(request, response);
            }

            c.close();
        } catch (Exception e) {
            
        }
    }
}
