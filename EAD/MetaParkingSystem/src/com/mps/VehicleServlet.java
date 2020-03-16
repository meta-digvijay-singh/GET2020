package com.mps;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mps.dao.VehicleDao;
import com.mps.pojo.Vehicle;
public class VehicleServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vehicleName = request.getParameter("vehicleName");
		String vehicleNumber = request.getParameter("vehicleNumber");
		String vehicleType = request.getParameter("vehicleType");
		String identification = request.getParameter("identification");
		int eid = Integer.parseInt(request.getParameter("eid"));
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName(vehicleName);
		vehicle.setVehicleNumber(vehicleNumber);
		vehicle.setVehicleType(vehicleType);
		vehicle.setDescription(identification);
		try {
			VehicleDao.addVehicle(vehicle, eid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(vehicleName + " " + vehicleNumber + " " + vehicleType + " " + identification + " " + eid);
	}

}
