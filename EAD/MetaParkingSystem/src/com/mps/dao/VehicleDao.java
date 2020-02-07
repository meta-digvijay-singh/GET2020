package com.mps.dao;

import java.sql.*;

import com.mps.pojo.Pass;
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
	
	public static Vehicle getVehicle(int empId) {
		Connection con = createConnection();
		String query = "SELECT * FROM Vehicle where Eid = " + empId + ";";
		Vehicle empVehicle = new Vehicle();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				empVehicle.setVehicleName(rs.getString("VehicleName"));
				empVehicle.setVehicleNumber(rs.getString("VehicleNumber"));
				empVehicle.setVehicleType(rs.getString("VehicleType"));
				empVehicle.setDescription(rs.getString("Indentification"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empVehicle;
	}
	
	public static boolean updateVehicle(Vehicle newVehicle, int empId) {
		Connection con = createConnection();
		String query = "UPDATE Vehicle set vehicleName = ?, vehicleNumber = ?, vehicleType = ?, Indentification = ? where Eid = ?";
		int rowsAffected = 0;
		boolean result = false;
		try {
			PreparedStatement st = con.prepareStatement(query);
			
			st.setString(1, newVehicle.getVehicleName());
			st.setString(2, newVehicle.getVehicleNumber());
			st.setString(3, newVehicle.getVehicleType());
			st.setString(4, newVehicle.getDescription());
			st.setInt(5, empId);
			
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
