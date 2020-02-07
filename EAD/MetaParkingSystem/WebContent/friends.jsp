<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.mps.pojo.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%
	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		if (session.getAttribute("emailId") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		List<Employee> friends = (List<Employee>) session.getAttribute("friends");
		
		if (friends == null) {
			response.sendRedirect("login.jsp");
		}
		
	%>
	
	<table style = "border: 2px solid black;">
			    <thead>
		        <tr>
		            
		            <th>First Name</th>
		            <th>Last Name</th>
		            <th>Gender</th>
		            <th>EmailId</th>
		            <th>Contact Number</th>
		            <th>Organization Name</th>
		        </tr>
		    </thead>
		    <tbody>
		    <%
		    	for (Employee friend : friends) {
			    	out.println("<tr>");
		            out.println("<td>" + friend.getEmpFirstName() + "</td>");
		            out.println("<td>" + friend.getEmpLastName() + "</td>");
		            out.println("<td>" + friend.getGender() + "</td>");
		            out.println("<td>" + friend.getEmailId() + "</td>");
		            out.println("<td>" + friend.getMobileNumber() + "</td>");
		            out.println("<td>" + friend.getOrgName() + "</td>");
		            out.println("<tr>");
		    	}
			    
	        	
		    %>
		        
		    </tbody>
		</table>
	
</body>
</html>