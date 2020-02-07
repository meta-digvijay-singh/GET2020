<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mps.pojo.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type = "text/javascript">
	
	function edit(elementId) {
		document.getElementById(elementId).readOnly = false;
		
	}
	
</script>
</head>
<body>

	<%
	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		if (session.getAttribute("emailId") == null) {
			response.sendRedirect("login.jsp");
			return;
		}
		Employee emp = (Employee) session.getAttribute("employee");
		if (emp == null) {
			response.sendRedirect("login.jsp");
		}
	%>

	
	<form action = "updatepersonaldetails" method = "post">
		
		<input type="hidden" name="employeeId" value="<%= emp.getEid() %>" readonly>
		<label for = "firstName">First Name </label><br>
		<input id="firstName" name="firstName" type="text" placeholder="First Name" value="<%=emp.getEmpFirstName()%>" readonly>
		<input type = "button" onclick = "edit('firstName')" value = "edit"> <br>
		<label for = "lastName">Last Name </label><br>
		<input id="lastName" name="lastName" type="text" placeholder="Last Name" value="<%=emp.getEmpLastName()%>" readonly> 
		<input type = "button" onclick = "edit('lastName')" value = "edit"> <br> 
		<label for = "emailId">Email Id </label><br>
		<input id="emailId" name="emailId" type="text" placeholder="Email Id" value="<%=emp.getEmailId()%>" readonly> 
		<input type = "button" onclick = "edit('emailId')" value = "edit"> <br>
		<label for = "password">Password </label><br>
		<input id="password" name="password" type="text" placeholder="Password" value="<%=emp.getPassword()%>" readonly> 
		<input type = "button" onclick = "edit('password')" value = "edit"> <br>
		<label for = "mobileNumber">Mobile Number </label><br>
		<input id="mobileNumber" name="mobileNumber" type="text" placeholder="Mobile Number" value="<%=emp.getMobileNumber()%>" readonly> 
		<input type = "button" onclick = "edit('mobileNumber')" value = "edit"> <br>
		<label for = "orgName">Organization Name </label><br>
		<input id="orgName" name="orgName" type="text" placeholder="Organization Name" value="<%=emp.getOrgName()%>" readonly> 
		<input type = "button" onclick = "edit('orgName')" value = "edit"> <br>
		<input type = "submit" value = "update">
	</form>
	
	
</body>
</html>