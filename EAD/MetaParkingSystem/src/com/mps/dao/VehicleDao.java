package com.mps.dao;

import java.sql.*;

import com.mps.pojo.Vehicle;

public class VehicleDao {
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
	
	public static int addVehicle(Vehicle vehicle, int employeeId) throws SQLException {
		Connection con = createConnection();
		String query = "INSERT INTO Vehicle values (?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, vehicle.getVehicleName());
		st.setString(2, vehicle.getVehicleNumber());
		st.setString(3, vehicle.getVehicleType());
		st.setString(4, vehicle.getDescription());
		st.setInt(5, employeeId);
		int rowsAffected = st.executeUpdate();
		return rowsAffected;
	}
}
