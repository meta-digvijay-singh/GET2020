package com.metacube.metaparkingsystemv2.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.PassInfoDao;

@Repository
public class PassInfoDaoImpl implements PassInfoDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PassInfoDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int getPassId(String passType, String vehicleType) {
		int passId = jdbcTemplate.queryForObject(selectPassId, new Object[] {passType, vehicleType}, Integer.class);
		return passId;
	}

	public String getPassType(int passId) {
		String passType = jdbcTemplate.queryForObject(selectPassType, new Object[] {passId}, String.class);
		return passType;
	}

	public double getPassPrice(int passId) {
		double passPrice = jdbcTemplate.queryForObject(selectPassPrice, new Object[] {passId}, Double.class);
		return passPrice;
	}
}
