package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeRepository;
import com.demo.models.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> getAll() {
		return employeeRepository.getAll();
	}

	public Employee get(int id) {
		return employeeRepository.get(id);
	}

	public void save(Employee employee) {
		this.employeeRepository.save(employee);
	}

	public void update(Employee employee) {
		this.employeeRepository.update(employee);
	}

	public void delete(int id) {
		this.employeeRepository.delete(id);
	};
}
