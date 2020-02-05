package com.mps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mps.dao.EmployeeDao;
import com.mps.pojo.Employee;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		long mobileNumber = Long.parseLong(request.getParameter("mobileNumber"));
		String orgName = request.getParameter("orgName");
		System.out.println(employeeId + " " + firstName + " " + lastName + " " + emailId + " " + password + " " + mobileNumber + " " + orgName);
		Employee emp = new Employee();
		emp.setEid(employeeId);
		emp.setEmpFirstName(firstName);
		emp.setEmpLastName(lastName);
		emp.setEmailId(emailId);
		emp.setPassword(password);
		emp.setMobileNumber(mobileNumber);
		emp.setOrgName(orgName);
		
		if (EmployeeDao.updateEmployee(emp)) {
			HttpSession session = request.getSession();
			session.setAttribute("employee", emp);
			response.sendRedirect("homepage.jsp");
		} else {
			response.sendRedirect("homepage.jsp");
		}
	}

}
