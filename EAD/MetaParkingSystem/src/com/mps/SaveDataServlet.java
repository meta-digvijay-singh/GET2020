package com.mps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class SaveDataServlet
 */
@WebServlet("/saveIt")
public class SaveDataServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int dummyId = 10;
		String name = request.getParameter("name");
		String url = "jdbc:mysql://localhost:3306/mydb";
		String username = "root";
		String passwd = "admin";
		String query = "INSERT INTO Student VALUES (?, ?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, username, passwd);
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, dummyId);
			st.setString(2,  name);
			int rowsAffected = st.executeUpdate();
			PrintWriter out = response.getWriter();
			
			if (rowsAffected > 0) {
				out.println("Data saved successfully.");
			} else {
				out.println("Data did not save.");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
