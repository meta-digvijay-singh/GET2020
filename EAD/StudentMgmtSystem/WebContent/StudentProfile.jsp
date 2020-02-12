<%@ page language="java" import="java.sql.*,java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Student Data</title>
<style>
input{ margin:10px;
}
input,select{
margin:2px;
padding:2px;}
</style>
</head>
<body>
<form action="EditStudent" method="post">
<table>
        <%
		try {
		//	int sno=1;
			String email = request.getParameter("email");
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/EAD_Session3";
			String dbname = "root";
			String dbpassword = "admin";
			Class.forName(driver);   
			Connection con = DriverManager.getConnection(url,dbname,dbpassword);
			Statement stmt=con.createStatement();
			String sqlQuery = "SELECT * from StudentDetails where email='"+email+"'";
			ResultSet rs = stmt.executeQuery(sqlQuery);
			while(rs.next()){
		%>
		     <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName" value="<%=rs.getString("firstName" )%>"></td>
            </tr>
            <tr>
                <td>Last Name</td>
                <td><input type="text" name="lastName" value="<%=rs.getString("lastName" )%>"></td>
            </tr>
            <tr>
                <td>Father's Name</td>
                <td><input type="text" name="fatherName" value="<%=rs.getString("fatherName" )%>"></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="text" name="email" value="<%=rs.getString("email" )%>" readonly></td>
            </tr>
            <tr>
                <td>Age</td>
                <td><input type="text" name="age" value="<%=rs.getString("age" )%>"></td>
            </tr>
         <tr>
         	<td>Class</td>
         	<td>
	        <select name="class">
		        <option value="1">1</option>
		        <option value="2">2</option>
		        <option value="3">3</option>
		        <option value="4">4</option>
		        <option value="5">5</option>
		        <option value="6">6</option>
		        <option value="7">7</option>
		        <option value="8">8</option>
		        <option value="9">9</option>
		        <option value="10">10</option>
		        <option value="11">11</option>
		        <option value="12">12</option>
			</select></td>
        
        </tr>
           
         <tr>
       	 	<td></td>
        	<td><input type="submit" value ="Save"></td>
        </tr>
		 <%
        }
        %>
        <%
		} catch (Exception e) {
			e.printStackTrace();
		}
        %>
    </table>
    </form>
    
</body>
</html>