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
}
