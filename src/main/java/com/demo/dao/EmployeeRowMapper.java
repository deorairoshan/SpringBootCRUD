package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.demo.models.Address;
import com.demo.models.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("id"));
		emp.setFirstName(rs.getString("firstName"));
		emp.setLastName(rs.getString("lastName"));
		emp.setEmail(rs.getString("email"));
		emp.setPhone(rs.getString("phone"));
		
		Address address = new Address();
		address.setStreet(rs.getString("street"));
		address.setArea(rs.getString("area"));
		address.setState(rs.getString("state"));
		address.setCity(rs.getString("city"));
		address.setCountry(rs.getString("country"));
		address.setZip(rs.getString("zip"));
		emp.setAddress(address);
		return emp;
	}

	
}
