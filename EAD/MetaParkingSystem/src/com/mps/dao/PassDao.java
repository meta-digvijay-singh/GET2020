package com.mps.dao;

import java.sql.*;

import com.mps.pojo.Pass;
import com.mps.pojo.Vehicle;

public class PassDao {
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
	
	public static int addPass(Pass pass, int employeeId) throws SQLException {
		Connection con = createConnection();
		String query = "INSERT INTO Pass (PassType, Price, Eid) values (?, ?, ?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, pass.getPassType());
		st.setFloat(2, pass.getPrice());
		st.setInt(3, employeeId);
		int rowsAffected = st.executeUpdate();
		return rowsAffected;
		
	}
	
	public static Pass getPassDetails(int empId) {
		Connection con = createConnection();
		String query = "SELECT * FROM Pass where Eid = " + empId + ";";
		Pass empPass = new Pass();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				empPass.setPassType(rs.getString("PassType"));
				empPass.setPrice(rs.getFloat("Price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empPass;
	}
	
	public static boolean updatePass(Pass newPass, int empId) {
		Connection con = createConnection();
		String query = "UPDATE Pass set PassType = ?, Price = ? where Eid = ?";
		boolean result = false;
		int rowsAffected = 0;
		try {
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, newPass.getPassType());
			st.setFloat(2, newPass.getPrice());
			st.setInt(3, empId);
			
			rowsAffected = st.executeUpdate();
			if (rowsAffected != 0) {
				result = true;
			}
			System.out.println(rowsAffected + " rows affected.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
