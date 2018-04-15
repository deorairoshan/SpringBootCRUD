package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.demo.models.Address;
import com.demo.models.Employee;

public class EmployeeResultExtractor implements ResultSetExtractor<Map<Integer, Employee>> {

	@Override
	public Map<Integer, Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

		Map<Integer, Employee> employeeMap = new HashMap<>();
		Employee emp = null;
		Address address = null;
		while (rs.next()) {
			emp = new Employee();
			emp.setId(rs.getInt("id"));
			emp.setFirstName(rs.getString("firstName"));
			emp.setLastName(rs.getString("lastName"));
			emp.setEmail(rs.getString("email"));
			emp.setPhone(rs.getString("phone"));

			address = new Address();
			address.setStreet(rs.getString("street"));
			address.setArea(rs.getString("area"));
			address.setState(rs.getString("state"));
			address.setCity(rs.getString("city"));
			address.setCountry(rs.getString("country"));
			address.setZip(rs.getString("zip"));
			emp.setAddress(address);
			employeeMap.put(emp.getId(), emp);
		}
		return employeeMap;
	}

}
