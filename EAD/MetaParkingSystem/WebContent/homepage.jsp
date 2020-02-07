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

	Welcome to homepage... <%= emp.getEmpFirstName() %>
	<form action = "logout">
		<input type = "submit" value = "Logout">
	</form>
	
	<form action = "friend">
		<input type = "submit" value = "friends">
	</form>
	
	<form action = "personaldetails.jsp" method = "post">
		<input type = "submit" value = "Show Personal Details">
	</form>
	
	<form action = "vehicledetails.jsp" method = "post">
		<input type = "submit" value = "Show Vehicle Details">
	</form>
	
	<form action = "passdetails.jsp" method = "post">
		<input type = "submit" value = "Show Pass Details">
	</form>
	
</body>
</html>