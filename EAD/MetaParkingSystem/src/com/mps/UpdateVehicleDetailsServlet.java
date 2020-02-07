package com.mps;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mps.dao.PassDao;
import com.mps.dao.VehicleDao;
import com.mps.pojo.Pass;
import com.mps.pojo.Vehicle;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/updatevehicledetails")
public class UpdateVehicleDetailsServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		float passPrice = Float.parseFloat(request.getParameter("passPrice"));
		String vehicleName = request.getParameter("vehicleName");
		String vehicleNumber = request.getParameter("vehicleNumber");
		String vehicleType = request.getParameter("vehicleType");
		String vehicleIdentification = request.getParameter("vehicleIdentification");
		
		System.out.println(employeeId + " " + vehicleName + " " + vehicleNumber + " " + vehicleType + " " + vehicleIdentification + " " + passPrice);
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName(vehicleName);
		vehicle.setVehicleNumber(vehicleNumber);
		vehicle.setVehicleType(vehicleType);
		vehicle.setDescription(vehicleIdentification);
		HttpSession session = request.getSession();
		if (VehicleDao.updateVehicle(vehicle, employeeId)) {
			session.setAttribute("employeeVehicle", vehicle);
		} else {
			response.sendRedirect("homepage.jsp");
		}
		Pass newPass = (Pass) session.getAttribute("employeePass");
		newPass.setPrice(passPrice);
		if (PassDao.updatePass(newPass, employeeId)) {
			session.setAttribute("employeePass", newPass);
		}
		response.sendRedirect("homepage.jsp");
	}

}
