package com.mps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mps.dao.PassDao;
import com.mps.pojo.Pass;

public class PassServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String passType = request.getParameter("passType");
		float price = Float.parseFloat(request.getParameter("price"));
		int employeeId = Integer.parseInt(request.getParameter("eid"));
		System.out.println(passType + " " + price + " " + employeeId);
		Pass pass = new Pass();
		pass.setPassType(passType);
		pass.setPrice(price);
		PrintWriter out = response.getWriter();
		try {
			System.out.println(PassDao.addPass(pass, employeeId));
			//response.sendRedirect("http://www.google.com");
			System.out.println("google redirect not working");
			return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
