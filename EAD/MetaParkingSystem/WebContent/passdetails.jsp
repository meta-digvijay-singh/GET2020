<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mps.pojo.Pass" %>
<%@ page import="com.mps.pojo.Employee" %>
<%@ page import="com.mps.pojo.Vehicle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type = "text/javascript">
	
	function updatePrice(vehicleType) {
		let passTypes = document.getElementById("passTypes");
		let passType = passTypes.options[passTypes.selectedIndex].text;
		
		if (vehicleType == "cycle") {
			if (passType == "daily") {
				document.getElementById("passType").value = passType;
				document.getElementById("passPrice").value = 0.07;
			} else if (passType == "monthly") {
				document.getElementById("passType").value = passType;
				document.getElementById("passPrice").value = 1.42;
			} else {
				document.getElementById("passType").value = passType;
				document.getElementById("passPrice").value = 7.14;
			}
		} else if (vehicleType == "motorcycle") {
			if (passType == "daily") {
				document.getElementById("passType").value = passType;
				document.getElementById("passPrice").value = 0.14;
			} else if (passType == "monthly") {
				document.getElementById("passType").value = passType;
				document.getElementById("passPrice").value = 2.85;
			} else {
				document.getElementById("passType").value = passType;
				document.getElementById("passPrice").value = 14.28;
			}
		} else {
			if (passType == "daily") {
				document.getElementById("passType").value = passType;
				document.getElementById("passPrice").value = 0.28;
			} else if (passType == "monthly") {
				document.getElementById("passType").value = passType;
				document.getElementById("passPrice").value = 7.14;
			} else {
				document.getElementById("passType").value = passType;
				document.getElementById("passPrice").value = 50.00;
			}
		}
		alert(document.getElementById("passType").value + " " + document.getElementById("passPrice").value);
		
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
		Pass empPass = (Pass) session.getAttribute("employeePass");
		Vehicle empVehicle = (Vehicle) session.getAttribute("employeeVehicle");
		if (empPass == null) {
			response.sendRedirect("login.jsp");
		}
	%>

	
	<form action = "updatepassdetails" method = "post">
		
		<input type="hidden" name="employeeId" value="<%= emp.getEid() %>" readonly>
		
		<select id="passTypes" name="passTypes" onchange = "updatePrice('<%=empVehicle.getVehicleType().toLowerCase() %>')">
                <option value="daily">daily</option>
                <option value="monthly">monthly</option>
                <option value="yearly">yearly</option>
        </select>
        
        <input id="passType" name="passType" type="hidden" value="<%=empPass.getPassType() %>">
		<input id="passPrice" name="passPrice" type="hidden" value="<%=empPass.getPrice() %>">
		
		<input type = "submit" value = "update">
	</form>
</body>
</html>