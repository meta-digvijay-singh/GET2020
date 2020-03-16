package com.mps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mps.dao.EmployeeDao;
import com.mps.dao.PassDao;
import com.mps.pojo.Pass;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updatepassdetails")
public class UpdatePassDetailsServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String passType = request.getParameter("passType").toLowerCase();
		float passPrice = Float.parseFloat(request.getParameter("passPrice"));
		
		System.out.println(employeeId + " " + passType + " " + passPrice);
		
		Pass newPass = new Pass();
		newPass.setPassType(passType);
		newPass.setPrice(passPrice);
		
		if (PassDao.updatePass(newPass, employeeId)) {
			HttpSession session = request.getSession();
			session.setAttribute("employeePass", newPass);
			response.sendRedirect("homepage.jsp");
		} else {
			response.sendRedirect("homepage.jsp");
		}
		
		
	}

}
