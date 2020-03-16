package com.mps.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mps.pojo.Employee;


public class EmployeeDao {
	
	private static final String driverPath = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/metacubeparkingdb";
	private static final String userName = "root";
	private static final String password = "admin";
	
	private static Connection createConnection() {
		try {
			Class.forName(driverPath);
			Connection con = DriverManager.getConnection(url, userName, password);
			return con;
		} catch (Exception e) {
			System.out.println("Something went wrong.");
			return null;
		}
	}
	
	private static int getNextId(String databaseName, String tableName, Connection con) throws SQLException {
		String query = "SELECT AUTO_INCREMENT FROM INFORMATION_SCHEMA.TABLES"
						+ " WHERE TABLE_SCHEMA = ? AND TABLE_NAME = ?;";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, databaseName);
		st.setString(2,  tableName);
		ResultSet rs = st.executeQuery();
		rs.next();
		return ((int) rs.getInt("AUTO_INCREMENT"));
	}
	
	public static int addEmployee(Employee emp) throws SQLException {
		Connection con = createConnection();
		String query = "INSERT INTO Employee (Eid, FirstName, LastName, Gender, EmailId, Password, ConfirmPassword, ContactNumber, OrgName)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, emp.getEid());
		st.setString(2, emp.getEmpFirstName());
		st.setString(3, emp.getEmpLastName());
		st.setString(4, emp.getGender());
		st.setString(5, emp.getEmailId());
		st.setString(6, emp.getPassword());
		st.setString(7, emp.getConfirmPassword());
		st.setLong(8, emp.getMobileNumber());
		st.setString(9, emp.getOrgName());
		int rowsAffected = st.executeUpdate();
		int employeeId = getNextId("metacubeparkingdb", "employee", con) - 1;
		System.out.println(rowsAffected + " row(s) affected.");
		return employeeId;
	}
	
	public static Employee getEmployee(String emailId, String password) {
		Connection con = createConnection();
		String query = "SELECT * from Employee where EmailId = ? and Password = ?;";
		Employee emp = new Employee();
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, emailId);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				emp.setEid(rs.getInt("Eid"));
				emp.setEmpFirstName(rs.getString("FirstName"));
				emp.setEmpLastName(rs.getString("LastName"));
				emp.setGender(rs.getString("gender"));
				emp.setEmailId(rs.getString("EmailId"));
				emp.setPassword(rs.getString("Password"));
				emp.setMobileNumber(rs.getLong("ContactNumber"));
				emp.setOrgName(rs.getString("OrgName"));
				return emp;
			} 
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		
	}
	
	public static boolean isValidEmail(String emailId, String password) {
		Connection con = createConnection();
		String query = "SELECT FirstName from Employee where EmailId = ? and Password = ?;";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setString(1, emailId);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public static int getEmployeeId(String emailId, String password) {
		Connection con = createConnection();
		String query = "SELECT Eid FROM Employee WHERE EmailId = ? and Password = ?";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, emailId);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				return rs.getInt("Eid");
			} else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}	
	}
	
	public static boolean updateEmployee(Employee emp) {
		Connection con = createConnection();
		String query = "update Employee set FirstName = ?, LastName = ?, EmailId = ?, Password = ?, ConfirmPassword = ?, ContactNumber = ?, OrgName = ? where Eid = ?";
		PreparedStatement st;
		try {
			st = con.prepareStatement(query);
			st.setString(1, emp.getEmpFirstName());
			st.setString(2, emp.getEmpLastName());
			st.setString(3, emp.getEmailId());
			st.setString(4, emp.getPassword());
			st.setString(5, emp.getPassword());
			st.setLong(6, emp.getMobileNumber());
			st.setString(7, emp.getOrgName());
			st.setInt(8, emp.getEid());
			int rowsAffected = st.executeUpdate();
			if (rowsAffected != 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<Employee> searchFriends(int empId) {
		Connection con = createConnection();
		String orgNameQuery = "SELECT OrgName from Employee where Eid = " + empId;
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(orgNameQuery);
			rs.next();
			String orgName = rs.getString("OrgName");
			
			String query = "SELECT * FROM EMPLOYEE WHERE ORGNAME = ? AND EID <> ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, orgName);
			pst.setInt(2, empId);
			ResultSet rs2 = pst.executeQuery();
			List<Employee> employees = new ArrayList<Employee>();
			int index = 0;
			while(rs2.next()) {
				employees.add(new Employee());
				employees.get(index).setEmpFirstName(rs2.getString("FirstName"));
				employees.get(index).setEmpLastName(rs2.getString("LastName"));
				employees.get(index).setEmailId(rs2.getString("EmailId"));
				employees.get(index).setGender(rs2.getString("gender"));
				employees.get(index).setMobileNumber(rs2.getLong("ContactNumber"));
				employees.get(index).setOrgName(rs2.getString("OrgName"));
				index++;
			}
			return employees;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Employee>();
		}
	}
}
