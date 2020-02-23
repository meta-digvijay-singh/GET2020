package com.metacube.metaparkingsystemv2.daoimpl;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.VehicleDao;
import com.metacube.metaparkingsystemv2.models.Vehicle;

@Repository
public class VehicleDaoImpl implements VehicleDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public VehicleDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Vehicle getVehicle(int vehicleId) {
		Vehicle vehicle = jdbcTemplate.queryForObject(selectVehicle, new Object[] {vehicleId}, new BeanPropertyRowMapper<>(Vehicle.class));
		return vehicle;
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle, int vehicleId) {
		String vehicleName = vehicle.getVehicleName();
		String type = vehicle.getType();
		String vehicleNumber = vehicle.getVehicleNumber();
		String identification = vehicle.getIdentification();
		int passId = vehicle.getPassId();
		Object[] args = new Object[] {vehicleName, type, vehicleNumber, identification, passId, vehicleId};
		int[] mysqlArgTypes = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER};
		int rowsAffected = jdbcTemplate.update(updateVehicle, args, mysqlArgTypes);
		return rowsAffected != 0;
	}

	@Override
	public int addVehicle(Vehicle vehicle) {
		int vehicleId = -1;
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Vehicle").usingColumns("vehicleName", "type", "vehicleNumber", "identification", "empId", "passId");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(vehicle);
		insertActor.execute(param);
		vehicleId = jdbcTemplate.queryForObject(lastRecord, new Object[0], Integer.class) - 1;
		return vehicleId;
	}

	public int getVehicleIdByEmpId(int empId) {
		int vehicleId = jdbcTemplate.queryForObject(selectVehicleIdByEmpId, new Object[] {empId}, Integer.class);
		return vehicleId;
	}
}
