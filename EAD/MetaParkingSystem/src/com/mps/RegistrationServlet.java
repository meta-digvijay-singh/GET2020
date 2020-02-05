package com.mps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mps.dao.EmployeeDao;
import com.mps.pojo.Employee;

public class RegistrationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fullName").split(" ")[0].toLowerCase();
		String lastName = request.getParameter("fullName").split(" ")[1].toLowerCase();
		String emailId = request.getParameter("emailId").toLowerCase();
		//System.out.println(request);
		//System.out.println(request.getParameter("fullName"));
		String gender = request.getParameter("gender").toLowerCase();
		String password = request.getParameter("password").toLowerCase();
		String confirmPassword = request.getParameter("confirmPassword").toLowerCase();
		long contactNumber = Long.parseLong(request.getParameter("mobileNumber"));
		String orgName = request.getParameter("orgName").toLowerCase();
		System.out.println(firstName + " " + lastName + " " + gender + " " + emailId + " " + password + " " + confirmPassword + " " + contactNumber + " " + orgName);
		Employee emp = new Employee();
		emp.setGender(gender);
		emp.setEmpFirstName(firstName);
		emp.setEmpLastName(lastName);
		emp.setEmailId(emailId);
		emp.setPassword(password);
		emp.setConfirmPassword(confirmPassword);
		emp.setMobileNumber(contactNumber);
		emp.setOrgName(orgName);
		PrintWriter out = response.getWriter();
		try {
			int employeeId = EmployeeDao.addEmployee(emp);
			out.println(employeeId);
		} catch (SQLException e) {
			out.println(-1);
		}
	}

}
