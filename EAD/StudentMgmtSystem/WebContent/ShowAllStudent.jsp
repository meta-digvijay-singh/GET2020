<%@ page language="java"
	import="java.sql.*,java.util.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Records</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
table {
	margin-top: 20px;
	margin-left: 350px;
	border: 2px solid black;
	border-collapse: collapse;
}

h1 {
	margin-left: 450px;
}

td, th {
	text-align: center;
	padding: 4px;
	margin: 4px;
	border: 2px solid black;
}

a {
	text-underline-position: unset;
	text-decoration: whitesmoke;
}
</style>
</head>
<body>
	<table>
		<h1>All Students Record</h1>
		<thead>
			<tr>
				<th>S.No</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Father's Name</th>
				<th>Email</th>
				<th>Class</th>
				<th>Age</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>

			<%
				try {
					int sno = 1;
					String driver = "com.mysql.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3306/EAD_Session3";
					String dbname = "root";
					String dbpassword = "admin";
					Class.forName(driver);
					Connection con = DriverManager.getConnection(url, dbname,
							dbpassword);
					Statement stmt = con.createStatement();
					String sqlQuery = "SELECT * from StudentDetails";
					ResultSet rs = stmt.executeQuery(sqlQuery);
					while (rs.next()) {
			%>
			<tr>
				<td>
					<%
						out.print(sno);
								sno++;
					%>
				</td>
				<td><%=rs.getString("firstName")%></td>
				<td><%=rs.getString("lastName")%></td>
				<td><%=rs.getString("fatherName")%></td>
				<td><%=rs.getString("email")%></td>
				<td><%=rs.getString("class")%></td>
				<td><%=rs.getString("age")%></td>
				<td><a
					href="http://localhost:8080/StudentMgmtSystem/StudentProfile.jsp?email=<%out.println(rs.getString("email"));%>"><span
						class="glyphicon glyphicon-user"></span> Edit </a></td>
			</tr>
			<%
				}
			%>
			<%
				} catch (Exception e) {
					e.printStackTrace();
				}
			%>
		</tbody>
	</table>
</body>
</html>