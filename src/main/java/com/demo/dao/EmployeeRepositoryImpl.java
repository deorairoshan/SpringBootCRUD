package com.demo.dao;

import static com.demo.util.QueryProvider.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.models.Address;
import com.demo.models.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private Map<Integer, Employee> employeeDetails = new HashMap<>();

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public EmployeeRepositoryImpl() {
		Employee emp = new Employee();
		emp.setId(101);
		emp.setFirstName("Roshan");
		emp.setLastName("Deorai");
		emp.setEmail("deorairoshan@gmail.com");
		emp.setPhone("9665975525");

		Address address = new Address();
		address.setStreet("Hinjewadi Road");
		address.setArea("Dange Chowk");
		address.setState("Maharashtra");
		address.setCity("Pune");
		address.setCountry("India");
		address.setZip("411033");
		address.setCountry("India");
		emp.setAddress(address);
		employeeDetails.put(101, emp);
	}

	public List<Employee> getAll() {
		employeeDetails = namedParameterJdbcTemplate.query(GET_ALL_EMPLOYEES, new EmployeeResultExtractor());
		return new ArrayList<Employee>(employeeDetails.values());
	}

	public Employee get(int empId) {

		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("empId", empId);

		// return employeeDetails.get(id);
		return (Employee) namedParameterJdbcTemplate.queryForObject(GET_EMPLOYEE, namedParameters,
				new EmployeeRowMapper());
	}

	public void save(Employee employee) {

		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("firstName", employee.getFirstName());
		namedParameters.put("lastName", employee.getLastName());
		namedParameters.put("email", employee.getEmail());
		namedParameters.put("phone", employee.getPhone());
		namedParameters.put("street", employee.getAddress().getStreet());
		namedParameters.put("area", employee.getAddress().getArea());
		namedParameters.put("city", employee.getAddress().getCity());
		namedParameters.put("state", employee.getAddress().getState());
		namedParameters.put("country", employee.getAddress().getCountry());
		namedParameters.put("zip", employee.getAddress().getZip());

		namedParameterJdbcTemplate.update(INSERT_EMPLOYEE, namedParameters);
		// this.employeeDetails.put(employee.getId(), employee);
	}

	public void update(Employee employee) {

		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("id", employee.getId());
		namedParameters.put("firstName", employee.getFirstName());
		namedParameters.put("lastName", employee.getLastName());
		namedParameters.put("email", employee.getEmail());
		namedParameters.put("phone", employee.getPhone());
		namedParameters.put("street", employee.getAddress().getStreet());
		namedParameters.put("area", employee.getAddress().getArea());
		namedParameters.put("city", employee.getAddress().getCity());
		namedParameters.put("state", employee.getAddress().getState());
		namedParameters.put("country", employee.getAddress().getCountry());
		namedParameters.put("zip", employee.getAddress().getZip());

		namedParameterJdbcTemplate.update(UPDATE_EMPLOYEE, namedParameters);
		// this.employeeDetails.put(employee.getId(), employee);
	}

	public void delete(int id) {

		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put("id", id);

		namedParameterJdbcTemplate.update(DELETE_EMPLOYEE, namedParameters);
		// this.employeeDetails.remove(id);
	};

}
