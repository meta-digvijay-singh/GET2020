package com.metacube.metaparkingsystemv2.daoimpl;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.EmployeeDao;
import com.metacube.metaparkingsystemv2.models.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Employee getEmployeeById(int empId) {
		System.out.println("In employee by id...");
		Employee employee;
		employee = jdbcTemplate.queryForObject(selectEmployee, new Object[] {empId}, new BeanPropertyRowMapper<>(Employee.class));
		if (employee == null) {
			employee = new Employee();
		}
		return employee;
	}

	@Override
	public boolean updateEmployee(int empId, Employee employee) {
		String fullName = employee.getFullName();
		String gender = employee.getGender();
		String emailId = employee.getEmailId();
		String password = employee.getPassword();
		String confirmPassword = employee.getPassword();
		String contactNumber = employee.getContactNumber();
		String orgName = employee.getOrgName();
		Object[] args = new Object[] {fullName, gender, emailId, password, confirmPassword, contactNumber, orgName, empId};
		int[] mysqlArgTypes = new int[8];
		for (int index = 0; index <= 6; index++) {
			mysqlArgTypes[index] = Types.VARCHAR;
		}
		mysqlArgTypes[7] = Types.INTEGER;
		int rowsAffected = jdbcTemplate.update(updateEmployee, args, mysqlArgTypes);
		return rowsAffected != 0;
	}

	@Override
	public int addEmployee(Employee employee) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Employee").usingColumns("fullName", "gender", "emailId", "password", "confirmPassword", "contactNumber", "orgName");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		insertActor.execute(param);
		int empId =  jdbcTemplate.queryForObject(lastRecord, new Object[0], Integer.class) - 1;
		return empId;
	}

	public int getEmployeeId(String emailId) {
		System.out.println("In employee id...");
		Integer empId = -1;
		try {
			empId = jdbcTemplate.queryForObject(getEmployeeIdByEmail, new Object[] {emailId}, Integer.class);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Employee Id : " + empId);
		return empId;
	}

	public String getOrgName(int empId) {
		String orgName = jdbcTemplate.queryForObject(selectOrgName, new Object[] {empId}, String.class);
		return orgName;
	}

	public List<Employee> getFriends(int empId) {
		String orgName = getOrgName(empId);
		List<Employee> friends = jdbcTemplate.query(selectFriends, new Object[] {orgName, empId}, new BeanPropertyRowMapper<>(Employee.class));
		return friends;
	}
}
