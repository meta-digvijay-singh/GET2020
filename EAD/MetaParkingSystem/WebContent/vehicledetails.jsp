<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.mps.pojo.Vehicle" %>
<%@ page import="com.mps.pojo.Employee" %>
<%@ page import="com.mps.pojo.Pass" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type = "text/javascript">
	
	function edit(elementId) {
		document.getElementById(elementId).readOnly = false;
		
	}
	
	function updatePrice(passType) {
		let vehicleTypes = document.getElementById("vehicleTypes");
		let vehicleType = vehicleTypes.options[vehicleTypes.selectedIndex].value;
		
		if (vehicleType == "cycle") {
			if (passType == "daily") {
				document.getElementById("vehicleType").value = vehicleType;
				document.getElementById("passPrice").value = 0.07;
			} else if (passType == "monthly") {
				document.getElementById("vehicleType").value = vehicleType;
				document.getElementById("passPrice").value = 1.42;
			} else {
				document.getElementById("vehicleType").value = vehicleType;
				document.getElementById("passPrice").value = 7.14;
			}
		} else if (vehicleType == "motorcycle") {
			if (passType == "daily") {
				document.getElementById("vehicleType").value = vehicleType;
				document.getElementById("passPrice").value = 0.14;
			} else if (passType == "monthly") {
				document.getElementById("vehicleType").value = vehicleType;
				document.getElementById("passPrice").value = 2.85;
			} else {
				document.getElementById("vehicleType").value = vehicleType;
				document.getElementById("passPrice").value = 14.28;
			}
		} else {
			if (passType == "daily") {
				document.getElementById("vehicleType").value = vehicleType;
				document.getElementById("passPrice").value = 0.28;
			} else if (passType == "monthly") {
				document.getElementById("vehicleType").value = vehicleType;
				document.getElementById("passPrice").value = 7.14;
			} else {
				document.getElementById("vehicleType").value = vehicleType;
				document.getElementById("passPrice").value = 50.00;
			}
		}
		alert(document.getElementById("vehicleType").value + " " + document.getElementById("passPrice").value);
		
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
		Vehicle empVehicle = (Vehicle) session.getAttribute("employeeVehicle");
		Pass empPass = (Pass) session.getAttribute("employeePass");
		if (empVehicle == null) {
			response.sendRedirect("login.jsp");
		}
	%>

	
	<form action = "updatevehicledetails" method = "post">
		
		<input type="hidden" name="employeeId" value="<%= emp.getEid() %>" readonly>
		<label for = "vehicleName">Vehicle Name </label><br>
		<input id="vehicleName" name="vehicleName" type="text" placeholder="Vehicle Name" value="<%=empVehicle.getVehicleName() %>" readonly>
		<input type = "button" onclick = "edit('vehicleName')" value = "edit"> <br>
		
		<label for = "vehicleNumber">Vehicle Number </label><br>
		<input id="vehicleNumber" name="vehicleNumber" type="text" placeholder="Vehicle Number" value="<%=empVehicle.getVehicleNumber() %>" readonly>
		<input type = "button" onclick = "edit('vehicleNumber')" value = "edit"> <br>
		
		
		<select id="vehicleTypes" name="vehicleTypes" onchange = "updatePrice('<%=empPass.getPassType().toLowerCase() %>')">
                <option value="cycle">Cycle</option>
                <option value="motorcycle">MotorCycle</option>
                <option value="fourwheelers">Four Wheelers</option>
        </select>
        <br>
        
        <input id="vehicleType" name="vehicleType" type="hidden" value="<%=empVehicle.getVehicleType() %>" readonly>
        <input id="passPrice" name="passPrice" type="hidden" value="<%=empPass.getPrice() %>">
		
        
		<label for = "vehicleIdentification">Vehicle Identification </label><br>
		<input id="vehicleIdentification" name="vehicleIdentification" type="text" placeholder="Vehicle Identification" value="<%=empVehicle.getDescription() %>" readonly>
		<input type = "button" onclick = "edit('vehicleIdentification')" value = "edit"> <br>
		
		<input type = "submit" value = "update">
	</form>
</body>
</html>